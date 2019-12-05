package com.suypower.venus.elec.common.utils;

import java.math.RoundingMode;
import java.text.NumberFormat;

/**
 *
 */
public class Maths {


    static int DigitsIsNoDecimal = 10;
//
//    public class Percent{
//
//        private String value;
//
//        private Double d
//
//        public Percent(String value){
//
//        }
//
//    }



    /**
     * 随机生成一个浮动
     *
     * @param lowerPercent 下浮下限百分比
     * @param upperPercent 上浮上限百分比
     * @return
     */
    public static Double randomOfRate(Double lowerPercent, Double upperPercent) {
        Double lower = lowerPercent, upper = upperPercent, ch = 0D;
        if (lower < 0 && upper > 0) {
            ch = -lower;
            lower = lower + ch;
            upper = upper + ch;
        }
        Double range = upperPercent, temp;
        int c = 0, max = 100;
        double random;
        while (c < max) {
            random = Math.random();
            temp = (lower + random * upper % (upper - lower + 1)) - ch;
            if (lowerPercent <= temp && temp <= upperPercent) {
                range = temp;
                break;
            }
            c++;
        }
        return range;
    }

    /**
     * 根据输入数值进行范围内浮动  浮动范围(lowerPercent,upperPercent)
     * <p>
     * 输入：randomOfRate(1000D,-0.1,0.1,2);
     * 输出: 900.00,1020.00,1042.00     900.00<=浮动后值<=1100.00
     * </p>
     *
     * @param source       需要浮动值
     * @param lowerPercent 下浮下限百分比
     * @param upperPercent 上浮上限百分比
     * @param maxDigits    数据精度、保留小数
     * @return
     */
    public static Double randomOfValue(Double source, Double lowerPercent, Double upperPercent, int maxDigits) {
        if (source == null) return null;
        Double range = randomOfRate(lowerPercent, upperPercent);
        Double newValue = (source + source * range);
        return digits(newValue, maxDigits);
    }

    /**
     * 根据输入数值进行范围内浮动  浮动范围(lowerPercent,upperPercent)
     * <p>
     * 输入：randomOfRate(1000D,-0.1,0.1);
     * 输出: 900,1020,1042     900<=浮动后值<=1100
     * </p>
     *
     * @param source       需要浮动值
     * @param lowerPercent 下浮下限百分比
     * @param upperPercent 上浮上限百分比
     * @return 浮动后的值
     */
    public static Double randomOfValue(Double source, Double lowerPercent, Double upperPercent) {
        return randomOfValue(source, lowerPercent, upperPercent, 3);
    }

    /**
     * 根据输入数值进行范围内浮动  浮动范围(lowerSPercent,lowerEPercent) Or (upperSPercent,upperEPercent)
     * <p>
     * 输入：randomOfRate(1000D,-0.05D,-0.02D,0.02D,0.05D,0);
     * 输出: 934,939,935,1047,1063,938     950<=浮动后值<=980 或 980<=浮动后值<=1050
     * </p>
     *
     * @param source
     * @param lowerSPercent
     * @param lowerEPercent
     * @param upperSPercent
     * @param upperEPercent
     * @param maxDigits
     * @return
     */
    public static Double randomOfValue(Double source, Double lowerSPercent, Double lowerEPercent, Double upperSPercent, Double upperEPercent, int maxDigits) {
        if (source == null) return null;
        int mod = (int) (Math.random() * 1000) % 2;
        Double value;
        if (mod == 0) {
            value = randomOfValue(source, lowerSPercent, lowerEPercent, maxDigits);
        } else {
            value = randomOfValue(source, upperSPercent, upperEPercent, maxDigits);
        }
        return value;
    }

//
//    public static void  main(String[] args){
//        int i=0;
//        while (i<100){
//            Double s = 1000D;
//            Double v= randomOfValue(s,-0.05,-0.02D,0.02D,0.05D,2);
//            //randomOfRate(0.02D,0.05D);
//            //randomOfRate(-0.05D,-0.02D);
//            System.out.println(s+"["+(v-s)+"]"+v);
//            i++;
//        }
//
//    }


    public static Double digits(Double source) {
        return digits(source, 3);

    }

    /**
     * 保留小数
     *
     * @param source
     * @param maxDigits
     * @return
     */
    public static Double digits(Double source, int maxDigits) {
        NumberFormat nf = NumberFormat.getNumberInstance();
        nf.setMaximumFractionDigits(maxDigits);
        nf.setGroupingUsed(false);
        String v = nf.format(source);
        return Double.valueOf(v);
    }

    public static Double digits(Double source, int maxDigits, RoundingMode roundingMode) {
        NumberFormat nf = NumberFormat.getNumberInstance();
        nf.setMaximumFractionDigits(maxDigits);
        nf.setRoundingMode(roundingMode);
        nf.setGroupingUsed(false);
        String v = nf.format(source);
        return Double.valueOf(v);
    }


    /**
     * 求两个数之间的同比或环比百分数
     *
     * @param the       当前数
     * @param last      上一个数
     * @param maxDigits 需要保留的小数位数
     * @return
     */
    public static Double yearOnYearOrRatio(Double the, Double last, int maxDigits) {
        if (the == null || last == null) {
            return null;
        } else if (the == 0 || last == 0) {
            return 0.0;
        } else {
            Double digits = digits(((the - last) / last) * 100, maxDigits);
            return digits;
        }

    }


    public static Double multiply(Double source1, Double source2, int maxDigits) {
        return digits(source1 * source2, maxDigits);
    }

    public static Double subtract(Double source1, Double source2) {
        return source1 - source2;
    }

    public static Double divide(Double source1, Double source2, int maxDigits) {
        return digits(source1 / source2, maxDigits);
    }

    public static Double divide(Double source1, Double source2) {
        return divide(source1, source2, 3);
    }

    public static Double getRate(String rateExp, int maxDigits) {
        if (Types.isEmpty(rateExp)) {
            return 1D;
        }
        String[] arr = rateExp.split("/");
        return arr.length > 1 ?
                divide(Types.Double(arr[0]), Types.Double(arr[1]), maxDigits) : Types.Double(arr[0]);
    }


    /**
     * @param source
     * @return
     */
    public static Double digitsX(Double source) {
        return digitsX(source, 1);

    }

    /**
     * 大于10没有小数,小于10开启小数功能
     *
     * @param source
     * @return
     */
    public static Double digitsX(Double source, int maxDigits) {
        if (source == null) {
            return null;
        }
        int v = (int) source.doubleValue();
        if (v >= DigitsIsNoDecimal) {
            return Double.valueOf(v);
        }
        return digits(source, maxDigits);
    }


    public static Double multiplyX(Double source1, Double source2, int maxDigits) {
        return digitsX(source1 * source2, maxDigits);
    }

    public static Double subtractX(Double source1, Double source2) {
        return source1 - source2;
    }

    public static Double divideX(Double source1, Double source2, int maxDigits) {
        return digitsX(source1 / source2, maxDigits);
    }

    public static Double divideX(Double source1, Double source2) {
        return divideX(source1, source2, 3);
    }

}
