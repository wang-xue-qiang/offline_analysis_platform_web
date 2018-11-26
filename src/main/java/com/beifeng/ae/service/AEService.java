package com.beifeng.ae.service;

import java.util.List;
import java.util.Map;

import com.beifeng.ae.model.QueryModel;

/**
 * 处理ae基本数据交换的接口
 * 
 * 
 *
 */
public interface AEService {
    public List<Map<String, Object>> execute(QueryModel queryModel) throws Exception;

}
