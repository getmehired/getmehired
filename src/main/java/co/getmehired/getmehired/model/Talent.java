package co.getmehired.getmehired.model;

import java.util.Date;

<<<<<<< HEAD
public class Talent {



	private String name;
    private Integer phoneNumber;
    private String emailAddress;
    private Timezone timezone;   
    private String immigrationExpiaryStr;
    private Date immigrationExpiary;
    private String address;
    private String calendlyUrl;
    private Integer ssnNumber;
    private Integer bankAccount;
    private Integer routingNumber;
    private Citizenship citizenship;
    private ImmigrationStatuts immigrationStatus;
    private String degreeSubject;
    private String graduationDate;
    private String objective;
    private Integer salaryStart;
    private String cuurrentJob;
    private String currentEmployer;  
    private String jobStartdate;
    private Integer jobSalary;
    private String newEmployer;
    private String newPosition;
    private String accademicDegree;
    private String suuportNeeded;
    private String employmentStart;

    
    public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(Integer phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	public Timezone getTimezone() {
		return timezone;
	}
	public void setTimezone(Timezone timezone) {
		this.timezone = timezone;
	}
	public Date getImmigrationExpiary() {
		return immigrationExpiary;
	}
	public void setImmigrationExpiary(Date immigrationExpiary) {
		this.immigrationExpiary = immigrationExpiary;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCalendlyUrl() {
		return calendlyUrl;
	}
	public void setCalendlyUrl(String calendlyUrl) {
		this.calendlyUrl = calendlyUrl;
	}
	public Integer getSsnNumber() {
		return ssnNumber;
	}
	public void setSsnNumber(Integer ssnNumber) {
		this.ssnNumber = ssnNumber;
	}
	public Integer getBankAccount() {
		return bankAccount;
	}
	public void setBankAccount(Integer bankAccount) {
		this.bankAccount = bankAccount;
	}
	public Integer getRoutingNumber() {
		return routingNumber;
	}
	public void setRoutingNumber(Integer routingNumber) {
		this.routingNumber = routingNumber;
	}
	public Citizenship getCitizenship() {
		return citizenship;
	}
	public void setCitizenship(Citizenship citizenship) {
		this.citizenship = citizenship;
	}
	public ImmigrationStatuts getImmigrationStatus() {
		return immigrationStatus;
	}
	public void setImmigrationStatus(ImmigrationStatuts immigrationStatus) {
		this.immigrationStatus = immigrationStatus;
	}
	public String getDegreeSubject() {
		return degreeSubject;
	}
	public void setDegreeSubject(String degreeSubject) {
		this.degreeSubject = degreeSubject;
	}
	public String getGraduationDate() {
		return graduationDate;
	}
	public void setGraduationDate(String graduationDate) {
		this.graduationDate = graduationDate;
	}
	public String getObjective() {
		return objective;
	}
	public void setObjective(String objective) {
		this.objective = objective;
	}
	public Integer getSalaryStart() {
		return salaryStart;
	}
	public void setSalaryStart(Integer salaryStart) {
		this.salaryStart = salaryStart;
	}
	public String getCuurrentJob() {
		return cuurrentJob;
	}
	public void setCuurrentJob(String cuurrentJob) {
		this.cuurrentJob = cuurrentJob;
	}
	public String getCurrentEmployer() {
		return currentEmployer;
	}
	public void setCurrentEmployer(String currentEmployer) {
		this.currentEmployer = currentEmployer;
	}
	public String getJobStartdate() {
		return jobStartdate;
	}
	public void setJobStartdate(String jobStartdate) {
		this.jobStartdate = jobStartdate;
	}
	public Integer getJobSalary() {
		return jobSalary;
	}
	public void setJobSalary(Integer jobSalary) {
		this.jobSalary = jobSalary;
	}
	public String getNewEmployer() {
		return newEmployer;
	}
	public void setNewEmployer(String newEmployer) {
		this.newEmployer = newEmployer;
	}
	public String getNewPosition() {
		return newPosition;
	}
	public void setNewPosition(String newPosition) {
		this.newPosition = newPosition;
	}
	public String getAccademicDegree() {
		return accademicDegree;
	}
	public void setAccademicDegree(String accademicDegree) {
		this.accademicDegree = accademicDegree;
	}
	public String getSuuportNeeded() {
		return suuportNeeded;
	}
	public void setSuuportNeeded(String suuportNeeded) {
		this.suuportNeeded = suuportNeeded;
	}
	public String getImmigrationExpiaryStr() {
		return immigrationExpiaryStr;
	}
	public void setImmigrationExpiaryStr(String immigrationExpiaryStr) {
		this.immigrationExpiaryStr = immigrationExpiaryStr;
	}
	public String getEmploymentStart() {
		return employmentStart;
	}
	public void setEmploymentStart(String employmentStart) {
		this.employmentStart = employmentStart;
	}



    
     
  
=======
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import co.getmehired.getmehired.validator.UniqueEmailAddress;
import lombok.Data;
import lombok.AllArgsConstructor;

@Data
@Document(collection = "talents")
@AllArgsConstructor
public class Talent {
	
	@Id
	private String id;
	
	
	@NotNull(message = " Must have a name Starting with a capital")
	@Pattern(regexp = "^[A-Za-z]*$")
	private String name; 
	
	@NotNull(message = " Must have a phone no in this format +1-XXX-XXX-XXXX")
	@Pattern(regexp="^\\+[1]{1}-\\d{3}-\\d{3}-\\d{4}$")
	private String phoneNumber;
	
	@UniqueEmailAddress
	private String emailAddress;
	
	@NotBlank(message = " Must have a valid address")
	private String address;
	
	@NotBlank(message = " Must have a valid Calendly URL")
    private String calendlyUrl;
	
	private Timezone timezone;
	
	@NotBlank(message = "SSN Number must not be empty")
	private String ssnNumber;
	
	@NotNull
	private Integer bankAccount;
	
	@NotNull
	private Integer routingNumber;
	

	private Citizenship citizenship;
	

	private Immigration immigrationStatus;
	

	private String immigrationExpiaryStr;
	

	private Date immigrationExpiary;
	
	
	private Degree accademicDegree;
	
	@NotBlank(message = " Must input a  subject")
	private String degreeSubject;
	

	private Date graduationDate;
	

	private String graduationDateStr;
	
	private Support suuportNeeded;
	
	private Objective objective;
	

	private EmploymentStatus employmentStat;
	
	@NotNull
	private Integer salaryStart;
	
	@NotBlank(message = " Must input your current job")
	private String currentJob;
	
	@NotBlank(message = " Must input your current employer")
	private String currentEmployer;
	

	private Date jobStartdate;
	

	private String jobStartdateStr;
	
	@NotNull
	private Integer jobSalary;
	
	@NotBlank(message = " Must input your new job")
	private String newEmployer;
	
	@NotBlank(message = " Must input your new position")
	private String newPosition;
	

	
>>>>>>> 9c3f42e9fbfdab8bda7070866b952abfd8aa372b
}
