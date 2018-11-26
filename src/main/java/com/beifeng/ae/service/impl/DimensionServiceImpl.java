package com.beifeng.ae.service.impl;

import java.util.List;
import java.util.Map;

import com.beifeng.ae.dao.BrowserDimensionDao;
import com.beifeng.ae.dao.CurrencyTypeDimensionDao;
import com.beifeng.ae.dao.DateDimensionDao;
import com.beifeng.ae.dao.DimensionDao;
import com.beifeng.ae.dao.EventDimensionDao;
import com.beifeng.ae.dao.InboundDimensionDao;
import com.beifeng.ae.dao.KpiDimensionDao;
import com.beifeng.ae.dao.LocationDimensionDao;
import com.beifeng.ae.dao.PaymentTypeDimensionDao;
import com.beifeng.ae.dao.PlatformDimensionDao;
import com.beifeng.ae.model.BrowserDimension;
import com.beifeng.ae.model.CurrencyTypeDimension;
import com.beifeng.ae.model.EventDimension;
import com.beifeng.ae.model.InboundDimension;
import com.beifeng.ae.model.KpiDimension;
import com.beifeng.ae.model.LocationDimension;
import com.beifeng.ae.model.PaymentTypeDimension;
import com.beifeng.ae.model.PlatformDimension;
import com.beifeng.ae.service.DimensionService;

public class DimensionServiceImpl implements DimensionService {
    private DimensionDao dimeDao;
    private DateDimensionDao dateDimeDao;
    private PlatformDimensionDao platformDimeDao;
    private KpiDimensionDao kpiDimeDao;
    private BrowserDimensionDao browserDimeDao;
    private LocationDimensionDao locationDimeDao;
    private InboundDimensionDao inboundDimeDao;
    private EventDimensionDao eventDimeDao;
    private CurrencyTypeDimensionDao currencyTypeDimeDao;
    private PaymentTypeDimensionDao paymentTypeDimeDao;

    public DimensionDao getDimeDao() {
        return dimeDao;
    }

    public void setDimeDao(DimensionDao dimeDao) {
        this.dimeDao = dimeDao;
    }

    public DateDimensionDao getDateDimeDao() {
        return dateDimeDao;
    }

    public void setDateDimeDao(DateDimensionDao dateDimeDao) {
        this.dateDimeDao = dateDimeDao;
    }

    public PlatformDimensionDao getPlatformDimeDao() {
        return platformDimeDao;
    }

    public void setPlatformDimeDao(PlatformDimensionDao platformDimeDao) {
        this.platformDimeDao = platformDimeDao;
    }

    public KpiDimensionDao getKpiDimeDao() {
        return kpiDimeDao;
    }

    public void setKpiDimeDao(KpiDimensionDao kpiDimeDao) {
        this.kpiDimeDao = kpiDimeDao;
    }

    public BrowserDimensionDao getBrowserDimeDao() {
        return browserDimeDao;
    }

    public void setBrowserDimeDao(BrowserDimensionDao browserDimeDao) {
        this.browserDimeDao = browserDimeDao;
    }

    public LocationDimensionDao getLocationDimeDao() {
        return locationDimeDao;
    }

    public void setLocationDimeDao(LocationDimensionDao locationDimeDao) {
        this.locationDimeDao = locationDimeDao;
    }

    public InboundDimensionDao getInboundDimeDao() {
        return inboundDimeDao;
    }

    public void setInboundDimeDao(InboundDimensionDao inboundDimeDao) {
        this.inboundDimeDao = inboundDimeDao;
    }

    public EventDimensionDao getEventDimeDao() {
        return eventDimeDao;
    }

    public void setEventDimeDao(EventDimensionDao eventDimeDao) {
        this.eventDimeDao = eventDimeDao;
    }

    public CurrencyTypeDimensionDao getCurrencyTypeDimeDao() {
        return currencyTypeDimeDao;
    }

    public void setCurrencyTypeDimeDao(CurrencyTypeDimensionDao currencyTypeDimeDao) {
        this.currencyTypeDimeDao = currencyTypeDimeDao;
    }

    public PaymentTypeDimensionDao getPaymentTypeDimeDao() {
        return paymentTypeDimeDao;
    }

    public void setPaymentTypeDimeDao(PaymentTypeDimensionDao paymentTypeDimeDao) {
        this.paymentTypeDimeDao = paymentTypeDimeDao;
    }


    public List<Map<String, Object>> queryDimensionData(final Map<String, String> queryMap) {
        return this.dimeDao.queryDimensionData(queryMap);
    }


    public PlatformDimension getPlatformDimension(final int dimensionPlatformId) {
        return this.platformDimeDao.getPlatformDimension(dimensionPlatformId);
    }


    public PlatformDimension getPlatformDimension(final String platformName) {
        return this.platformDimeDao.getPlatformDimension(platformName);
    }


    public Integer getDateDimensionId(final int year, final int season, final int month, final int week, final int day) {
        return this.dateDimeDao.getDateDimensionId(year, season, month, week, day);
    }


    public Integer getKpiDimensionId(final String kpiName) {
        KpiDimension dimension = this.kpiDimeDao.getKpiDimension(kpiName);
        if (dimension != null) {
            return dimension.getId();
        }
        return null;
    }


    public BrowserDimension getBrowserDimension(int browserId) {
        return this.browserDimeDao.getBrowserDimension(browserId);
    }


    public BrowserDimension getBrowserDimension(String browser, String browser_version) {
        return this.browserDimeDao.getBrowserDimension(browser, browser_version);
    }


    public LocationDimension getLocationDimension(int dimensionLocationId) {
        return this.locationDimeDao.getLocationDimension(dimensionLocationId);
    }


    public LocationDimension getLocationDimension(String country, String province, String city) {
        return this.locationDimeDao.getLocationDimension(country, province, city);
    }


    public InboundDimension getInboundDimension(int dimensionInboundId) {
        return this.inboundDimeDao.getInboundDimension(dimensionInboundId);
    }


    public InboundDimension getInboundDimension(String name) {
        return this.inboundDimeDao.getInboundDimension(name);
    }


    public EventDimension getEventDimension(int dimensionEventId) {
        return this.eventDimeDao.getEventDimension(dimensionEventId);
    }


    public EventDimension getEventDimension(String category, String action) {
        return this.eventDimeDao.getEventDimension(category, action);
    }


    public CurrencyTypeDimension getCurrencyTypeDimension(int dimensionCurrencyTypeId) {
        return this.currencyTypeDimeDao.getCurrencyTypeDimension(dimensionCurrencyTypeId);
    }


    public CurrencyTypeDimension getCurrencyTypeDimension(String currencyType) {
        return this.currencyTypeDimeDao.getCurrencyTypeDimension(currencyType);
    }


    public PaymentTypeDimension getPaymentTypeDimension(int dimensionPaymentTypeId) {
        return this.paymentTypeDimeDao.getPaymentTypeDimension(dimensionPaymentTypeId);
    }


    public PaymentTypeDimension getPaymentTypeDimension(String paymentType) {
        return this.paymentTypeDimeDao.getPaymentTypeDimension(paymentType);
    }
}