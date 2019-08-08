package co.getmehired.getmehired.rest;

import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.google.firebase.auth.FirebaseAuth;

import co.getmehired.getmehired.model.Mentor;
import co.getmehired.getmehired.model.Talent;
import co.getmehired.getmehired.model.dto.ProfileDTO;
import co.getmehired.getmehired.service.MentorService;
import co.getmehired.getmehired.service.TalentService;

@CrossOrigin
@RestController
public class ProfileResource {

	@Autowired
	private MentorService mentorService;
	@Autowired
	private TalentService talentService;

	@GetMapping("/api/profiles/me")
	public ProfileDTO getProfile(@RequestHeader String idToken) {

		if(!isValidUser(idToken)) {
			return null;
		}
		ProfileDTO profileDto;
		try {
			String firebaseId=FirebaseAuth.getInstance().verifyIdTokenAsync(idToken).get().getUid();
			String name=FirebaseAuth.getInstance().verifyIdTokenAsync(idToken).get().getName();
			String email=FirebaseAuth.getInstance().verifyIdTokenAsync(idToken).get().getEmail();

			if(this.talentService.emailExist(email) )
			{
				Talent t=this.talentService.getTalentByEmail(email).orElseGet(null);
				profileDto=new ProfileDTO(firebaseId, email, name, t, null);

			}
			else if(this.mentorService.emailExist(email)) {
				Mentor m=this.mentorService.getMentorsByEmail(email).orElseGet(null);
				profileDto =new ProfileDTO(firebaseId, email, name,null,m);

			} 
			else {
				profileDto=new ProfileDTO(firebaseId, email, name, null, null);

			}        

		} catch (InterruptedException | ExecutionException e) {
			return null;
		}

		return profileDto;

	}

	private boolean isValidUser(String idToken) {

		try {
			String uid=FirebaseAuth.getInstance().verifyIdTokenAsync(idToken).get().getUid();
			String name=FirebaseAuth.getInstance().verifyIdTokenAsync(idToken).get().getName();
			String email=FirebaseAuth.getInstance().verifyIdTokenAsync(idToken).get().getEmail();
		} catch (InterruptedException | ExecutionException e) {
			return false;
		}

		return true;
	}

}