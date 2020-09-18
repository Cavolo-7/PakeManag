package com.auc.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alipay.api.AlipayApiException;
import com.alipay.api.internal.util.AlipaySignature;
import com.auc.pojo.*;
import com.auc.service.AdminService;
import com.auc.service.PersonService;
import com.auc.service.ProducePayService;
import com.auc.service.impl.CarServiceImpl;
import com.auc.util.AlipayConfig;
import com.auc.util.AlipayUtil;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@RestController
@RequestMapping("/person")
public class PersonController {
    @Autowired
    private PersonService personService;

    @Autowired
    private ProducePayService producePayService;

    //获取普通用户表格数据
    @RequestMapping(value = "/getOrdinaryList", produces = "text/plain;charset=utf-8")
    public String getOrdinaryList(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String personName = request.getParameter("key[personName]");
        String account = request.getParameter("key[account]");
        String phone = request.getParameter("key[phone]");
        String personCarnumber = request.getParameter("key[personCarnumber]");
        String curPageStr = request.getParameter("page");
        String pageSizeStr = request.getParameter("limit");
        Integer pageSize = 5;
        Integer curPage = 1;
        int a = 0;
        Map<String, String> condition = new HashMap<>();
        if (null != personName && !"".equalsIgnoreCase(personName)) {
            condition.put("personName", personName);
        }
        if (null != account && !"".equalsIgnoreCase(account)) {
            condition.put("account", account);
        }
        if (null != phone && !"".equalsIgnoreCase(phone)) {
            condition.put("phone", phone);
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
        LayuiData<Person> layuiData = personService.selectOrdinaryList(condition, curPage, pageSize);

        String str = JSON.toJSONString(layuiData);
        return str;
    }

    //获取vip用户表格数据
    @RequestMapping(value = "/getVipList", produces = "text/plain;charset=utf-8")
    public String getVipList(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String personName = request.getParameter("key[personName]");
        String account = request.getParameter("key[account]");
        String phone = request.getParameter("key[phone]");
        String personCarnumber = request.getParameter("key[personCarnumber]");
        String curPageStr = request.getParameter("page");
        String pageSizeStr = request.getParameter("limit");
        Integer pageSize = 5;
        Integer curPage = 1;
        int a = 0;
        Map<String, String> condition = new HashMap<>();
        if (null != personName && !"".equalsIgnoreCase(personName)) {
            condition.put("personName", personName);
        }
        if (null != account && !"".equalsIgnoreCase(account)) {
            condition.put("account", account);
        }
        if (null != phone && !"".equalsIgnoreCase(phone)) {
            condition.put("phone", phone);
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
        LayuiData<Person> layuiData = personService.selectVipList(condition, curPage, pageSize);
//        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd hh:mm:ss").create();
//        String str = gson.toJson(layuiData);
        String str = JSON.toJSONStringWithDateFormat(layuiData, "yyyy-MM-dd HH:mm:ss");
        return str;
    }

    //添加vip用户
    @RequestMapping(value = "/addVip", produces = "text/plain;charset=utf-8")
    public String addVip(HttpServletRequest request, HttpServletResponse response) throws IOException, ParseException {
        String str = null;
        String personId = request.getParameter("personId");
        String personAccount = request.getParameter("personAccount");
        String personName = request.getParameter("personName");
        String personCarnumber = request.getParameter("personCarnumber");
        String produceName = request.getParameter("produceName");
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        Admin admin = (Admin) request.getSession().getAttribute("admin");
        Produce produce = personService.selectProduceId(produceName);//根据产品名称查询产品信息
        Person person = personService.selectPersonId(Integer.parseInt(personId));//根据id查询用户信息
        int allRecharge = produce.getProduceMoney() + person.getPersonRecharge();//用户总消费

        Record record2 = new Record();
        record2.setRecordEndtime(date);
        record2.setProduceMonths(produce.getProduceMonths());
        Date date2 = personService.selectEndTime(record2);//计算截止时间
//        String  date2= personService.selectEndTime(record2);
        System.out.println(date2 + "/**-*");
        String strDate = dateFormat.format(date2);//截止时间格式转换
        System.out.println(strDate + "/*-*-*/");
        Date date3 = dateFormat.parse(strDate);//截止时间格式转换为date

        //开通vip
        Person person2 = new Person();
        person2.setPersonId(Integer.parseInt(personId));
        person2.setPersonScore(allRecharge);
        person2.setPersonAccount(personAccount);
        person2.setWorkerId(admin.getWorkerId());
        person2.setPersonRecharge(allRecharge);
        person2.setPersonCarnumber(personCarnumber);
        person2.setPersonName(personName);
        boolean flag = personService.addVip(person2);//添加vip

        //添加明细
        String thing2 = "现金";//缴费发生
        String thing = "月缴开通";//操作时间
        Detail detail = new Detail();
        detail.setDetailCarnumber(personCarnumber);
        detail.setDetailEvent(thing);
        detail.setProduceId(produce.getProduceId());
        detail.setDetailMoney(produce.getProduceMoney());
        detail.setDetailType(thing2);
        detail.setWorkerId(admin.getWorkerId());
        boolean flag2 = personService.addDetail(detail);

        //添加免检
        Exemption exemption = new Exemption();
        exemption.setExemptionName(personName);
        exemption.setExemptionCarnumber(personCarnumber);
        boolean flag3 = personService.addExemptionPerson(exemption);

        //添加用户记录
        Record record = new Record();
        record.setPersonId(Integer.parseInt(personId));
        record.setProduceId(produce.getProduceId());
        record.setRecordStartime(date);
        record.setRecordEndtime(date3);
        boolean flag4 = personService.addPersonRecords(record);

        if (flag == false && flag2 == false && flag3 == false && flag4 == false) {
            str = "开通失败";
        } else {
            str = "开通成功";
        }
        return str;
    }

    //网络支付添加vip用户
    @RequestMapping(value = "/addVipAlipay", produces = "text/plain;charset=utf-8")
    public String addVipAlipay(HttpServletRequest request, HttpServletResponse response) throws IOException, ParseException {
        String str = null;
        String personId = request.getParameter("personId");
        String personAccount = request.getParameter("personAccount");
        String personName = request.getParameter("personName");
        String personCarnumber = request.getParameter("personCarnumber");
        String produceName = request.getParameter("produceName");
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        Admin admin = (Admin) request.getSession().getAttribute("admin");
        Produce produce = personService.selectProduceId(produceName);//根据产品名称查询产品信息
        Person person = personService.selectPersonId(Integer.parseInt(personId));//根据id查询用户信息
        int allRecharge = produce.getProduceMoney() + person.getPersonRecharge();//用户总消费

        Record record2 = new Record();
        record2.setRecordEndtime(date);
        record2.setProduceMonths(produce.getProduceMonths());
        Date date2 = personService.selectEndTime(record2);//计算截止时间
//        String  date2= personService.selectEndTime(record2);
        System.out.println(date2 + "/**-*");
        String strDate = dateFormat.format(date2);//截止时间格式转换
        System.out.println(strDate + "/*-*-*/");
        Date date3 = dateFormat.parse(strDate);//截止时间格式转换为date

        //开通vip
        Person person2 = new Person();
        person2.setPersonId(Integer.parseInt(personId));
        person2.setPersonAccount(personAccount);
        person2.setPersonScore(allRecharge);
        person2.setWorkerId(admin.getWorkerId());
        person2.setPersonRecharge(allRecharge);
        person2.setPersonCarnumber(personCarnumber);
        person2.setPersonName(personName);
        boolean flag = personService.addVip(person2);//添加vip

        //添加明细
        String thing2 = "支付宝支付";//缴费发生
        String thing = "月缴开通";//操作时间
        Detail detail = new Detail();
        detail.setDetailCarnumber(personCarnumber);
        detail.setDetailEvent(thing);
        detail.setProduceId(produce.getProduceId());
        detail.setDetailMoney(produce.getProduceMoney());
        detail.setDetailType(thing2);
        detail.setWorkerId(admin.getWorkerId());
        boolean flag2 = personService.addDetail(detail);

        //添加免检
        Exemption exemption = new Exemption();
        exemption.setExemptionName(personName);
        exemption.setExemptionCarnumber(personCarnumber);
        boolean flag3 = personService.addExemptionPerson(exemption);

        //添加用户记录
        Record record = new Record();
        record.setPersonId(Integer.parseInt(personId));
        record.setProduceId(produce.getProduceId());
        record.setRecordStartime(date);
        record.setRecordEndtime(date3);
        boolean flag4 = personService.addPersonRecords(record);

        if (flag == false && flag2 == false && flag3 == false && flag4 == false) {
            str = "开通失败";
        } else {
            str = "开通成功";
        }
        return str;
    }

    //查询套餐价格
    @RequestMapping(value = "/selectMoney", produces = "text/plain;charset=utf-8")
    public String selectMoney(HttpServletRequest request, HttpServletResponse response) throws IOException, ParseException {
        String produceName = request.getParameter("produceName");
        System.out.println(produceName);
        String str = null;
        Produce produce = personService.selectProduceId(produceName);
        System.out.println(produce.toString());
        str = produce.getProduceMoney() + "";
        System.out.println(str);
        return str;
    }


    //vip续费
    @RequestMapping(value = "/vipRenew", produces = "text/plain;charset=utf-8")
    public String vipRenew(HttpServletRequest request, HttpServletResponse response) throws IOException, ParseException {
        String str = null;
        String personId = request.getParameter("personId");
        String personAccount = request.getParameter("personAccount");
        String personName = request.getParameter("personName");
        String personCarnumber = request.getParameter("personCarnumber");
        String produceName = request.getParameter("produceName");
        String recordEndtime = request.getParameter("recordEndtime");

        Admin admin = (Admin) request.getSession().getAttribute("admin");
        Produce produce = personService.selectProduceId(produceName);//根据产品名称查询产品信息
        Person person = personService.selectPersonId(Integer.parseInt(personId));//根据id查询用户信息
        int allRecharge = produce.getProduceMoney() + person.getPersonRecharge();//用户总消费
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date3 = dateFormat.parse(recordEndtime);//截止时间格式转换为date
        System.out.println("/*-*-/*" + date3);

        Record record2 = new Record();
        record2.setRecordEndtime(date3);
        record2.setProduceMonths(produce.getProduceMonths());
        Date date2 = personService.selectEndTime(record2);//计算截止时间
//        String  date2= personService.selectEndTime(record2);
        System.out.println("//*-*-" + date2);
        String strDate = dateFormat.format(date2);//格式化截止时间
//        System.out.println("/*-+-/"+strDate);
        Date date = dateFormat.parse(strDate);//格式好的最终截止时间
        System.out.println("/**-/*-*" + date);

        //修改用户总消费金额
        Person person2 = new Person();
        person2.setPersonId(Integer.parseInt(personId));
        person2.setPersonRecharge(allRecharge);
        boolean flag = personService.updateRecharge(person2);

        //添加用户记录
        Record record = new Record();
        record.setPersonId(Integer.parseInt(personId));
        record.setProduceId(produce.getProduceId());
        record.setRecordStartime(date3);
        record.setRecordEndtime(date);
        boolean flag3 = personService.addPersonRecords(record);

        //添加用户明细
        String thing2 = "现金";//缴费发生
        String thing = "月缴续费";//操作时间
        Detail detail = new Detail();
        detail.setDetailCarnumber(personCarnumber);
        detail.setDetailEvent(thing);
        detail.setProduceId(produce.getProduceId());
        detail.setDetailMoney(produce.getProduceMoney());
        detail.setDetailType(thing2);
        detail.setWorkerId(admin.getWorkerId());
        boolean flag2 = personService.addDetail(detail);//添加明细表
        if (flag == false && flag2 == false && flag3 == false) {
            str = "续费失败";
        } else {
            str = "续费成功";
        }
        return str;
    }

    //网上支付vip续费
    @RequestMapping(value = "/renewAlipay", produces = "text/plain;charset=utf-8")
    public String renewAlipay(HttpServletRequest request, HttpServletResponse response) throws IOException, ParseException {
        String str = null;
        String personId = request.getParameter("personId");
        String personAccount = request.getParameter("personAccount");
        String personName = request.getParameter("personName");
        String personCarnumber = request.getParameter("personCarnumber");
        String produceName = request.getParameter("produceName");
        String recordEndtime = request.getParameter("recordEndtime");

        Admin admin = (Admin) request.getSession().getAttribute("admin");
        Produce produce = personService.selectProduceId(produceName);//根据产品名称查询产品信息
        Person person = personService.selectPersonId(Integer.parseInt(personId));//根据id查询用户信息
        int allRecharge = produce.getProduceMoney() + person.getPersonRecharge();//用户总消费
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date3 = dateFormat.parse(recordEndtime);//截止时间格式转换为date
        System.out.println("/*-*-/*" + date3);

        Record record2 = new Record();
        record2.setRecordEndtime(date3);
        record2.setProduceMonths(produce.getProduceMonths());
        Date date2 = personService.selectEndTime(record2);//计算截止时间
//        String  date2= personService.selectEndTime(record2);
        System.out.println("//*-*-" + date2);
        String strDate = dateFormat.format(date2);//格式化截止时间
//        System.out.println("/*-+-/"+strDate);
        Date date = dateFormat.parse(strDate);//格式好的最终截止时间
        System.out.println("/**-/*-*" + date);

        //修改用户总消费金额
        Person person2 = new Person();
        person2.setPersonId(Integer.parseInt(personId));
        person2.setPersonRecharge(allRecharge);
        boolean flag = personService.updateRecharge(person2);

        //添加用户记录
        Record record = new Record();
        record.setPersonId(Integer.parseInt(personId));
        record.setProduceId(produce.getProduceId());
        record.setRecordStartime(date3);
        record.setRecordEndtime(date);
        boolean flag3 = personService.addPersonRecords(record);

        //添加用户明细
        String thing2 = "支付宝支付";//缴费发生
        String thing = "月缴续费";//操作时间
        Detail detail = new Detail();
        detail.setDetailCarnumber(personCarnumber);
        detail.setDetailEvent(thing);
        detail.setProduceId(produce.getProduceId());
        detail.setDetailMoney(produce.getProduceMoney());
        detail.setDetailType(thing2);
        detail.setWorkerId(admin.getWorkerId());
        boolean flag2 = personService.addDetail(detail);//添加明细表
        if (flag == false && flag2 == false && flag3 == false) {
            str = "续费失败";
        } else {
            str = "续费成功";
        }
        return str;
    }

    //vip退费
    @RequestMapping(value = "/vipRefund", produces = "text/plain;charset=utf-8")
    public String vipRefund(HttpServletRequest request, HttpServletResponse response) throws IOException, ParseException {
        String str = null;
        String personId = request.getParameter("personId");
        String personAccount = request.getParameter("personAccount");
        String personName = request.getParameter("personName");
        String personCarnumber = request.getParameter("personCarnumber");
        Admin admin = (Admin) request.getSession().getAttribute("admin");
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String strDate = dateFormat.format(date);
        Date date2 = dateFormat.parse(strDate);
        Record record3 = new Record();
        record3.setRefundTime(date2);
        record3.setPersonId(Integer.parseInt(personId));
        //查询当前使用套餐
        Record record = personService.selectNowProduce(record3);
        //查询未使用的套餐
        List<Record> list = personService.selectNoUseProduce(record3);
        //查询当前使用套餐金额
        Produce produce = personService.selectProduceMoney(record.getProduceId());
        Record record2 = new Record();
        record2.setRecordId(record.getRecordId());
        record2.setRefundTime(date2);
        //判断当前使用的套餐使用天数是否超过半个月
        boolean flag = personService.selectDateTime(record2);
        DecimalFormat df = new DecimalFormat("#.00");
        double refundMoney = 0;
        if (produce.getProduceMonths() == 1) {
            if (flag == true) {
                double money = 0;

                Detail detail2 = new Detail();
                String thing3 = "支付宝支付";//缴费发生
                String thing4 = "月缴退费";//操作时间
                detail2.setDetailCarnumber(personCarnumber);
                detail2.setDetailEvent(thing4);
                detail2.setProduceId(produce.getProduceId());
                detail2.setDetailMoney((int) money);
                detail2.setDetailType(thing3);
                detail2.setWorkerId(admin.getWorkerId());
                boolean flag6 = personService.addDetail(detail2);

                for (int i = 0; i < list.size(); i++) {
                    Record record4 = list.get(i);
                    Produce produce2 = personService.selectProduceMoney(record4.getProduceId());
                    //添加明细
                    Detail detail = new Detail();
                    String thing2 = "退费";//缴费发生
                    String thing = "月缴退费";//操作时间
                    detail.setDetailCarnumber(personCarnumber);
                    detail.setDetailEvent(thing);
                    detail.setProduceId(produce2.getProduceId());
                    detail.setDetailMoney(produce2.getProduceMoney());
                    detail.setDetailType(thing2);
                    detail.setWorkerId(admin.getWorkerId());
                    boolean flag5 = personService.addDetail(detail);

                    money = money + produce2.getProduceMoney();
                }
                System.out.println("超过15天金额" + money);
                refundMoney=money;
                money = Double.parseDouble(df.format(money));
                str = "退款成功！ 退款金额：" + money + "元!";
            } else {
                double money = new BigDecimal((float) produce.getProduceMoney() / 2).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();

                Detail detail2 = new Detail();
                String thing3 = "退费";//缴费发生
                String thing4 = "月缴退费";//操作时间
                detail2.setDetailCarnumber(personCarnumber);
                detail2.setDetailEvent(thing4);
                detail2.setProduceId(produce.getProduceId());
                detail2.setDetailMoney((int) money);
                detail2.setDetailType(thing3);
                detail2.setWorkerId(admin.getWorkerId());
                boolean flag6 = personService.addDetail(detail2);

                for (int i = 0; i < list.size(); i++) {
                    Record record4 = list.get(i);
                    Produce produce2 = personService.selectProduceMoney(record4.getProduceId());

                    //添加明细
                    Detail detail = new Detail();
                    String thing2 = "退费";//缴费发生
                    String thing = "月缴退费";//操作时间
                    detail.setDetailCarnumber(personCarnumber);
                    detail.setDetailEvent(thing);
                    detail.setProduceId(produce2.getProduceId());
                    detail.setDetailMoney(produce2.getProduceMoney());
                    detail.setDetailType(thing2);
                    detail.setWorkerId(admin.getWorkerId());
                    boolean flag5 = personService.addDetail(detail);

                    money = money + produce2.getProduceMoney();
                }
                ;
                System.out.println("未超过15天金额" + money);
                refundMoney=money;
                money = Double.parseDouble(df.format(money));
                str = "退款成功！ 退款金额：" + money + "元!";
            }
        } else {
            if (flag == true) {
                double money = new BigDecimal((float) produce.getProduceMoney() / produce.getProduceMonths()).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
                money = produce.getProduceMoney() - money;
                Detail detail2 = new Detail();
                String thing3 = "退费";//缴费发生
                String thing4 = "月缴退费";//操作时间
                detail2.setDetailCarnumber(personCarnumber);
                detail2.setDetailEvent(thing4);
                detail2.setProduceId(produce.getProduceId());
                detail2.setDetailMoney((int) money);
                detail2.setDetailType(thing3);
                detail2.setWorkerId(admin.getWorkerId());
                boolean flag6 = personService.addDetail(detail2);

                for (int i = 0; i < list.size(); i++) {
                    Record record4 = list.get(i);
                    Produce produce2 = personService.selectProduceMoney(record4.getProduceId());
                    //添加明细
                    Detail detail = new Detail();
                    String thing2 = "退费";//缴费发生
                    String thing = "月缴退费";//操作时间
                    detail.setDetailCarnumber(personCarnumber);
                    detail.setDetailEvent(thing);
                    detail.setProduceId(produce2.getProduceId());
                    detail.setDetailMoney(produce2.getProduceMoney());
                    detail.setDetailType(thing2);
                    detail.setWorkerId(admin.getWorkerId());
                    boolean flag5 = personService.addDetail(detail);
                    money = money + produce2.getProduceMoney();
                }
                System.out.println("大于一个月产品超过15天金额" + money);
                refundMoney=money;
                money = Double.parseDouble(df.format(money));
                str = "退款成功！ 退款金额：" + money + "元!";
            } else {
                double money = new BigDecimal((float) produce.getProduceMoney() / produce.getProduceMonths()).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
                money = money / 2;

                money = Double.parseDouble(df.format(money));

                //添加明细
                Detail detail2 = new Detail();
                String thing3 = "退费";//缴费发生
                String thing4 = "月缴退费";//操作时间
                detail2.setDetailCarnumber(personCarnumber);
                detail2.setDetailEvent(thing4);
                detail2.setProduceId(produce.getProduceId());
                detail2.setDetailMoney((int) money);
                detail2.setDetailType(thing3);
                detail2.setWorkerId(admin.getWorkerId());
                boolean flag6 = personService.addDetail(detail2);

                for (int i = 0; i < list.size(); i++) {
                    Record record4 = list.get(i);
                    Produce produce2 = personService.selectProduceMoney(record4.getProduceId());

                    //添加明细
                    Detail detail = new Detail();
                    String thing2 = "退费";//缴费发生
                    String thing = "月缴退费";//操作时间
                    detail.setDetailCarnumber(personCarnumber);
                    detail.setDetailEvent(thing);
                    detail.setProduceId(produce2.getProduceId());
                    detail.setDetailMoney(produce2.getProduceMoney());
                    detail.setDetailType(thing2);
                    detail.setWorkerId(admin.getWorkerId());
                    boolean flag5 = personService.addDetail(detail);
                    money = money + produce2.getProduceMoney();
                }
                System.out.println("大于一个月未超过15天金额" + money);
                refundMoney=money;
                money = Double.parseDouble(df.format(money));
                str = "退款成功！ 退款金额：" + money + "元!";
            }
        }
        Person person = personService.selectPersonId(Integer.parseInt(personId));
        double personMoney = person.getPersonRecharge() - refundMoney;
        Person person2 = new Person();
        person2.setPersonId(Integer.parseInt(personId));
        person2.setPersonRecharge((int) personMoney);
        //修改用户金额
        boolean flag2 = personService.updateVipIdentity(person2);
        //删除免检用户
        boolean flag3 = personService.deleteExemptionPerson(personCarnumber);
        //删除用户记录
        boolean flag4 = personService.deletePersonRecord(Integer.parseInt(personId));

//        if (flag2==true&&flag3==true&&flag4==true&&flag5==true)
        return str;
    }

//
//    //支付宝缴费
//    @RequestMapping(value = "/zf")
//    public String zf(HttpServletRequest request, HttpServletResponse response) throws IOException, ParseException, AlipayApiException {
//        String uuid = UUID.randomUUID().toString();
//        String subject = request.getParameter("subject");//订单标题
//        String total_amount = request.getParameter("total_amount");//订单总金额
//        String body = request.getParameter("body");//商品描述
//        String personId = request.getParameter("personId");
//        String personAccount = request.getParameter("personAccount");
//        String personName = request.getParameter("personName");
//        String personCarnumber = request.getParameter("personCarnumber");
////        System.out.println(personId + " " + personAccount + " " + personName + " " + personCarnumber + " " + body);
//
//
//        String form = AlipayUtil.getAlipay(uuid, subject, total_amount, body, " http://jc.free.idcfengye.com/person/pyqtAlipay", " http://jc.free.idcfengye.com/person/syncAlipay");
//        //数据库插入数据
//
//        Alipay alipay = new Alipay();
//        alipay.setAlipayCarnumber(personCarnumber);
//        alipay.setAlipayNumber(uuid);
//        alipay.setPersonAccount(personAccount);
//        alipay.setPersonName(personName);
//        alipay.setPersonId(Integer.parseInt(personId));
//        alipay.setProduceName(body);
//        boolean flag = producePayService.addProducePay(alipay);
//        return form;
//    }
//
//    //同步
//    @RequestMapping(value = "/syncAlipay")
//    public ModelAndView syncAlipay(HttpServletRequest request, HttpServletResponse response) throws AlipayApiException, IOException {
//        //获取支付宝GET过来反馈信息
//
//        String str = null;
//        Map<String, String> params = new HashMap<String, String>();
//        Map<String, String[]> requestParams = request.getParameterMap();
//        for (Iterator<String> iter = requestParams.keySet().iterator(); iter.hasNext(); ) {
//            String name = (String) iter.next();
//            String[] values = (String[]) requestParams.get(name);
//            String valueStr = "";
//            for (int i = 0; i < values.length; i++) {
//                valueStr = (i == values.length - 1) ? valueStr + values[i]
//                        : valueStr + values[i] + ",";
//            }
//            params.put(name, valueStr);
//        }
//        boolean signVerified = AlipaySignature.rsaCheckV1(params, AlipayConfig.alipay_public_key, AlipayConfig.charset, AlipayConfig.sign_type); //调用SDK验证签名
//        ModelAndView modelAndView = new ModelAndView();
//        if (signVerified) {
//
////            modelAndView.setViewName("/user/userMenus");
////            str="jsp/OrdinaryManage.jsp";
//        }
//        return modelAndView;
//    }
//
//    //异步
//    @RequestMapping(value = "/pyqtAlipay")
//    public void pyqtAlipay(HttpServletRequest request, HttpServletResponse response) throws AlipayApiException, IOException, ParseException {
//        String str = null;
//
//
//        Map<String, String> params = new HashMap<String, String>();
//        Map<String, String[]> requestParams = request.getParameterMap();
//        for (Iterator<String> iter = requestParams.keySet().iterator(); iter.hasNext(); ) {
//            String name = (String) iter.next();
//            String[] values = (String[]) requestParams.get(name);
//            String valueStr = "";
//            for (int i = 0; i < values.length; i++) {
//                valueStr = (i == values.length - 1) ? valueStr + values[i]
//                        : valueStr + values[i] + ",";
//            }
//            params.put(name, valueStr);
//        }
//        boolean signVerified = AlipaySignature.rsaCheckV1(params, AlipayConfig.alipay_public_key, AlipayConfig.charset, AlipayConfig.sign_type); //调用SDK验证签名
//        if (signVerified) {//验证成功
//            System.out.println("进入异步");
//            String out_trade_no = new String(request.getParameter("out_trade_no").getBytes("ISO-8859-1"), "UTF-8");
//            Alipay alipay = producePayService.selectProducePay(out_trade_no);
//            String personId = alipay.getPersonId() + "";
//            String personAccount = alipay.getPersonAccount();
//            String personName = alipay.getPersonName();
//            String personCarnumber = alipay.getAlipayCarnumber();
//            String produceName = alipay.getProduceName();
//            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//            Date date = new Date();
//            Admin admin = (Admin) request.getSession().getAttribute("admin");
//            Produce produce = personService.selectProduceId(produceName);//根据产品名称查询产品信息
//            Person person = personService.selectPersonId(Integer.parseInt(personId));//根据id查询用户信息
//            int allRecharge = produce.getProduceMoney() + person.getPersonRecharge();//用户总消费
//            Record record2 = new Record();
//            record2.setRecordEndtime(date);
//            record2.setProduceMonths(produce.getProduceMonths());
//            Date date2 = personService.selectEndTime(record2);//计算截止时间
//            String strDate = dateFormat.format(date2);//截止时间格式转换
//            Date date3 = dateFormat.parse(strDate);//截止时间格式转换为date
//
//            //开通vip
//            Person person2 = new Person();
//            person2.setPersonId(Integer.parseInt(personId));
//            person2.setPersonAccount(personAccount);
//            person2.setWorkerId(admin.getWorkerId());
//            person2.setPersonRecharge(allRecharge);
//            person2.setPersonCarnumber(personCarnumber);
//            person2.setPersonName(personName);
//            boolean flag = personService.addVip(person2);//添加vip
//
//            //添加明细
//            String thing2 = "支付宝支付";//缴费发生
//            String thing = "月缴开通";//操作时间
//            Detail detail = new Detail();
//            detail.setDetailCarnumber(personCarnumber);
//            detail.setDetailEvent(thing);
//            detail.setProduceId(produce.getProduceId());
//            detail.setDetailMoney(produce.getProduceMoney());
//            detail.setDetailType(thing2);
//            detail.setWorkerId(admin.getWorkerId());
//            boolean flag2 = personService.addDetail(detail);
//
//            //添加免检
//            Exemption exemption = new Exemption();
//            exemption.setExemptionName(personName);
//            exemption.setExemptionCarnumber(personCarnumber);
//            boolean flag3 = personService.addExemptionPerson(exemption);
//
//            //添加用户记录
//            Record record = new Record();
//            record.setPersonId(Integer.parseInt(personId));
//            record.setProduceId(produce.getProduceId());
//            record.setRecordStartime(date);
//            record.setRecordEndtime(date3);
//            boolean flag4 = personService.addPersonRecords(record);
//
//            if (flag == false && flag2 == false && flag3 == false && flag4 == false) {
//                str = "开通失败";
//            } else {
//                str = "开通成功";
//            }
//
//        } else {
//        }
////        return str;
//    }

//下拉框
@RequestMapping(value = "/selectProuduce", produces = "text/plain;charset=utf-8")
public void selectProuduce(HttpServletRequest request, HttpServletResponse response) throws AlipayApiException, IOException, ParseException {
    //            查询月缴产品名字集合状态
    String str=null;
    List<Produce> produceList2=personService.selectProduceStateName();
    request.getSession().setAttribute("produceList2", produceList2);
//    str=JSON.toJSONString(produceList2);
//    System.out.println(str);
//    return  str;
}

}
