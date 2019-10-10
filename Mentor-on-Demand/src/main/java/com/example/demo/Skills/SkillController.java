package com.example.demo.Skills;

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
@RequestMapping({"/skill"})
@CrossOrigin(origins = "http://localhost:4200",maxAge = 3600)
public class SkillController {
	
	@Autowired
	private SkillService skillService;

	@PostMapping
	public Skill create(@RequestBody Skill skill) {
		return skillService.create(skill);
	}
	
	@GetMapping(path= {"/{skillId}"})
	public Skill findOne(@PathVariable("skillId") int skillId)
	{
		return skillService.findById(skillId);
	}
	
	@PutMapping(path= {"/{skillId}"})
	public Skill update(@PathVariable("skillId") int skillId, @RequestBody Skill skill)
	{
		skill.setSkillId(skillId);
		return skillService.update(skill);
		
	}
	@DeleteMapping(path ={"/{skillId}"})
    public Skill delete(@PathVariable("skillId") int skillId) {
        return skillService.delete(skillId);
    }

    @GetMapping
    public List<Skill> findAll(){
        return skillService.findAll();
    }

	
}
