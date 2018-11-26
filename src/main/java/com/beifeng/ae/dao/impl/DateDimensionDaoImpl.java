package com.beifeng.ae.dao.impl;

import com.beifeng.ae.dao.DateDimensionDao;
import com.beifeng.ae.dao.mybatis.BaseDao;
import com.beifeng.ae.model.DateDimension;

public class DateDimensionDaoImpl extends BaseDao implements DateDimensionDao {

    private static String modelClass = DateDimension.class.getName();
    private static String getDateDimensionId = modelClass + ".getDateDimensionId";

    
    public Integer getDateDimensionId(DateDimension date) {
        return this.getSqlSession().selectOne(getDateDimensionId, date);
    }

    
    public Integer getDateDimensionId(int year, int season, int month, int week, int day) {
        DateDimension date = new DateDimension(year, season, month, week, day);
        return getDateDimensionId(date);
    }

}