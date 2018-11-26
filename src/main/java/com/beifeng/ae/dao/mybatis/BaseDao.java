package com.beifeng.ae.dao.mybatis;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;

public abstract class BaseDao {
    protected SqlSessionTemplate sqlSessionTemplate;

    public SqlSessionTemplate getSqlSessionTemplate() {
        return sqlSessionTemplate;
    }

    public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
        this.sqlSessionTemplate = sqlSessionTemplate;
    }

    /**
     * 获得对应的mybatis session对象
     * 
     * @return
     */
    public SqlSession getSqlSession() {
        return this.sqlSessionTemplate;
    }
}
