package com.example.demo.Skills;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class SkillServiceImpl implements SkillService{

	@Autowired
	private SkillRepository repository;
	
	@Override
	public Skill create(Skill skill) {
		// TODO Auto-generated method stub
		return repository.save(skill);
	}

	@Override
	public Skill delete(int skillId) {
		// TODO Auto-generated method stub
		Skill skill=findById(skillId);
		if(skill != null) {
			repository.delete(skill);
		}
		return skill;
	}

	@Override
	public List<Skill> findAll() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public Skill findById(int skillId) {
		// TODO Auto-generated method stub
		return repository.findOne(skillId);
	}

	@Override
	public Skill update(Skill skill) {
		// TODO Auto-generated method stub
		return repository.save(skill);
	}

}
