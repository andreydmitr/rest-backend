package guru.qa.restbackend;

import guru.qa.restbackend.domain.UserInfo;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.with;

public class BankControllerTest {

    private RequestSpecification spec = with()
            .baseUri("http://localhost:8080")
            .basePath("/");

    @Test
    void bankControllerTestDoLogin() {

    }

    @Test
    void bankControllerTestGetAllUsersInfo() {
        UserInfo[] getUsers=spec.get("user/getAll")
                .then()
                .statusCode(200)
                .extract()
                .response()
                .as(UserInfo[].class);
        System.out.println();
    }
}
