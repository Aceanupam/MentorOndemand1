package com.example.demo.User;

import java.util.List;

public interface UserService {

	User create(User user);
	User delete(int userId);
	List<User> findAll();
	User findById(int userId);
	User update(User user);
	User findUser(String userName, String password);
	String check(String userName);
}
