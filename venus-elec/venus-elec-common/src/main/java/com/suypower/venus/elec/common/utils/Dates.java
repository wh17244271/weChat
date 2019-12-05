//package com.suypower.venus.elec.common.utils;
//
//import com.suypower.venus.elec.common.common.exception.VenusResponseException;
//
//import java.time.LocalDate;
//import java.time.LocalDateTime;
//import java.time.format.DateTimeFormatter;
//
//public class Dates {
//
//    public static DateTimeFormatter defaultYearFormatter = DateTimeFormatter.ofPattern("yyyy");
//
//    public static DateTimeFormatter defaultMonthFormatter = DateTimeFormatter.ofPattern("yyyy-MM");
//
//    public static DateTimeFormatter defaultDateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
//
//    public static DateTimeFormatter defaultDateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
//
//    public static DateTimeFormatter defaultTimeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
//
//    public static DateTimeFormatter blankMonthFormatter = DateTimeFormatter.ofPattern("yyyyMM");
//
//    public static DateTimeFormatter blankDateFormatter = DateTimeFormatter.ofPattern("yyyyMMdd");
//
//    public static DateTimeFormatter blankDateTimeFormatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
//
//
//    private static  String beforeFormat(String dateStr){
//        if(dateStr.indexOf("/")!=-1){
//            dateStr = dateStr.replace("/","");
//        }
//        else if(dateStr.indexOf("-")!=-1){
//            dateStr = dateStr.replace("-","");
//        }
//        dateStr = dateStr.replaceAll(":","").replace(" ","");
//        return dateStr;
//    }
//
//    /**
//     * 解析时间
//     * @param dateStr
//     * @return
//     */
//    public static LocalDate parseDate(String dateStr){
//        LocalDate date;
//        dateStr  = beforeFormat(dateStr);
//        if(dateStr.length()==8){
//            date  = LocalDate.parse(dateStr,blankDateFormatter);
//        }else{
//            throw new VenusResponseException("请输入正确的时间格式");
//        }
//        return date;
//    }
//
//    /**
//     * 解析时间
//     * @param
//     * @return
//     */
//    public static String format(LocalDate date,DateTimeFormatter formatter){
//        return date.format(formatter);
//    }
//
//
//    public static LocalDateTime parseDateTime(String dateTimeStr){
//        LocalDateTime dateTime;
//        dateTimeStr = beforeFormat(dateTimeStr);
//        if(dateTimeStr.length()==14){
//            dateTime  = LocalDateTime.parse(dateTimeStr,blankDateTimeFormatter);
//        }else{
//            throw new VenusResponseException("请输入正确的时间格式");
//        }
//        return dateTime;
//    }
//
//
//
//
//    public static <T> T parse(String any){
//
//    }
//
//    /**
//     * 解析日期
//     * @param any       参考日期
//     * @param constant  日期常量
//     * @param <T>       LocalDate | String(yyyy、yyyy-MM)
//     * @return
//     */
//    public static <T> T parse(String any,DateConstant constant){
//         if(any==null){
//             throw new VenusResponseException("请输入正确的时间格式");
//         }
//         any  =  beforeFormat(any);
//         DateConstant selfDateConstant  = DateConstant.parse(any);
//         LocalDate date = null;
//         //日期常量
//         if(selfDateConstant!=null){
//             date = parse(LocalDate.now(),selfDateConstant);
//         }
//         //年
//         else if(any.length()==4){
//             date = LocalDate.now();
//             date.withYear(Integer.parseInt(any));
//         }
//         //年月
//         else if(any.length()==6){
//             date = LocalDate.parse(any,blankMonthFormatter);
//         }
//         //年月
//         else if(any.length()==8){
//             date = LocalDate.parse(any,blankDateFormatter);
//         }
//         if(date==null){
//             throw new VenusResponseException("请输入正确的时间格式");
//         }
//         return parse(date,constant);
//    }
//
//    /**
//     * 解析日期
//     * @param date      参考日期
//     * @param constant  日期常量
//     * @param <T>       LocalDate | String(yyyy、yyyy-MM)
//     * @return
//     */
//    public static <T> T parse(LocalDate date,DateConstant constant){
//          Object newDate=null;
//          switch (constant){
//              case today:
//                  newDate  =  LocalDate.now();
//                  break;
//              case yesterday:
//                  newDate  =  LocalDate.now().minusDays(1);
//                  break;
//              case theDate:
//                  newDate  =  LocalDate.now();
//                  break;
//              case theMonth:
//                  newDate  =  format(LocalDate.now(),defaultMonthFormatter);
//                  break;
//              case theYear:
//                  newDate  =  format(LocalDate.now(),defaultYearFormatter);
//                  break;
//              case lastDate:
//                  newDate  =  LocalDate.now().minusDays(1);
//                  break;
//              case lastMonth:
//                  newDate  =  format(LocalDate.now().minusMonths(1),defaultMonthFormatter);
//                  break;
//              case lastYear:
//                  newDate  =  format(LocalDate.now().minusYears(1),defaultYearFormatter);
//                  break;
//              case prevDate:
//                  newDate  =  date.minusDays(-1);
//                  break;
//              case prevMonth:
//                  newDate  =  format(date,defaultMonthFormatter);
//                  break;
//              case prevYear:
//                  newDate  =  format(date,defaultYearFormatter);
//                  break;
//              case nextDate:
//                  newDate  =  date.plusDays(1);
//                  break;
//              case nextMonth:
//                  newDate  =  format(date.plusMonths(1),defaultMonthFormatter);
//                  break;
//              case nextYear:
//                  newDate  =  format(date.plusYears(1),defaultYearFormatter);
//                  break;
//          }
//          return  newDate!=null ? (T)newDate : null;
//    }
//}
//
