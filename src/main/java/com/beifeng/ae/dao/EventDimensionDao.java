package com.beifeng.ae.dao;

import com.beifeng.ae.model.EventDimension;

public interface EventDimensionDao {
    public EventDimension getEventDimension(EventDimension eventDimension);

    public EventDimension getEventDimension(int id);

    public EventDimension getEventDimension(String category,String action);

}
