package com.example.demo.User;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository repository;
	
	@Override
	public User create(User user) {
		// TODO Auto-generated method stub
		return repository.save(user);
	}

	@Override
	public User delete(int userId) {
		// TODO Auto-generated method stub
		User user=findById(userId);
		if(user != null) {
			repository.delete(user);
		}
		return user;
	}

	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public User findById(int userId) {
		// TODO Auto-generated method stub
		return repository.findOne(userId);
	}

	@Override
	public User update(User user) {
		// TODO Auto-generated method stub
		return repository.save(user);
	}

	@Override
	public User findUser(String userName, String password) {
		// TODO Auto-generated method stub
		return repository.findUser(userName,password);
	}

	@Override
	public String check(String userName) {
		// TODO Auto-generated method stub
		return repository.check(userName);
		
	}

}
