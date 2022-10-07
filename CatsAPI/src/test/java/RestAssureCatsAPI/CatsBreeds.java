package RestAssureCatsAPI;

import org.testng.annotations.Test;

import io.restassured.response.Response;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertTrue;

import org.json.JSONArray;
import org.json.JSONObject;

import static io.restassured.RestAssured.given;

public class CatsBreeds {
	
	
	@Test
	public void validateResponseVariableLengthContainNumber() {
		
	    Response response = given()
	            .when()
	            .get("https://catfact.ninja/breeds")
	            .then()
	            .extract()
	            .response();
	    
	    //Validate status code is 200
        assertEquals(200, response.statusCode());
        
        //Validate Content-Type is present
        assertNotNull(response.getHeader("Content-Type"));
        
        //Validate response variable current_page is present and contains numerical value
        assertNotNull(response.jsonPath().get("current_page"));  
        assertTrue(response.jsonPath().get("current_page") instanceof Integer);

	    JSONObject responseObject = new org.json.JSONObject(response.body().asString());
	    JSONArray jsonArray = responseObject.getJSONArray("data");

	    for (int i = 0; i < jsonArray.length(); i++) {
	    	JSONObject cat = jsonArray.getJSONObject(i);
	    System.out.println(cat);
	        
	        //Validate all data fields contains string value
	        assertTrue(cat.get("breed") instanceof String);
	        assertTrue(cat.get("country") instanceof String);
	        assertTrue(cat.get("origin") instanceof String);
	        assertTrue(cat.get("coat") instanceof String);
	        assertTrue(cat.get("pattern") instanceof String);
	        
	        //Validate all data fields are present
	        assertNotNull(cat.get("breed"));	        
	        assertNotNull(cat.get("country"));	        
	        assertNotNull(cat.get("origin"));	        
	        assertNotNull(cat.get("coat"));
	        assertNotNull(cat.get("pattern"));
	    } 
	}
	
}
