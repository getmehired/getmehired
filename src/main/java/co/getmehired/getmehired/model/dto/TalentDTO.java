package co.getmehired.getmehired.model.dto;

import java.util.Date;

import co.getmehired.getmehired.model.Citizenship;
import co.getmehired.getmehired.model.Degree;
import co.getmehired.getmehired.model.EmploymentStatus;
import co.getmehired.getmehired.model.Immigration;
import co.getmehired.getmehired.model.Objective;
import co.getmehired.getmehired.model.Support;
import co.getmehired.getmehired.model.Timezone;
import lombok.Data;

@Data
public class TalentDTO {
	
	public TalentDTO(String id2, String name2, Integer phoneNumber2, String emailAddress2, Timezone timezone2,
			String immigrationExpiaryStr2, Date immigrationExpiary2, String address2, String ssnNumber2,
			Integer bankAccount2, Integer routingNumber2, Citizenship citizenship2, Immigration immigrationStatus2,
			Degree accademicDegree2, String degreeSubject2, Date graduationDate2, String graduationDateStr2,
			Support supportNeeded2, Objective objective2, EmploymentStatus employmentStart2, Integer salaryStart2,
			String currentJob2, String currentEmployer2, Integer jobSalary2, String newEmployer2, String newPosition2,
			Date jobStartdate2, String jobStartdateStr2) {
		// TODO Auto-generated constructor stub
	}

	private String id;
	
	private String name; 
	
	private Integer phoneNumber;
	
	private String emailAddress;
	
	private Timezone timezone;
	
	private String immigrationExpiaryStr;
	
	private Date immigrationExpiary;
	
	private String address;
	
	private String ssnNumber;
	
	private Integer bankAccount;
	
	private Integer routingNumber;
	
	private Citizenship citizenship;
	
	private Immigration immigrationStatus;
	
	private Degree accademicDegree;
	
	private String degreeSubject;
	
	private Date graduationDate;
	
	private String graduationDateStr;
	
	private Support supportNeeded;
	
	private Objective objective;
	
	private EmploymentStatus employmentStart;
	
	private Integer salaryStart;
	
	private String currentJob;
	
	private String currentEmployer;
	
	private Integer jobSalary;
	
	private String newEmployer;
	
	private String newPosition;
	
	private Date jobStartdate;
	
	private String jobStartdateStr;
	
}
