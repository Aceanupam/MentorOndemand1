package com.example.demo.Mentor;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200",maxAge = 3600)
@RequestMapping({"/mentors"})
public class MentorController {
	
	@Autowired
	private MentorService mentorService;

	@PostMapping
	public Mentor create(@RequestBody Mentor mentor) {
		return mentorService.create(mentor);
	}
	
	@GetMapping(path= {"/{mentorId}"})
	public Mentor findOne(@PathVariable("mentorId") int mentorId)
	{
		return mentorService.findById(mentorId);
	}
	
	@PostMapping(path= {"/changeStatus"})
	public Mentor changeStatus(@RequestBody Mentor mentor)
	{
		System.out.println("Inside");
		return mentorService.changeStatus(mentor);                                                                                                                                                                                                                                                                                                                                 
	}
	
	@GetMapping(path= {"/{userName}/{password}"})
	public Mentor findMentor(@PathVariable("userName") String userName,@PathVariable("password") String password)
	{
		return mentorService.findMentor(userName,password);
	}
	
	@GetMapping(path= {"/check/{userName}"})
	public boolean check(@PathVariable("userName") String userName) {
		String mentorId;
		mentorId=mentorService.check(userName);
		if(mentorId==null)
			return true;
		else
			return false;
	}
	
	@PutMapping(path= {"/{mentorId}"})
	public Mentor update(@PathVariable("mentorId") int mentorId, @RequestBody Mentor mentor)
	{
		mentor.setMentorId(mentorId);
		return mentorService.update(mentor);
		
	}
	@DeleteMapping(path ={"/{mentorId}"})
    public Mentor delete(@PathVariable("mentorId") int mentorId) {
        return mentorService.delete(mentorId);
    }

    @GetMapping
    public List<Mentor> findAll(){
        return mentorService.findAll();
    }

	
}
