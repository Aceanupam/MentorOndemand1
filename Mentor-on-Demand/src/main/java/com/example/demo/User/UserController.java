package com.example.demo.User;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Mentor.Mentor;
import com.example.demo.Training.Training;
import com.example.demo.Training.TrainingService;

@RestController
@RequestMapping({"/user"})
@CrossOrigin(origins = "http://localhost:4200",maxAge = 3600)
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private TrainingService trainingService;
	
	
	
	
	@PostMapping
	public User create(@RequestBody User user) {
		
		
		/*
		 * Training training=trainingService.findById(user.getTraining_Id());
		 * if(training!=null) { training.getUser().add(user);
		 * trainingService.create(training);
		 */
		 
		return userService.create(user);
	}
	
	@GetMapping(path= {"/check/{userName}"})
	public boolean check(@PathVariable("userName") String userName) {
		String userId;
		userId=userService.check(userName);
		System.out.println(userId);
		if(userId==null)
			return true;
		else
			return false;
	}
	
	@GetMapping(path= {"/{userId}"})
	public User findOne(@PathVariable("userId") int userId)
	{
		return userService.findById(userId);
	}
	
	@PutMapping(path= {"/{userId}"})
	public User update(@PathVariable("userId") int userId, @RequestBody User user)
	{
		user.setUserId(userId);
		return userService.update(user);
		
	}
	@DeleteMapping(path ={"/{userId}"})
    public User delete(@PathVariable("userId") int userId) {
        return userService.delete(userId);
    }

    @GetMapping
    public List<User> findAll(){
        return userService.findAll();
    }
    
    @GetMapping(path= {"/Validate/{userName}/{password}"})
	public User findUser(@PathVariable("userName") String userName,@PathVariable("password") String password)
	{

		System.out.println("Inside");
    	return userService.findUser(userName,password);
	}

	
}
