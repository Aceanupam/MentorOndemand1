package com.example.demo.Technology;

import java.util.List;

public interface TechnologyService {

	Technology create(Technology technology);
	Technology delete(int technolgyId);
	List<Technology> findAll();
	Technology findById(int technolgyId);
	Technology update(Technology technology);
	String check(String technologyName);
}
