
import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class APITests {

	private static String BaseURL = "https://reqres.in";

	@Test
	public void canGetEmail() {
		String expectedEmail = "janet.weaver@reqres.in";

		Response response = given()
				.when()
				.get(BaseURL + "/api/users/2")
				.then()
				.extract()
				.response();
		
		String actualEmail = response.jsonPath().getString("data.email");

		Assert.assertEquals(actualEmail, expectedEmail);
	}

	@Test
	public void canPostLogin() {
		String expectedToken = "QpwL5tke4Pnpja7X4";
		
		String requestBody = "{\n" 
				+ "    \"email\": \"eve.holt@reqres.in\",\n"
				+ "    \"password\": \"cityslicka\"\n"
				+ "}";

		Response response = given()
				.header("Content-type", "application/json")
				.and()
				.body(requestBody)
				.when()
				.post(BaseURL + "/api/login")
				.then()
				.extract()
				.response();
		
		String actualToken = response.jsonPath().getString("token");

		Assert.assertEquals(actualToken, expectedToken);
	}

	@Test
	public void canDelete() {
		// HTTP Status 204 (No Content) indicates that the server has successfully
		// fulfilled the request and that there is no content to send in the
		// response payload body.
		int expectedStatusCode = 204;

		Response response = given()
				.when()
				.delete(BaseURL + "/api/users/2")
				.then()
				.extract()
				.response();
		
		int actualStatusCode = response.getStatusCode();

		Assert.assertEquals(actualStatusCode, expectedStatusCode);
	}

	@Test
	public void canPatch() {
		String expectedName = "morpheus2";

		String requestBody = "{\n" 
				+ "    \"name\": \"morpheus2\"\n" 
				+ "}";

		Response response = given()
				.header("Content-type", "application/json")
				.and()
				.body(requestBody)
				.when()
				.patch(BaseURL + "/api/users/2")
				.then()
				.extract()
				.response();

		String actualName = response.jsonPath().getString("name");
		String updatedTimeStamp = response.getHeader("Date");
		updatedTimeStamp = updatedTimeStamp.substring(0, updatedTimeStamp.length() - 7);

		Assert.assertEquals(actualName, expectedName);
		Assert.assertEquals(updatedTimeStamp, getFormattedCurrentTimeStamp());
	}

	@Test
	public void canPut() {
		String expectedName = "morpheus2";

		String requestBody = "{\n" 
				+ "    \"name\": \"morpheus2\"\n" 
				+ "}";

		Response response = given()
				.header("Content-type", "application/json")
				.and()
				.body(requestBody)
				.when()
				.put(BaseURL + "/api/users/2")
				.then()
				.extract()
				.response();

		String actualName = response.jsonPath().getString("name");
		String updatedTimeStamp = response.getHeader("Date");
		updatedTimeStamp = updatedTimeStamp.substring(0, updatedTimeStamp.length() - 7);

		Assert.assertEquals(actualName, expectedName);
		Assert.assertEquals(updatedTimeStamp, getFormattedCurrentTimeStamp());
	}

	@Test
	public void canGetSingleUserAsPOJO(){
		String expectedEmail = "janet.weaver@reqres.in";

		Response response = given()
				.when()
				.get(BaseURL + "/api/users/2")
				.then()
				.extract()
				.response();
		
		SingleUserRoot root = response.getBody().as(SingleUserRoot.class);
		String actualEmail = root.getData().getEmail();

		Assert.assertEquals(actualEmail, expectedEmail);

	}

	@Test
	public void canGetUserListAsPOJO() {
		int expectedSize = 6;

		Response response = given()
				.when()
				.get(BaseURL + "/api/users?page=2")
				.then()
				.extract()
				.response();
		
		ListUserRoot root = response.getBody().as(ListUserRoot.class);
		int actualSize = root.getData().size();

		Assert.assertEquals(actualSize, expectedSize);
		Assert.assertEquals(root.getData().get(0).getEmail(), "michael.lawson@reqres.in");

	}

	private String getFormattedCurrentTimeStamp() {
		final Date currentTime = new Date();
		final SimpleDateFormat sdf = new SimpleDateFormat("EEE, d MMM yyyy hh:mm");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		return sdf.format(currentTime);
	}
}
