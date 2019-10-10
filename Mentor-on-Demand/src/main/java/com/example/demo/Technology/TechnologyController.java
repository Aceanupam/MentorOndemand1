package com.example.demo.Technology;

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
@RequestMapping({"/technology"})
@CrossOrigin(origins = "http://localhost:4200",maxAge = 3600)
public class TechnologyController {
	
	@Autowired
	private TechnologyService technologyService;

	@PostMapping
	public Technology create(@RequestBody Technology technology) {
		return technologyService.create(technology);
	}
	
	@GetMapping(path= {"/{technologyId}"})
	public Technology findOne(@PathVariable("technologyId") int technologyId)
	{
		return technologyService.findById(technologyId);
	}
	
	@PutMapping(path= {"/{technologyId}"})
	public Technology update(@PathVariable("technologyId") int technologyId, @RequestBody Technology user)
	{
		user.setTechnologyId(technologyId);
		return technologyService.update(user);
		
	}
	@DeleteMapping(path ={"/{technologyId}"})
    public Technology delete(@PathVariable("technologyId") int technologyId) {
        return technologyService.delete(technologyId);
    }

    @GetMapping
    public List<Technology> findAll(){
        return technologyService.findAll();
    }
    
    @GetMapping(path= {"/check/{technologyName}"})
	public boolean check(@PathVariable("technologyName") String technologyName) {
		String technologyId;
		technologyId=technologyService.check(technologyName);
		System.out.println(technologyId);
		if(technologyId==null)
			return true;
		else
			return false;
	}

	
}
