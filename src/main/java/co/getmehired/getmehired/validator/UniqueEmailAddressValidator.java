package co.getmehired.getmehired.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import co.getmehired.getmehired.service.TalentService;

public class UniqueEmailAddressValidator implements ConstraintValidator<UniqueEmailAddress, String> {
    @Autowired
    private TalentService talentService;
    
    @Override
    public void initialize(UniqueEmailAddress email) {
     }
    
	@Override
	public boolean isValid(String email,ConstraintValidatorContext  cxt) {
		return !talentService.emailExist(email);
		
		
	}
}
