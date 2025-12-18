
import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;

public class APIKEY {
@Test
public void getapikeymethod() {
	String baseUri = "https://api.openweathermap.org";
    String endpoint = "/data/2.5/weather";
    String apiKey = "7d6c30b7cab613c585b3e3b4e788b4cd";  // Replace with your actual API key

    // Make the GET request
    Response res = given()
        .baseUri(baseUri)
        .queryParam("lat", "28.4961")
        .queryParam("lon", "77.536")
        .queryParam("appid", apiKey)
        .when()
        .get(endpoint);

    // Print the full response (for debugging)
    System.out.println(res.getBody().asString());

    // Parse the response and extract specific details
    String weatherDescription = res.jsonPath().getString("weather[0].description");
    String name=res.jsonPath().getString("name");
    System.out.println("Description: "+weatherDescription+" "+" name: "+name);
	
}
    
}
