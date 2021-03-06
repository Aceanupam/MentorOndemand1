package com.example.demo.Skills;

import java.util.List;

import org.springframework.data.repository.Repository;

public interface SkillRepository extends Repository<Skill,Integer>{
	
	void delete(Skill user);
	List<Skill> findAll();
	Skill findOne(int id);
	Skill save(Skill skill);

}
