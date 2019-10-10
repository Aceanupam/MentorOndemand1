package com.example.demo.Payment;

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

import com.example.demo.Training.Training;
import com.example.demo.Training.TrainingServiceImpl;
import com.example.demo.User.User;
import com.example.demo.User.UserService;

@RestController
@RequestMapping({"/payments"})
@CrossOrigin(origins = "http://localhost:4200",maxAge = 3600)
public class PaymentController {
	
	@Autowired
	private PaymentService paymentService;
	@Autowired
	private UserService userService;
	
	@Autowired
	private TrainingServiceImpl trainingService;

	@PostMapping
	public Payment create(@RequestBody Payment payment) {
		Training training=trainingService.findById(payment.getTrainingId());
		Training user_Training=trainingService.findById(payment.getTrainingId());

		if(training!= null)
		{
			training.getPayment().add(payment);
			user_Training.getUser().add(userService.findById(payment.getUserId()));
			trainingService.create(training);
			trainingService.create(user_Training);
			
		}
		return payment;
	}
	
	@GetMapping(path= {"/{paymentId}"})
	public Payment findOne(@PathVariable("paymentId") int paymentId)
	{
		return paymentService.findById(paymentId);
	}
	
	@PutMapping(path= {"/{paymentId}"})
	public Payment update(@PathVariable("paymentId") int paymentId, @RequestBody Payment payment)
	{
		payment.setPaymentId(paymentId);
		return paymentService.update(payment);
		
	}
	@DeleteMapping(path ={"/{paymentId}"})
    public Payment delete(@PathVariable("paymentId") int paymentId) {
        return paymentService.delete(paymentId);
    }

    @GetMapping
    public List<Payment> findAll(){
        return paymentService.findAll();
    }

	
}
