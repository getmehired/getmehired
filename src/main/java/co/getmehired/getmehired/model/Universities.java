package co.getmehired.getmehired.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@Document(collection = "Universities")
@AllArgsConstructor

public class Universities {

	@Id
	private String id;
	private String universityId;
	private String universityName;
	private String regionName;
	private String stateName;
	private String country;
	
	
}
