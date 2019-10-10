package com.example.demo.Mentor;

import java.util.List;

public interface MentorService {

	Mentor create(Mentor mentor);
	Mentor delete(int mentorId);
	List<Mentor> findAll();
	Mentor findById(int mentorId);
	Mentor update(Mentor mentor);
	Mentor findMentor(String userName, String password);
	String check(String userName);
	Mentor changeStatus(Mentor mentor);
}
