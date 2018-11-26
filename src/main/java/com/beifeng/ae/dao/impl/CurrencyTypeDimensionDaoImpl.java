package com.beifeng.ae.dao.impl;

import com.beifeng.ae.dao.CurrencyTypeDimensionDao;
import com.beifeng.ae.dao.mybatis.BaseDao;
import com.beifeng.ae.model.CurrencyTypeDimension;

public class CurrencyTypeDimensionDaoImpl extends BaseDao implements CurrencyTypeDimensionDao {
    private static String modelClass = CurrencyTypeDimension.class.getName();
    private static String getCurrencyTypeDimension = modelClass + ".getCurrencyTypeDimension";

    
    public CurrencyTypeDimension getCurrencyTypeDimension(CurrencyTypeDimension currencyTypeDimension) {
        return super.getSqlSession().selectOne(getCurrencyTypeDimension, currencyTypeDimension);
    }

    
    public CurrencyTypeDimension getCurrencyTypeDimension(int id) {
        return this.getCurrencyTypeDimension(new CurrencyTypeDimension(id));
    }

    
    public CurrencyTypeDimension getCurrencyTypeDimension(String currencyType) {
        return this.getCurrencyTypeDimension(new CurrencyTypeDimension(currencyType));
    }

}
