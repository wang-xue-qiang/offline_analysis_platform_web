package com.beifeng.ae.dao;

import com.beifeng.ae.model.PlatformDimension;

public interface PlatformDimensionDao {
    public PlatformDimension getPlatformDimension(PlatformDimension platform);

    public PlatformDimension getPlatformDimension(String platform);

    public PlatformDimension getPlatformDimension(int id);
}