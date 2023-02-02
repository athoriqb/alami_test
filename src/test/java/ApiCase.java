import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import org.junit.Test;


public class ApiCase {

    @Test
    public void testPositiveSearch(){
        RequestSpecification request = RestAssured.given();
        request.header("Content-Type", "application/json");

        request.queryParam("searchResult", "10");
        request.queryParam("searchString", "XYZ");

        Response res = request.post("https://vida.id/sample/json/search");

        int statusCode = res.getStatusCode();
        Assert.assertEquals(200, statusCode);

        String authorRes = res.jsonPath().getString("Details[0].Author");
        Assert.assertEquals("XYZ", authorRes);
    }

    @Test
    public void testNegativeSearch(){
        RequestSpecification request = RestAssured.given();
        request.header("Content-Type", "application/json");

        request.queryParam("searchResult", "10");
        request.queryParam("searchString", "$#!@$#@");

        Response res = request.post("https://vida.id/sample/json/search");

        int statusCode = res.getStatusCode();
        Assert.assertEquals(400, statusCode);

        String errorCode = res.jsonPath().getString("error.code");
        String errorDetails = res.jsonPath().getString("error.Details");
        Assert.assertEquals("1001", errorCode);
        Assert.assertEquals("Invalid String", errorDetails);
    }
}
