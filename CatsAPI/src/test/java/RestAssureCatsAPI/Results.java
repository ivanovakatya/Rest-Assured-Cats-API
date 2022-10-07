package RestAssureCatsAPI;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Results {
	 	
	 	@JsonProperty(value = "fact") String fact;
	
		public String getFact() {
			return fact;
		}
		
		public void setFact(String fact) {
			this.fact = fact;
		}
		
	    @JsonProperty(value = "length") int length;
		
		public int getLength() {
			return length;
		}
		
		public void setLength(int length) {
			this.length = length;
		}
}
