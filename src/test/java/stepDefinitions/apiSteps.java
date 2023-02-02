package stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import io.restassured.path.json.JsonPath;

public class apiSteps {
    Response response;
    @When("hit POST register successfull")
    public void hit_post_register_successfull() {
        RestAssured.baseURI = "https://reqres.in";
        RequestSpecification request = RestAssured.given();
        request.header("Content-Type", "application/json");
        response =  request.body("{\n" +
                "    \"email\": \"eve.holt@reqres.in\",\n" +
                "    \"password\": \"pistol\"\n" +
                "}").post("/api/register");
    }
    @Then("Status code is 200")
    public void status_code_is() {
        Assert.assertEquals(200, response.getStatusCode());
    }
    @Then("token not null")
    public void token_not_null() {
        String jsonString = response.asString();
        String token = JsonPath.from(jsonString).get("token");
        Assert.assertNotNull(token);
    }
}
