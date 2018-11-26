package com.beifeng.ae.dao.impl;

import com.beifeng.ae.dao.LocationDimensionDao;
import com.beifeng.ae.dao.mybatis.BaseDao;
import com.beifeng.ae.model.LocationDimension;

public class LocationDimensionDaoImpl extends BaseDao implements LocationDimensionDao {

    private static String modelClass = LocationDimension.class.getName();
    private static String getLocationDimension = modelClass + ".getLocationDimension";

    
    public LocationDimension getLocationDimension(LocationDimension location) {
        return this.getSqlSession().selectOne(getLocationDimension, location);
    }

    
    public LocationDimension getLocationDimension(String country, String province, String city) {
        LocationDimension location = new LocationDimension(country, province, city);
        return getLocationDimension(location);
    }

    
    public LocationDimension getLocationDimension(int id) {
        LocationDimension location = new LocationDimension(id);
        return getLocationDimension(location);
    }

}