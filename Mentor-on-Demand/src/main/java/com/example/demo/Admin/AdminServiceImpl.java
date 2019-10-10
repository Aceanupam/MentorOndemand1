package com.example.demo.Admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class AdminServiceImpl implements AdminService{

	@Autowired
	private AdminRepository repository;

	@Override
	public Admin create(Admin admin) {
		// TODO Auto-generated method stub
		return repository.save(admin);
	}

	@Override
	public Admin delete(int adminId) {
		// TODO Auto-generated method stub
		Admin admin=findById(adminId);
		if(admin != null) {
			repository.delete(admin);
		}
		return admin;
	}

	@Override
	public List<Admin> findAll() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public Admin findById(int adminId) {
		// TODO Auto-generated method stub
		return repository.findOne(adminId);
	}

	@Override
	public Admin update(Admin admin) {
		// TODO Auto-generated method stub
		return repository.save(admin);
	}

	@Override
	public Admin findAdmin(String userName, String password) {
		// TODO Auto-generated method stub
		return repository.findAdmin(userName,password);
	}

	@Override
	public String check(String userName) {
		// TODO Auto-generated method stub
		return repository.check(userName);
		
	}

	
	
}
