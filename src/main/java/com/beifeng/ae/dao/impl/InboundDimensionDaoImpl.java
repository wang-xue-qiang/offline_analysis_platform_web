package com.beifeng.ae.dao.impl;

import com.beifeng.ae.dao.InboundDimensionDao;
import com.beifeng.ae.dao.mybatis.BaseDao;
import com.beifeng.ae.model.InboundDimension;

public class InboundDimensionDaoImpl extends BaseDao implements InboundDimensionDao {
    private static String modelClass = InboundDimension.class.getName();
    private static String getInboundDimension = modelClass + ".getInboundDimension";

    
    public InboundDimension getInboundDimension(InboundDimension inbound) {
        return this.getSqlSession().selectOne(getInboundDimension, inbound);
    }

    
    public InboundDimension getInboundDimension(int id) {
        InboundDimension inbound = new InboundDimension(id);
        return getInboundDimension(inbound);
    }

    
    public InboundDimension getInboundDimension(String name) {
        InboundDimension inbound = new InboundDimension(name);
        return getInboundDimension(inbound);
    }

}
