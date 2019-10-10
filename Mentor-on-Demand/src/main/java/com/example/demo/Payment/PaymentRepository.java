package com.example.demo.Payment;

import java.util.List;

import org.springframework.data.repository.Repository;

public interface PaymentRepository extends Repository<Payment,Integer>{
	
	void delete(Payment payment);
	List<Payment> findAll();
	Payment findOne(int paymentId);
	Payment save(Payment payment);

}
