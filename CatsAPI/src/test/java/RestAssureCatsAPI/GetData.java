package RestAssureCatsAPI;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GetData {
	
	@JsonProperty(value = "current_page") int current_page;
	
	public int getCurrentPage() {
		return current_page;
	}
	
	public void setCurrentPage(int current_page) {
		this.current_page = current_page;
	}
   
    @JsonProperty(value = "data") List<Results> dataList;
    
    public List<Results> getResult() {
		return dataList;
	}
	
	public void setResult(List<Results> dataList) {
		this.dataList = dataList;
	}
    
}
