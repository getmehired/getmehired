package co.getmehired.getmehired.model;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@Document(collection ="universities")
@AllArgsConstructor
public class University {
	@Id
	private String id;
	private String universityName;
	private String regionName;
	private String stateName;
	private String country;
}
