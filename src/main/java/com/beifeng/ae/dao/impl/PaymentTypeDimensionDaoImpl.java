package com.beifeng.ae.dao.impl;

import com.beifeng.ae.dao.PaymentTypeDimensionDao;
import com.beifeng.ae.dao.mybatis.BaseDao;
import com.beifeng.ae.model.PaymentTypeDimension;

public class PaymentTypeDimensionDaoImpl extends BaseDao implements PaymentTypeDimensionDao {
    private static String modelClass = PaymentTypeDimension.class.getName();
    private static String getPaymentTypeDimension = modelClass + ".getPaymentTypeDimension";

    
    public PaymentTypeDimension getPaymentTypeDimension(PaymentTypeDimension paymentTypeDimension) {
        return super.getSqlSession().selectOne(getPaymentTypeDimension, paymentTypeDimension);
    }

    
    public PaymentTypeDimension getPaymentTypeDimension(int id) {
        return this.getPaymentTypeDimension(new PaymentTypeDimension(id));
    }

    
    public PaymentTypeDimension getPaymentTypeDimension(String paymentType) {
        return this.getPaymentTypeDimension(new PaymentTypeDimension(paymentType));
    }

}
