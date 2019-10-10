package com.example.demo.Technology;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class TechnologyServiceImpl implements TechnologyService{

	@Autowired
	private TechnologyRepository repository;
	
	@Override
	public Technology create(Technology user) {
		// TODO Auto-generated method stub
		return repository.save(user);
	}

	@Override
	public Technology delete(int technologyId) {
		// TODO Auto-generated method stub
		Technology technology=findById(technologyId);
		if(technology != null) {
			repository.delete(technology);
		}
		return technology;
	}

	@Override
	public List<Technology> findAll() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public Technology findById(int technologyId) {
		// TODO Auto-generated method stub
		return repository.findOne(technologyId);
	}

	@Override
	public Technology update(Technology technology) {
		// TODO Auto-generated method stub
		return repository.save(technology);
	}

	@Override
	public String check(String technologyName) {
		// TODO Auto-generated method stub
		return repository.check(technologyName);
	}

}
