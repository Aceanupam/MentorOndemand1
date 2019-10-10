package com.example.demo.Admin;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

public interface AdminRepository extends Repository<Admin,Integer>{
	
	void delete(Admin admin);
	List<Admin> findAll();
	Admin findOne(int adminId);
	Admin save(Admin admin);
	@Query("Select admin from Admin admin where admin.userName=? and admin.password=?")
	Admin findAdmin(String userName, String password);
	@Query("Select admin.adminId from Admin admin where admin.userName=?")
	String check(String userName);

}
