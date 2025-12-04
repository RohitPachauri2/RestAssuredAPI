package DeserializationPackage;
import static io.restassured.RestAssured.*;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class Deseralization {

    String baseuri = "https://reqres.in/";
    String endpoint = "/api/users";

    @Test
    public void convertJsonToClassObject() {
        String requestBody = "{ \"name\": \"morpheus\", \"job\": \"ui tester\" }";

        Response res = 
            given()
                .baseUri(baseuri)
                .header("Content-Type", "application/json").header( "x-api-key","reqres_7e7d83a13696487788cf25ab4fec4bc4")
                .body(requestBody)
                
            .when()
                .post(endpoint);

        System.out.println(res.getBody().asString());
        System.out.println(res.getStatusLine());
        
        newdeserializedobject nso=res.as(newdeserializedobject.class);
        
        Assert.assertEquals(nso.name, "morpheus");
//        Assert.assertEquals(nso.id, "216");
        Assert.assertEquals(nso.job, "ui tester");
//        Assert.assertEquals(nso.createdAt, "2025-12-02T02:48:26.505Z");
        
        
    }
}
