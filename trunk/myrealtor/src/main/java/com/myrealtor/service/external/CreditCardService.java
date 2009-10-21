package com.myrealtor.service.external;

import com.myrealtor.domain.beans.Payment;

public interface CreditCardService {
	
	public void authorizePayment(Payment payment);

}
