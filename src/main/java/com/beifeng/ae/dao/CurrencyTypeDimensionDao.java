package com.beifeng.ae.dao;

import com.beifeng.ae.model.CurrencyTypeDimension;

public interface CurrencyTypeDimensionDao {
    public CurrencyTypeDimension getCurrencyTypeDimension(CurrencyTypeDimension currencyTypeDimension);

    public CurrencyTypeDimension getCurrencyTypeDimension(int id);

    public CurrencyTypeDimension getCurrencyTypeDimension(String currencyType);
}
