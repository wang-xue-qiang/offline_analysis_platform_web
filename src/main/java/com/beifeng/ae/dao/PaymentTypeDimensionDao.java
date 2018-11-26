package com.beifeng.ae.dao;

import com.beifeng.ae.model.PaymentTypeDimension;

public interface PaymentTypeDimensionDao {
	public PaymentTypeDimension getPaymentTypeDimension(PaymentTypeDimension paymentTypeDimension);

	public PaymentTypeDimension getPaymentTypeDimension(int id);

	public PaymentTypeDimension getPaymentTypeDimension(String paymentType);
}
