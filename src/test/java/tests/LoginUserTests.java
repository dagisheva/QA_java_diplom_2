package tests;

import helpers.Steps;
import helpers.TestData;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.Response;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;

public class LoginUserTests extends BaseUserTest {
    private final String emptyString = TestData.returnEmptyString();
    private final String message = TestData.returnErrorMessage();

    Response responseTest;

    @Test
    @DisplayName("Login User test")
    public void loginUserTest() {
        responseTest = Steps.loginUser(email, password);
        responseTest.then().body(successField, equalTo(true))
                .and().statusCode(statusCode200);
    }

    @Test
    @DisplayName("Login User w/o email test")
    public void loginUserWoEmailTest() {
        responseTest = Steps.loginUser(emptyString, password);
        responseTest.then().body(successField, equalTo(false)).and()
                .body(messageField, equalTo(message))
                .and()
                .statusCode(statusCode401);
    }

    @Test
    @DisplayName("Login w/o password test")
    public void loginWoPasswordTest() {
        responseTest = Steps.loginUser(email, emptyString);
        responseTest.then().body(successField, equalTo(false)).and()
                .body(messageField, equalTo(message))
                .and()
                .statusCode(statusCode401);
    }
}
