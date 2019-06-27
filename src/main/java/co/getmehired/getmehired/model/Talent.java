package co.getmehired.getmehired.model;

import java.util.Date;

import javax.validation.constraints.NotBlank;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "talents")
public class Talent {
	
	@Id
	private String id;
	
	private String name; 
	
	private Integer phoneNumber;
	
	private String emailAddress;
	
	private Timezone timezone;
	
	private String immigrationExpiaryStr;
	
	private Date immigrationExpiary;
	
	private String address;
	
	@NotBlank(message = "SSN Number must not be empty")
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
	
}
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



    
     
  
}
