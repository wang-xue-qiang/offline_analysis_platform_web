package com.beifeng.ae.dao;

import java.util.List;
import java.util.Map;

public interface DimensionDao {

    public List<Map<String, Object>> queryDimensionData(Map<String, String> queryMap);
}
