package com.beifeng.ae.calculate;

import java.util.Map;

public interface AECalculate {
    /**
     * 计算结果
     * 
     * @param metricData
     * @return
     */
    public Object calculate(Map<String, Object> metricData);
}
