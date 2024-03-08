package tests;

import helpers.*;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import pojo.Ingredient;
import pojo.Order;
import pojo.OrderInfo;


import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

public class CreateOrderTests extends BaseUserTest {
    private Response testResponse;
    private final String ingredientIdsError = TestData.returnIngredientIdsError();
    private int index;

    @Test
    @DisplayName("Create order test")
    public void createOrder() {
        index = Methods.returnRandomIndex(Steps.ingredientIds());
        String expectedId = Steps.getIngredientIdByIndex(index);
        Ingredient ingredient = Steps.createIngredients(expectedId);
        testResponse = Steps.createOrderWithAuth(ingredient, token);
        Order order = testResponse.getBody().as(OrderInfo.class).getOrder();
        String actualId = order.getIngredients().get(0).get_id();
        String actualName = order.getOwner().getName();
        testResponse.then().body(successField, equalTo(true))
                .and().statusCode(ResponseCodes.OK.getValue());
        Assert.assertEquals("Ids should match", expectedId, actualId);
        Assert.assertEquals("Actual User name should match expected", name, actualName);
    }

    @Test
    @DisplayName("Create order w/o ingredients test")
    public void createOrderWoIngredients() {
        Ingredient ingredient = Steps.createIngredients();
        testResponse = Steps.createOrderWithAuth(ingredient, token);
        System.out.println(testResponse.getBody().asString());
        testResponse.then().body(successField, equalTo(false))
                .and().body(messageField, equalTo(ingredientIdsError))
                .and().statusCode(ResponseCodes.BAD_REQUEST.getValue());
    }

    @Test
    @DisplayName("Create order w/o authorization test")
    public void createOrderWoAuthorization() {
        index = Methods.returnRandomIndex(Steps.ingredientIds());
        Ingredient ingredient = Steps.createIngredients(Steps.getIngredientIdByIndex(index));
        testResponse = Steps.createOrderWoAuth(ingredient);
        Order order = testResponse.body().as(OrderInfo.class).getOrder();
        testResponse.then().body(successField, equalTo(true))
                .and().body(ResponseFields.NAME.getValue(), notNullValue())
                .and()
                .statusCode(ResponseCodes.OK.getValue());
        Assert.assertTrue("There should be order number", order.getNumber()>0);
    }

    @Test
    @DisplayName("Create order with invalid ingredients test")
    public void createOrderWithInvalidIngredients() {
        Ingredient ingredient = Steps.createIngredients(TestData.generateLogin());
        testResponse = Steps.createOrderWithAuth(ingredient, token);
        testResponse.then().statusCode(ResponseCodes.INTERNAL_SERVER_ERROR.getValue());
    }
}
