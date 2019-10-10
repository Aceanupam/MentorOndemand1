package com.example.demo.Technology;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

public interface TechnologyRepository extends Repository<Technology,Integer>{
	
	void delete(Technology technology);
	List<Technology> findAll();
	Technology findOne(int technologyId);
	Technology save(Technology technology);
	@Query("Select technology.technologyId from Technology technology where technology.techName=?")
	String check(String technologyName);

}
