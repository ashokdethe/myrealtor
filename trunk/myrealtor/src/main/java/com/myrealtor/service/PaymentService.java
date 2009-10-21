package com.myrealtor.service;

import com.myrealtor.domain.beans.Payment;
import com.myrealtor.domain.beans.PaymentResult;

public interface PaymentService {
	
	public PaymentResult processPayment(Payment payment);

}
