package co.getmehired.getmehired.model.dto;

import java.util.Date;

import co.getmehired.getmehired.model.Citizenship;
import co.getmehired.getmehired.model.Degree;
import co.getmehired.getmehired.model.EmploymentStatus;
import co.getmehired.getmehired.model.Immigration;
import co.getmehired.getmehired.model.Objective;
import co.getmehired.getmehired.model.Support;
import co.getmehired.getmehired.model.TimezoneEnum;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TalentDTO {

	private String id;

	private String name; 

	private String phoneNumber;

	private String emailAddress;

	private TimezoneEnum timezone;

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

	private Support suuportNeeded;

	private Objective objective;

	private EmploymentStatus employmentStart;

	private Integer salaryStart;

	private String cuurrentJob;

	private String currentEmployer;

	private Integer jobSalary;

	private String newEmployer;

	private String newPosition;

	private Date jobStartdate;

	private String jobStartdateStr;
	
	private String resumeFileId;

}
