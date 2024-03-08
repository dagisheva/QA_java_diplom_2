package tests;

import helpers.Methods;
import helpers.Steps;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.Response;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;
import pojo.Ingredient;
import pojo.UserOrders;

import static org.hamcrest.Matchers.equalTo;

public class GetOrderTests extends BaseUserTest {
    private Response testResponse;

    @Test
    @DisplayName("Get orders without authorization test")
    public void getOrdersWoAuth() {
        testResponse = Steps.getOrdersWoAuth();
        testResponse.then().body(successField, CoreMatchers.equalTo(false))
                .and().body(messageField, equalTo(message))
                .and().statusCode(statusCode401);
    }

    @Test
    @DisplayName("Get orders with authorization test")
    public void getOrdersWAuth() {
        int index = Methods.returnRandomIndex(Steps.ingredientIds());
        Ingredient ingredient = Steps.createIngredients(Steps.getIngredientIdByIndex(index));
        Response orderResponse = Steps.createOrderWithAuth(ingredient, token);
        int id = Steps.getOrderId(orderResponse);
        testResponse = Steps.getOrdersWithAuth(token);
        int actualOrderId = testResponse.getBody().as(UserOrders.class).getOrders().get(0).getNumber();
        testResponse.then().body(successField, CoreMatchers.equalTo(true))
                .and().statusCode(statusCode200);
        Assert.assertEquals("Expected Id should match order Id", id, actualOrderId);
    }
}
