package com.example.demo.Admin;

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

@RestController
@RequestMapping({"/admin"})
@CrossOrigin(origins = "http://localhost:4200",maxAge = 3600)
public class AdminController {
	
	@Autowired
	private AdminService adminService;

	@PostMapping
	public Admin create(@RequestBody Admin admin) {
		return adminService.create(admin);
	}
	
	@GetMapping(path= {"/check/{userName}"})
	public boolean check(@PathVariable("userName") String userName) {
		String adminId;
		adminId=adminService.check(userName);
		if(adminId==null)
			return true;
		else
			return false;
	}
	
	@GetMapping(path= {"/{adminId}"})
	public Admin findOne(@PathVariable("adminId") int adminId)
	{
		return adminService.findById(adminId);
	}
	
	@PutMapping(path= {"/{adminId}"})
	public Admin update(@PathVariable("adminId") int adminId, @RequestBody Admin admin)
	{
		admin.setAdminId(adminId);
		return adminService.update(admin);
		
	}
	@DeleteMapping(path ={"/{adminId}"})
    public Admin delete(@PathVariable("adminId") int adminId) {
        return adminService.delete(adminId);
    }

    @GetMapping
    public List<Admin> findAll(){
        return adminService.findAll();
    }
    
    @GetMapping(path= {"/Validate/{userName}/{password}"})
	public Admin findAdmin(@PathVariable("userName") String userName,@PathVariable("password") String password)
	{

		System.out.println("Inside");
    	return adminService.findAdmin(userName,password);
	}

	
}
