package com.suypower.venus.elec.common.utils;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class Types {
    public static boolean isEmpty(String s){
        return s==null || s.equals("");
    }

    public static boolean isNotEmpty(String s){
        return s!=null && !s.equals("");
    }

    public static boolean isNotEmpty(int s){
        return s!=0;
    }

    public static  Double Double(Object o){
        if(o ==null ){
            return null;
        }
        else if(o instanceof Double){
            return ((Double)o);
        }
        else if(o instanceof Float){
            return ((Float)o).doubleValue();
        }
        else if(o instanceof BigDecimal){
            return ((BigDecimal)o).doubleValue();
        }
        else if( o instanceof  String){
            return Double.valueOf(o.toString());
        }
        else{
            return Double.valueOf(o.toString());
        }
    }

    public static  String String(Object o){
        if(o ==null ){
            return null;
        }
        else if(o instanceof String){
            return (String)o;
        }
        else{
            return String.valueOf(o.toString());
        }
    }


    public static  Long Long(Object o){
        if(o ==null || "".equals(o)){
            return null;
        }
        else if(o instanceof Long){
            return ((Long)o);
        }
        else if(o instanceof Integer){
            return ((Integer)o).longValue();
        }
        else if(o instanceof BigInteger){
            return ((BigInteger)o).longValue();
        }
        else if( o instanceof  String){
            return Long.valueOf(o.toString());
        }
        else{
            return Long.valueOf(o.toString());
        }
    }

    public static LocalDate LocalDate(Object o){
        if(o ==null ){
            return null;
        }
        else if( o instanceof  LocalDate){
            return (LocalDate)o;
        }
        else if(o instanceof java.sql.Date){
            return ((java.sql.Date)o).toLocalDate();
        }
        else if( o instanceof  LocalDateTime){
            return ((LocalDateTime)o).toLocalDate();
        }
        else if( o instanceof  String){
            return Times.parseDate(o.toString());
        }
        return null;
    }

    public static LocalDateTime localDateTime(Object o){
        if(o ==null ){
            return null;
        }
        else if( o instanceof  LocalDateTime){
            return (LocalDateTime)o;
        }
        else if(o instanceof java.sql.Timestamp){
            return ((java.sql.Timestamp)o).toLocalDateTime();
        }
        else if( o instanceof  String){
            return Times.parseDateTime(o.toString());
        }
        return null;
    }
}
