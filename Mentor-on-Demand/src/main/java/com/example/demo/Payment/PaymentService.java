package com.example.demo.Payment;

import java.util.List;

public interface PaymentService {

	Payment create(Payment payment);
	Payment delete(int paymentId);
	List<Payment> findAll();
	Payment findById(int paymentId);
	Payment update(Payment payment);
}
