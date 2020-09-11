package com.auc.controller;

import com.alibaba.fastjson.JSON;
import com.auc.pojo.*;
import com.auc.service.AdminService;
import com.auc.service.VipService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/vip")
public class VipController {

    @Autowired
    private VipService vipService;


    //显示vip用户表格数据
    @RequestMapping(value = "/getVipList", produces = "text/plain;charset=utf-8")
    public String getVipList(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String vipName = request.getParameter("key[vipName]");
        String account = request.getParameter("key[account]");
        String phone = request.getParameter("key[phone]");
        String vipStarTime = request.getParameter("key[vipStarTime]");
        String vipEndTime = request.getParameter("key[vipEndTime]");
        String curPageStr = request.getParameter("page");
        String pageSizeStr = request.getParameter("limit");
        Integer pageSize = 5;
        Integer curPage = 1;
        int a = 0;
        Map<String, String> condition = new HashMap<>();
        if (null != vipName && !"".equalsIgnoreCase(vipName)) {
            condition.put("vipName", vipName);
        }
        if (null != account && !"".equalsIgnoreCase(account)) {
            condition.put("account", account);
        }
        if (null != phone && !"".equalsIgnoreCase(phone)) {
            condition.put("phone", phone);
        }
        if (null != vipStarTime && !"".equalsIgnoreCase(vipStarTime)) {
            condition.put("vipStarTime", vipStarTime);
        }
        if (null != vipEndTime && !"".equalsIgnoreCase(vipEndTime)) {
            condition.put("vipEndTime", vipEndTime);
        }

        if (null != curPageStr && !"".equalsIgnoreCase(curPageStr)
                && null != pageSizeStr && !"".equalsIgnoreCase(pageSizeStr)) {
            curPage = Integer.parseInt(curPageStr);
            pageSize = Integer.parseInt(pageSizeStr);
            curPage = (curPage - 1) * pageSize;
        }
        LayuiData<Vip> layuiData = vipService.selectVipList(condition, curPage, pageSize);

//        Gson gson = new Gson();
        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
        String str = JSON.toJSONString(layuiData);
        return str;
    }

    //重置管理员密码
    @RequestMapping(value = "/updateVipPassword", produces = "text/plain;charset=utf-8")
    public String updateVipPassword(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String vipAccount = request.getParameter("vipAccount");
        boolean flag = vipService.updateVipPassword(vipAccount);
        String str = null;
        if (flag == true) {
            str = "重置成功";
        } else {
            str = "重置失败";
        }
        return str;
    }

    //添加vip用户
    @RequestMapping(value = "/addVip", produces = "text/plain;charset=utf-8")
    public String addVip(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String str = null;
        String vipAccount = request.getParameter("vipAccount");
        String vipName = request.getParameter("vipName");
        String vipAge = request.getParameter("vipAge");
        String sex = request.getParameter("sex");
        String phone = request.getParameter("phone");
        String vipAddress = request.getParameter("vipAddress");
        String carNumber = request.getParameter("carNumber");
        String produceName = request.getParameter("produceName");
        String L_pass = request.getParameter("repass");
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Date date = new Date();
        Admin admin = (Admin) request.getSession().getAttribute("admin");


        Vip vip2 = vipService.selectVipAccount(vipAccount);
        Vip vip3 = vipService.selectVipPhone(phone);
        Vip vip4 = vipService.selectVipCarNumber(carNumber);
        if (vip2 != null) {
            str = "账号已经存在";
        } else if (vip3 != null) {
            str = "电话号码已存在";
        } else if (vip4 != null) {
            str = "车牌号已存在";
        } else {

            int sexValue = vipService.selectVipParam(sex);
            Produce produce = vipService.selectProduceId(produceName);

            Vip vip6 = new Vip();
            vip6.setVipEndTime(dateFormat.format(date));
            vip6.setProduceMonths(produce.getProduceMonths());
            Date date1 = vipService.selectEndTime(vip6);

            Vip vip = new Vip();
            vip.setVipAccount(vipAccount);
            vip.setVipName(vipName);
            vip.setVipAge(Integer.parseInt(vipAge));
            vip.setVipSex(sexValue);
            vip.setVipPhone(phone);
            vip.setVipAddress(vipAddress);
            vip.setVipCarNumber(carNumber);
            vip.setProduceId(produce.getProduceId());
            vip.setVipRecharge(produce.getProduceMoney());
            vip.setVipPassword(L_pass);
            vip.setVipEndTime(dateFormat.format(date1));
            vip.setWorkerId(admin.getWorkerId());

            boolean flag = vipService.addVip(vip);
            if (flag == true) {
                String thing = "月缴用户";
                Detail detail = new Detail();
                detail.setDetailCarnumber(carNumber);
                detail.setDetailEvent(thing);
                detail.setProduceId(produce.getProduceId());
                detail.setDetailMoney(produce.getProduceMoney());
                detail.setWorkerId(admin.getWorkerId());
                boolean flag2 = vipService.addDetail(detail);
                str = "增加成功";
            } else {
                str = "增加失败";
            }
        }
        return str;
    }

    //vip续费
    @RequestMapping(value = "/updateVipProduce", produces = "text/plain;charset=utf-8")
    public String updateVipProduce(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String str = null;
        String vipAccount = request.getParameter("vipAccount");
        String vipName = request.getParameter("vipName");
        String vipCarNumber = request.getParameter("vipCarNumber");
        String produceName = request.getParameter("produceName");

        Admin admin = (Admin) request.getSession().getAttribute("admin");
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Vip vip2 = vipService.selectVipAccount(vipAccount);
        Produce produce = vipService.selectProduceId(produceName);
        Vip vip6 = new Vip();
        vip6.setVipEndTime(dateFormat.format(vip2.getVipEndTime()));
        vip6.setProduceMonths(produce.getProduceMonths());
        Date date1 = vipService.selectEndTime(vip6);
        Vip vip = new Vip();
        vip.setVipAccount(vipAccount);
        vip.setVipEndTime(dateFormat.format(date1));
        boolean flag = vipService.updateVipProduce(vip);
        if (flag == true) {

            int vipRecharge=vip2.getVipRecharge();//原vip消费总记录
            int n=vipRecharge+produce.getProduceMoney();//总消费记录
            boolean flag4=vipService.updateVipRecharge(n);

            String thing = "月缴用户";
            Detail detail = new Detail();
            detail.setDetailCarnumber(vipCarNumber);
            detail.setDetailEvent(thing);
            detail.setProduceId(produce.getProduceId());
            detail.setDetailMoney(produce.getProduceMoney());
            detail.setWorkerId(admin.getWorkerId());
            boolean flag2 = vipService.addDetail(detail);
            if (flag4==true&&flag2==true){
                str = "续费成功";
            }
        } else {
            str = "续费失败";
        }


        return str;
    }

    //退费
    //vip续费
//   @RequestMapping(value = "/updateVipProduce", produces = "text/plain;charset=utf-8")
//   public String updateVipProduce(HttpServletRequest request, HttpServletResponse response) throws IOException {
//       String str=null;
//       String vipAccount=request.getParameter("vipAccount");
//       String vipName=request.getParameter("vipName");
//       String vipCarNumber=request.getParameter("vipCarNumber");
//       String produceName=request.getParameter("produceName");
//
//       return str;
//   }
}
