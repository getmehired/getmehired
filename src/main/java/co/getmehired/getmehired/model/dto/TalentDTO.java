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
	
	
	public TalentDTO(String id2, String name2, Integer phoneNumber2, String emailAddress2, String address2,
			String calendlyUrl2, Timezone timezone2, String ssnNumber2, Integer bankAccount2, Integer routingNumber2,
			Citizenship citizenship2, Immigration immigrationStatus2, Date immigrationExpiary2, Degree accademicDegree2,
			String degreeSubject2, Date graduationDate2, Support suuportNeeded2, Objective objective2,
			EmploymentStatus employmentStat2, Integer salaryStart2, String cuurrentJob2, String currentEmployer2,
			Date jobStartdate2, Integer jobSalary2, String newEmployer2, String newPosition2) {
		// TODO Auto-generated constructor stub
	}

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
	


	/*public TalentDTO(Talent t){
		this.setId(t.getId());
		this.setName(t.getName());
		this.setPhoneNumber(t.getPhoneNumber());
		this.setEmailAddress(t.getEmailAddress());
		this.setAddress(t.getAddress());
		this.setCa*/
		
		
	
	
}
