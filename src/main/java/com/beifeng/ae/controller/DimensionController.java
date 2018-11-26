package com.beifeng.ae.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.beifeng.ae.common.AEConstants;
import com.beifeng.ae.model.Message;

@Controller
public class DimensionController extends AEBaseController{

    @Resource(name = "dimensionTableMapping")
    private Map<String, String> dimensionTableMapping;

    @Resource(name = "dimensionColumns")
    private Map<String, String> dimensionColumns;

    @RequestMapping(value = "/stats/getDimensions", method = RequestMethod.GET)
    @ResponseBody
    public Object getDimensions(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String dimens = request.getParameter(AEConstants.DIMENSIONS);
        String[] dimensions = StringUtils.split(dimens, AEConstants.SEPARTION_COMMA);
        if (null == dimensions) {
            return Message.badRequest("请求参数无效,必须给定dimensions参数");
        }
        for (String dimension : dimensions) {
            if (!dimensionTableMapping.containsKey(dimension)) {
                return Message.badRequest("dimensions参数无效" + dimension);
            }
        }

        List<Map<String, Object>> data = null;
        Map<String, List<Map<String, Object>>> result = new HashMap<String, List<Map<String, Object>>>();
        Map<String, String> paramsMap = new HashMap<String, String>();
        for (String dimension : dimensions) {
            if (!result.containsKey(dimension)) {
                paramsMap.clear();
                if (dimensionColumns.containsKey(dimension)) {
                    paramsMap.put(AEConstants.SELECT_COLUMNS, dimensionColumns.get(dimension));
                }
                String tableName = dimensionTableMapping.get(dimension);
                paramsMap.put(AEConstants.TABLE_NAME, tableName);
                if (dimension.startsWith(AEConstants.LOCATION)) {
                    paramsMap.put(AEConstants.DIMENSION_NAME, dimension);
                    paramsMap.put(AEConstants.COUNTRY_NAME, request.getParameter(AEConstants.COUNTRY_NAME));
                    paramsMap.put(AEConstants.PROVINCE_NAME, request.getParameter(AEConstants.PROVINCE_NAME));
                }
                data = dimensionService.queryDimensionData(paramsMap);
                result.put(dimension, data);
            }
        }

        return Message.ok(result);
    }
}
