package com.beifeng.ae.dao.impl;

import com.beifeng.ae.dao.EventDimensionDao;
import com.beifeng.ae.dao.mybatis.BaseDao;
import com.beifeng.ae.model.EventDimension;

public class EventDimensionDaoImpl extends BaseDao implements EventDimensionDao {
    private static String modelClass = EventDimension.class.getName();
    private static String getEventDimension = modelClass + ".getEventDimension";

    
    public EventDimension getEventDimension(EventDimension eventDimension) {
        return this.getSqlSession().selectOne(getEventDimension, eventDimension);
    }

    
    public EventDimension getEventDimension(int id) {
        return this.getEventDimension(new EventDimension(id));
    }

    
    public EventDimension getEventDimension(String category, String action) {
        return this.getEventDimension(new EventDimension(category, action));
    }

}
