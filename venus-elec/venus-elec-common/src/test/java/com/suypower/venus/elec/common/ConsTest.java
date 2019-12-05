//package com.suypower.venus.elec.common;
//
//
//import com.suypower.venus.elec.common.common.Index;
//import com.suypower.venus.elec.common.common.UnitType;
//import com.suypower.venus.elec.common.dao.DaConsDataDao;
//import com.suypower.venus.platform.EtlServerApplication;
//import org.junit.After;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.test.context.web.WebAppConfiguration;
//
//import java.time.LocalDate;
//
//@RunWith( SpringRunner.class)
//@SpringBootTest(classes = EtlServerApplication.class)
//@WebAppConfiguration
//public class ConsTest {
//    @Autowired
//    private DaConsDataDao daConsDataDao;
//    @Before
//    public void init() {
//        System.out.println("开始测试-----------------");
//    }
//
//    @After
//    public void after() {
//        System.out.println("测试结束-----------------");
//    }
//
//    @Test
//    public void firstTest(){
//        String consNo = "0108333074";
//        UnitType[] unitTypes = UnitType.list(UnitType.USER, UnitType.BUILDING);
//        LocalDate[] dates = {LocalDate.of(2019, 03, 01), LocalDate.of(2019, 03, 2)};
//        Index[] indexes = {Index.Ia, Index.SPZW, Index.P}; //01010001
//        String[] dateMonth = {"2019-3", "2019-4"};
//        String mpId = "545725286877028354";
//        String unitId = "550312560935587842";
//    }
//}
