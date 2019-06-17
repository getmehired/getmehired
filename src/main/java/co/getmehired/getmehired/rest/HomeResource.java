package co.getmehired.getmehired.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeResource {

	@GetMapping("/api/talents")

	public String home() {
		return "Hello orni";
	}

}
