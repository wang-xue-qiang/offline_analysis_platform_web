package com.beifeng.ae.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.beifeng.ae.calculate.AECalculate;
import com.beifeng.ae.common.AEConstants;
import com.beifeng.ae.dao.mybatis.AEDao;
import com.beifeng.ae.model.QueryModel;
import com.beifeng.ae.service.AEService;
import com.beifeng.ae.util.ApplicationContextUtil;

/**
 * 默认的aeservice实现类
 * 
 * 
 *
 */
public class AEServiceImpl implements AEService {
    private AEDao aeDao;

    public void setAeDao(AEDao aeDao) {
        this.aeDao = aeDao;
    }

    @SuppressWarnings("unchecked")
    public List<Map<String, Object>> execute(QueryModel queryModel) {
        List<Map<String, Object>> metricData = aeDao.fetchMetricData(queryModel);
        if (metricData == null) {
            return new ArrayList<Map<String, Object>>();
        }
        Map<String, Set<String>> metrics = queryModel.getMetrics();
        Set<String> metricKeys = metrics.keySet();
        Set<String> groups = queryModel.getGroups();
        List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();

        for (Map<String, Object> metricDataItem : metricData) {
            if (metricDataItem == null) {
                continue;
            }
            Set<String> allCloumn = metricDataItem.keySet();
            Map<String, Object> resMap = new HashMap<String, Object>();

            for (String metricKey : metricKeys) {
                Set<String> metricCloumns = metrics.get(metricKey);
                Map<String, Object> metricCloumnValues = new HashMap<String, Object>();
                for (String metricCloumn : metricCloumns) {
                    Object metricCloumnValue = metricDataItem.get(metricCloumn);
                    if (metricCloumnValue == null) {
                        metricCloumnValue = 0;
                    }
                    if (AEConstants.KPI_NAME.equals(metricCloumn)) {
                        metricCloumnValues.put(metricCloumn, metricCloumnValue);
                    } else {
                        metricCloumnValues.put(AEConstants.PRIFIX + metricCloumn, metricCloumnValue);
                    }
                }

                // 获取后期计算calculate对象
                String beanId = queryModel.getBucket() + AEConstants.DELIMITER + metricKey;
                AECalculate aeCalculate = null;
                if (ApplicationContextUtil.getApplicationContext().containsBean(beanId)) {
                    aeCalculate = (AECalculate) ApplicationContextUtil.getApplicationContext().getBean(beanId);
                }

                // 根据是否有calculate对象来进行数据填充操作
                if (aeCalculate == null) {
                    resMap.putAll(metricCloumnValues);
                } else {
                    Object calculateRes = aeCalculate.calculate(metricCloumnValues);
                    if (calculateRes instanceof Map) {
                        resMap.putAll((Map<String, Object>) calculateRes);
                    } else {
                        resMap.put(AEConstants.PRIFIX + metricKey, calculateRes);
                    }
                }
            }

            // 处理分组情况
            if (groups != null) {
                for (String cloumn : allCloumn) {
                    if (cloumn.startsWith(AEConstants.GROUP_FLAG)) {
                        String c = cloumn.replace(AEConstants.GROUP_FLAG, AEConstants.EMPTY_STR);
                        resMap.put(c, metricDataItem.get(cloumn));
                    }
                }
            }

            // 添加到最终集合中
            result.add(resMap);
        }
        return result;
    }
}