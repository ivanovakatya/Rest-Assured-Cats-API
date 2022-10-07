package RestAssureCatsAPI;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.response.Response;

public class ListOfCatFacts {
	private final ObjectMapper objectMapper = new ObjectMapper();
	
	
	@Test
	public void validateResponseVariableLengthContainNumber() throws JsonMappingException, JsonProcessingException {
		
	    Response response = given()
	            .when()
	            .get("https://catfact.ninja/facts")
	            .then()
	            .extract()
	            .response();
	    
	    //Validate status code is 200
        assertEquals(200, response.statusCode());
        
        //Response body is compared with object Mapper against the class file
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, true);
        
        
        //Created a  class file named GetData and Mapping the Json value by using  getter and setter methods
        GetData getData = new ObjectMapper().readValue(response.body().asString(), GetData.class);
        assertTrue(getData.getCurrentPage() >= 0);
        
        //Created another class file named Results for validating the list values
        for (int i = 0; i < getData.getResult().size(); i++) {
            final Results results = getData.getResult().get(i);
            
            //Validate fact variable contains string value
            assertTrue(!results.getFact().isEmpty());
            
            //Validate length variable contains numerical value
            assertTrue(results.getLength() >= 0);
        }
        

	}
	
}
