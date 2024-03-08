package tests;

import helpers.ConfigData;
import helpers.ResponseCodes;
import helpers.ResponseFields;
import helpers.TestData;
import io.restassured.RestAssured;
import org.junit.Before;

public class BaseTest {
    private final String baseUri = ConfigData.returnBaseUri();
    protected String successField;
    protected String messageField;
    protected String message;
    protected int statusCode200;
    protected int statusCode403;

    @Before
    public void setUp() {
        successField = ResponseFields.SUCCESS.getValue();
        messageField = ResponseFields.MESSAGE.getValue();
        message = TestData.returnYouShouldBeAuthorizedMessage();
        statusCode200 = ResponseCodes.OK.getValue();
        statusCode403 = ResponseCodes.FORBIDDEN.getValue();
        RestAssured.baseURI = baseUri;
    }
}
