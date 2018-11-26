package com.beifeng.ae.dao;

import com.beifeng.ae.model.InboundDimension;

public interface InboundDimensionDao {
    public InboundDimension getInboundDimension(InboundDimension inbound);

    public InboundDimension getInboundDimension(int id);

    public InboundDimension getInboundDimension(String name);
}
