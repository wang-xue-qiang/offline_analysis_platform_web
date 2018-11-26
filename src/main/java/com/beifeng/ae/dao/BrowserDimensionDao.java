package com.beifeng.ae.dao;

import com.beifeng.ae.model.BrowserDimension;

public interface BrowserDimensionDao {
	public BrowserDimension getBrowserDimension(BrowserDimension browserDimension);

	public BrowserDimension getBrowserDimension(int id);

	public BrowserDimension getBrowserDimension(String browser,String browserVersion);
}
