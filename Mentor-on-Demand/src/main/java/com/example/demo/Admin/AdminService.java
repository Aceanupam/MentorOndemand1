package com.example.demo.Admin;

import java.util.List;

public interface AdminService {

	Admin create(Admin admin);
	Admin delete(int adminId);
	List<Admin> findAll();
	Admin findById(int adminId);
	Admin update(Admin admin);
	Admin findAdmin(String userName, String password);
	String check(String userName);
}
