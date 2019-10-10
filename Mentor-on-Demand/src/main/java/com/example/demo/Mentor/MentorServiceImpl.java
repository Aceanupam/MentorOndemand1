package com.example.demo.Mentor;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class MentorServiceImpl implements MentorService{

	@Autowired
	private MentorRepository repository;
	
	@Override
	public Mentor create(Mentor user) {
		// TODO Auto-generated method stub
		return repository.save(user);
	}

	@Override
	public Mentor delete(int mentorId) {
		// TODO Auto-generated method stub
		Mentor mentor=findById(mentorId);
		if(mentor != null) {
			repository.delete(mentor);
		}
		return mentor;
	}

	@Override
	public List<Mentor> findAll() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public Mentor findById(int id) {
		// TODO Auto-generated method stub
		return repository.findOne(id);
	}

	@Override
	public Mentor update(Mentor mentor) {
		// TODO Auto-generated method stub
		return repository.save(mentor);
	}

	@Override
	public Mentor findMentor(String userName, String password) {
		
			return repository.findMentor(userName, password);
		}
	@Override
	public String check(String userName) {
		// TODO Auto-generated method stub
		return repository.check(userName);
		
	}

	@Override
	public Mentor changeStatus(Mentor mentor) {
		// TODO Auto-generated method stub
		System.out.println(mentor.getActive());
		return repository.save(mentor);
	}

}
	

