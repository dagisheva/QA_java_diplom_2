package tests;

import helpers.ResponseFields;
import helpers.Steps;
import helpers.TestData;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.Response;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.hamcrest.Matchers.equalTo;

@RunWith(Parameterized.class)
public class CreateUserWoDataParamTests extends BaseTest {
    private static final String emailData = TestData.generateEmail();
    private static final String passwordData = TestData.generatePassword();
    private static final String nameData = TestData.generateLogin();
    private static final String emptyStringData = TestData.returnEmptyString();
    private final String successField = ResponseFields.SUCCESS.getValue();
    private final String messageField = ResponseFields.MESSAGE.getValue();
    private final String message = TestData.returnRequiredParametersMessage();
    Response response;

    private final String email;
    private final String password;
    private final String name;

    public CreateUserWoDataParamTests(String email, String password, String name) {
        this.email = email;
        this.password = password;
        this.name = name;
    }

    @Parameterized.Parameters
    public static Object[][] putData() {
        return new Object[][]{
                {emptyStringData, passwordData, nameData},
                {emailData, emptyStringData, nameData},
                {emailData, passwordData, emptyStringData},
        };
    }

    @Test
    @DisplayName("Create User w/o necessary data")
    public void createUserWoData() {
        response = Steps.createUser(email, password, name);
        response.then().body(successField, equalTo(false)).and().body(messageField,
                equalTo(message)).and().statusCode(statusCode403);
    }
}
