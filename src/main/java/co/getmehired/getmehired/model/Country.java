package co.getmehired.getmehired.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
	@Document(collection ="countries")
	@AllArgsConstructor
	public class Country {
	    @Id
	    private String id;
	    private String name;
	    private String code;
	    private String flag;
	    private String dialCode;
	    private String currency;
}
