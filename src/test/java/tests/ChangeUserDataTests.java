package tests;

import helpers.ResponseCodes;
import helpers.Steps;
import helpers.TestData;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.Response;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;
import pojo.User;
import pojo.UserAuth;

import static org.hamcrest.Matchers.equalTo;

public class ChangeUserDataTests extends BaseUserTest {
    private final String newEmail = TestData.generateEmail();
    private final String newPassword = TestData.generatePassword();
    private final String newName = TestData.generateLogin();
    private Response responseTest;

    @Test
    @DisplayName("Change unauthorized User data")
    public void unauthorizedUserChangeDataTest() {
        responseTest = Steps.changeUserDataWoAuthorization(newEmail, newPassword, newName);
        responseTest.then().body(successField, equalTo(false)).and().body(messageField, equalTo(message))
                .and().statusCode(statusCode401);
    }

    @Test
    @DisplayName("Change authorized User data and login with new data")
    public void authorizedUserDataChangeTest() {
        responseTest = Steps.changeUserDataWithAuthorization(newEmail, newPassword, newName, token);
        User renewedUser = responseTest.getBody().as(UserAuth.class).getUser();
        responseTest.then().statusCode(ResponseCodes.OK.getValue());
        Response loginResponse = Steps.loginUser(newEmail, newPassword);
        loginResponse.then().body(successField, CoreMatchers.equalTo(true))
                .and().statusCode(statusCode200);
        Assert.assertEquals("Email should be renewed", newEmail, renewedUser.getEmail());
        Assert.assertEquals("Name should be renewed", newName, renewedUser.getName());
    }
}
