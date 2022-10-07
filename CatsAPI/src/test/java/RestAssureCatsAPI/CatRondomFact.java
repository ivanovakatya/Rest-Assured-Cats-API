package RestAssureCatsAPI;

import static org.testng.Assert.*;

import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class CatRondomFact {
	
	@Test
    public void catsFactRequest() {
        Response response = given()
       
                .get("https://catfact.ninja/fact")
                .then()
                .extract().response();
        
        //Validate status code is 200
        assertEquals(200, response.statusCode());
        
        // Validate fact variable is present
        assertNotNull(response.jsonPath().get("fact"));
        // Validate response variable fact contain string
        assertTrue(response.jsonPath().get("fact") instanceof String);
        
        //Validate length variable is present
        assertNotNull(response.jsonPath().get("length")); 
        //Validate response variable length contains number
        assertTrue(response.jsonPath().get("length") instanceof Integer);
	}
}
