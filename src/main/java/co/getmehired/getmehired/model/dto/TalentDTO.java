package co.getmehired.getmehired.model.dto;

import java.util.Date;

import org.springframework.data.mongodb.core.mapping.Document;

import co.getmehired.getmehired.model.Citizenship;
import co.getmehired.getmehired.model.Degree;
import co.getmehired.getmehired.model.EmploymentStatus;
import co.getmehired.getmehired.model.Immigration;
import co.getmehired.getmehired.model.Objective;
import co.getmehired.getmehired.model.Support;
import co.getmehired.getmehired.model.Timezone;
import co.getmehired.getmehired.model.Talent;
import lombok.Data;
import lombok.AllArgsConstructor;

@Data
@AllArgsConstructor
public class TalentDTO {

	private String id;
	
	private String name; 
	
	private Integer phoneNumber;
	
	private String emailAddress;
	
	private String address;
	
	private String calendlyURL;
	
	private Timezone timezone;
	
    private String ssnNumber;
	
	private Integer bankAccount;
	
	private Integer routingNumber;
	
    private Citizenship citizenship;
	
	private Immigration immigrationStatus;
	
	private String immigrationExpiaryStr;
	
	private Date immigrationExpiary;
	
	private Degree accademicDegree;
	
	private String degreeSubject;
	
	//private String degreeInstitute;
	
	private Date graduationDate;
	
	private String graduationDateStr;
	
	private Support suuportNeeded;
	
	private Objective objective;
	
	private EmploymentStatus employmentStat;
	
	private Integer salaryStart;
	
	private String cuurrentJob;
	
	private String currentEmployer;
	
	private Date jobStartdate;
	
	private String jobStartdateStr;
	
	private Integer jobSalary;
	
	private String newEmployer;
	
	private String newPosition;
	
		
	
}
