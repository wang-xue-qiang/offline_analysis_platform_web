package com.beifeng.ae.dao.impl;

import com.beifeng.ae.dao.BrowserDimensionDao;
import com.beifeng.ae.dao.mybatis.BaseDao;
import com.beifeng.ae.model.BrowserDimension;

public class BrowserDimensionDaoImpl extends BaseDao implements BrowserDimensionDao{
	private static String modelClass = BrowserDimension.class.getName();
	private static String getBrowserDimension = modelClass + ".getBrowserDimension";
	 
	
	public BrowserDimension getBrowserDimension(BrowserDimension browserDimension) {
		return this.getSqlSession().selectOne(getBrowserDimension, browserDimension);
	}

	
	public BrowserDimension getBrowserDimension(int id) {
		BrowserDimension browserDimension= new BrowserDimension(id);
		return this.getSqlSession().selectOne(getBrowserDimension, browserDimension);
		
	}

	
	public BrowserDimension getBrowserDimension(String browser, String browserVersion) {
		BrowserDimension browserDimension= new BrowserDimension(browser,browserVersion);
		return this.getSqlSession().selectOne(getBrowserDimension, browserDimension);
	}
	 

}
