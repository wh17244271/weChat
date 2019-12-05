package com.suypower.venus.elec.common.common;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public interface Constant {
    /**
     * 同比
     */
    String YEAR_ON_YEAR = "1";
    /**
     * 环比
     */
    String CHAIN_RATIO = "2";

    //数据频度  | (24=24个点,96=96个点,288=288个点,控制points数据显示数量}
    String POINTCOUNT_24 = "24";
    String POINTCOUNT_96 = "96";
    String POINTCOUNT_288 = "288";
    String[] POINTCOUNT_24_ARR = {"00"};
    String[] POINTCOUNT_96_ARR = {"00", "15", "30", "45"};
    String[] POINTCOUNT_288_ARR = {"00", "05", "10", "15", "20", "25", "30", "35", "40", "45", "50", "55"};
    List<String> POINTCOUNT_24_LIST = new ArrayList<>(Arrays.asList(POINTCOUNT_24_ARR));
    List<String> POINTCOUNT_96_LIST = new ArrayList<>(Arrays.asList(POINTCOUNT_96_ARR));
    List<String> POINTCOUNT_288_LIST = new ArrayList<>(Arrays.asList(POINTCOUNT_288_ARR));




}
