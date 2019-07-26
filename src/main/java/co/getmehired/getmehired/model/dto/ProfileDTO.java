package co.getmehired.getmehired.model.dto;

import co.getmehired.getmehired.model.Mentor;
import co.getmehired.getmehired.model.Talent;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProfileDTO {
	
	private String firebaseId;
	private String email;
	private String name;
	private Talent talent;
	private Mentor mentor;

}
