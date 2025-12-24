import java.io.File;

import org.testng.annotations.Test;

import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

public class FileUpload {
	String basepath = "https://httpbin.org";
	String endpoint = "post";
	File filetoupload = new File(
			"C:\\Users\\PC\\git\\newrestapirepo\\RestAssured\\test-output\\this is a text doc.txt");

	@Test
	public void FileUploadnew() {

		Response res = given()
				.baseUri(basepath)
				.contentType("multipart/form-data")
				.multiPart("file", filetoupload)
				.when().post(endpoint);
		res.prettyPrint();
	}



}
