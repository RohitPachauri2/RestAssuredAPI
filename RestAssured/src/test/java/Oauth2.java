import org.junit.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class Oauth2 {
	public static String baseuri = "https://api-m.sandbox.paypal.com";
	public static String accesstoken;
	@Test
	public void oauth2() {

		
		String endpoint = "/v1/oauth2/token";
		String clientid = "ARifzv5bxG9rzj1_SLriHSjFePZZVQTy_3ziNRjK8uKZZCBz_bDjYUEJP5Z-2SpuYjZNV3deXs9h-Sb9";
		String secret = "EKBCPk-sHCP68T_Cq4vjDQ4kWGU7o55rlgqkIKiVLKLhcF6OpjJD1MbCmsFQP4eT81poIxCQ2xP3rBMB";

		Response res = given().baseUri(baseuri).auth().preemptive().basic(clientid, secret)
				.param("grant_type","client_credentials").when().post(endpoint);
		
		System.out.println(res.prettyPrint());
		accesstoken=res.jsonPath().getString("access_token");
		String scope=res.jsonPath().getString("scope");
		String appid=res.jsonPath().getString("app_id");
		
		System.out.println("access_token: "+accesstoken);
		System.out.println("app_id: "+appid);
		System.out.println("scope: "+scope);
		
		
		Assert.assertEquals(200, res.getStatusCode());
		
	}
	@Test(dependsOnMethods = "oauth2")
	public void getmethodoauth2() {
		String getpath="/v1/invoicing/invoices";
		Response getres=given().baseUri(baseuri).auth().oauth2(accesstoken)
				.queryParam("page", 3)
				.queryParam("page_size", 4)
				.queryParam("total_count_required", true)
				.when().get(getpath);
		
		System.out.println(getres.getBody().asString());
		System.out.println(getres.getStatusLine());
		
		
	}
	
	
	
	

}
