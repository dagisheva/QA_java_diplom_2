package tests;

import helpers.ResponseCodes;
import helpers.Steps;
import helpers.TestData;
import io.restassured.response.Response;
import org.junit.After;
import org.junit.Before;

public class BaseUserTest extends BaseTest {
    protected String email;
    protected String password;
    protected String name;
    protected Response response;
    protected String token;
    protected int statusCode401;


    @Before
    public void userSetup() {
        email = TestData.generateEmail();
        password = TestData.generatePassword();
        name = TestData.generateLogin();
        statusCode401 = ResponseCodes.UNAUTHORIZED.getValue();
        response = Steps.createUser(email, password, name);
        token = Steps.getAccessToken(response);
    }

    @After
    public void tearDown() {
        Steps.deleteUser(token);
    }
}
