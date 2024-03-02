package json_model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Geo{

	@JsonProperty("lng")
	private String lng;

	@JsonProperty("lat")
	private String lat;

}