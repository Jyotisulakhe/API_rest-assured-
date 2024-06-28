package rest_assured;

import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class posthook_API {
	String url="https://posthook-api.mock.beeceptor.com"; //URL of website which we want to work on
	
	@Test(enabled=false)
	public void grtHooks() {
		
		//https://posthook-api.mock.beeceptor.com/v1/hooks
		RestAssured.baseURI=url; //for accessing url from url variable
		given().get("/v1/hooks").then().log().all();
		
		
		
	}
	
	@Test(enabled=false)
	public void scheduleHook() {
		RestAssured.baseURI=url; 
		given().contentType(ContentType.JSON).when().post("/v1/hooks").then().log().all();//using post create new
	}
	@Test(enabled=false)
	public void getHook() {
		RestAssured.baseURI=url; 
		given().get("/v1/hooks/88e3aa909-fb84-4495-944d-a4c192defe66").then().log().all();
		
	}
	
	@Test(enabled = true)
	public void deleteHook() {
		RestAssured.baseURI=url;
		given().delete("/v1/hooks/8e3aa909-fb84-4495-944d-a4c192defe66").then().log().all();//delete hook using delete method
	}
	
	@Test(enabled = true)
	public void updateHook() {
		RestAssured.baseURI=url;
		JSONObject js=new JSONObject();
		js.put("name","updated-project");
		js.put("domain", "api.example.com");
		js.put("headerAuthorization:", "");
		js.put( "minRetries",1);
		js.put("retryDelaySecs", 5);
		given().contentType("application/json").body(js.toJSONString()).when().put("/v1/projects/").then().log().all();//update data using put method
		
	}

}
