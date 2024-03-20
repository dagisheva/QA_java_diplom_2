package tests;

import helpers.Steps;
import helpers.TestData;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.Response;
import org.junit.After;
import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;

public class CreateUserTests extends BaseTest {
    private final String email = TestData.generateEmail();
    private final String password = TestData.generatePassword();
    private final String name = TestData.generateLogin();
    private final String userExistsMessage = TestData.returnUserExistsMessage();
    Response response;
    String token;

    @Test
    @DisplayName("Create user")
    public void createUserTest() {
        response = Steps.createUser(email, password, name);
        response.then().body(successField, equalTo(true)).and().statusCode(statusCode200);
    }

    @Test
    @DisplayName("Create an existing user")
    public void createAnExistingUser() {
        response = Steps.createUser(email, password, name);
        Response responseError = Steps.createUser(email, password, name);
        responseError.then().body(successField, equalTo(false)).and().body(messageField,
                equalTo(userExistsMessage)).and().statusCode(statusCode403);
    }

    @After
    public void tearDown() {
        token = Steps.getAccessToken(response);
        Steps.deleteUser(token);
    }
}
