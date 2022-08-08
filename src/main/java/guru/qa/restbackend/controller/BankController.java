package guru.qa.restbackend.controller;

import guru.qa.restbackend.domain.LoginInfo;
import guru.qa.restbackend.domain.UserInfo;
import guru.qa.restbackend.exception.InvalidUserNameException;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jdk.jfr.Description;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
public class BankController {

    private Map<String, UserInfo> users = Map.of(
            "Andrei", UserInfo.builder().userName("Andrei").build(),
            "Olga", UserInfo.builder().userName("Olga").build(),
            "Ivan", UserInfo.builder().userName("Ivan").build()
    );

    @PostMapping("user/login")
    @Operation(summary = "LOGIN")
    public UserInfo doLogin(@RequestBody(required = false) LoginInfo loginInfo) {
        if (loginInfo.getUserName().equals("Andrei")) {
            return UserInfo.builder()
                    .loginDate(new Date())
                    .userName(loginInfo.getUserName())
                    .build();
        } else {
            throw new InvalidUserNameException();
        }
    }

    @GetMapping("user/getAll")
    @Operation(summary = "GET ALL USERS")

    public List<UserInfo> getAllUsersInfo() {
        return users
                .entrySet()
                .stream()
                .map(Map.Entry::getValue)
                .collect(Collectors.toList());
    }
}
