package com.beifeng.ae.dao.mybatis;

import java.util.List;
import java.util.Map;

import com.beifeng.ae.model.QueryModel;

public class AEDao extends BaseDao {
    /**
     * 获得data数据，最终所有的请求具体的用户数据都是通过该接口来的，获取dimension除外
     * 
     * @param queryModel
     * @return
     */
    public List<Map<String, Object>> fetchMetricData(QueryModel queryModel) {
        return this.processWithNoCache(queryModel);
    }

    private List<Map<String, Object>> processWithNoCache(QueryModel queryModel) {
        return this.getSqlSession().selectList(queryModel.getQueryId(), queryModel);
    }
}