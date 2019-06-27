package co.getmehired.getmehired.rest;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.getmehired.getmehired.model.Talent;

@RestController
@CrossOrigin
public class HomeResource {

	//it will return all users //
	@GetMapping("/api/talents")
	public String getall(@RequestParam (value = "page",defaultValue ="1") int page,
			@RequestParam (value = "limit",defaultValue = "50") int limit,
			@RequestParam (value = "sort",required = false) String sort) {
		//return"Hello all"+"page:"+page+"limit:"+limit+"Sort:"+sort;
		return "{\"value\":\"Hello World Orni\"}" ;
	}
	
	// it will return only the specified user //
	@GetMapping(path="/api/talents/{name}")

	public Talent getTalent(@PathVariable String name) {
		//return "Hello:"+name;
		Talent t=new Talent();
		t.setName("orni");
		t.setBankAccount(11);
		t.setSsnNumber(765);
		
		return t;
	}

}
