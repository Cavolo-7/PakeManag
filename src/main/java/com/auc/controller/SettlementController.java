package com.auc.controller;

import com.alibaba.fastjson.JSON;
import com.auc.pojo.Detail;
import com.auc.pojo.LayuiData;
import com.auc.pojo.Person;
import com.auc.service.PersonService;
import com.auc.service.SettlementService;
import com.auc.util.ReportDataBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/settlement")
public class SettlementController {
    @Autowired
    private SettlementService settlementService;

    //获取收支明细表格数据
    @RequestMapping(value = "/getDetailList", produces = "text/plain;charset=utf-8")
    public String getDetailList(HttpServletRequest request, HttpServletResponse response) throws IOException, ParseException {
        String personCarnumber = request.getParameter("key[personCarnumber]");
        String date1 = request.getParameter("key[date1]");
        String date2 = request.getParameter("key[date2]");
        String workerNames = request.getParameter("key[workerNames]");
        String curPageStr = request.getParameter("page");
        String pageSizeStr = request.getParameter("limit");
        Integer pageSize = 5;
        Integer curPage = 1;
        int a = 0;
        Map<String, String> condition = new HashMap<>();
        if (null != date1 && !"".equalsIgnoreCase(date1)) {
            condition.put("date1", date1);
        }
        if (null != date2 && !"".equalsIgnoreCase(date2)) {
            condition.put("date2", date2);
        }
        if (null != workerNames && !"".equalsIgnoreCase(workerNames)) {
            condition.put("workerNames", workerNames);
        }
        if (personCarnumber != null && !"".equalsIgnoreCase(personCarnumber)) {
            condition.put("personCarnumber", personCarnumber);
        }
        if (null != curPageStr && !"".equalsIgnoreCase(curPageStr)
                && null != pageSizeStr && !"".equalsIgnoreCase(pageSizeStr)) {
            curPage = Integer.parseInt(curPageStr);
            pageSize = Integer.parseInt(pageSizeStr);
            curPage = (curPage - 1) * pageSize;
        }
        LayuiData<Detail> layuiData = settlementService.selectDetailList(condition, curPage, pageSize);
        String str = JSON.toJSONString(layuiData);
        return str;
    }

    //获取收支明细表格数据
    @RequestMapping(value = "/getYearDetail", produces = "text/plain;charset=utf-8")
    public String getYearDetail(HttpServletRequest request, HttpServletResponse response) throws IOException, ParseException {

        List<Integer> list=settlementService.selectMonth();
        ReportDataBean bean=new ReportDataBean();
        bean.setData(list);
        String str= JSON.toJSONString(bean);
        return str;
    }

}
