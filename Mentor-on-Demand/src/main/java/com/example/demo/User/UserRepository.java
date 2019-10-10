package com.example.demo.User;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

public interface UserRepository extends Repository<User,Integer>{
	
	void delete(User user);
	List<User> findAll();
	User findOne(int userId);
	User save(User user);
	@Query("Select user from User user where user.userName=? and user.password=?")
	User findUser(String userName, String password);
	@Query("Select user.userId from User user where user.userName=?")
	String check(String userName);

}
