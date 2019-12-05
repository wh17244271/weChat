/**
 * 定义常量
 */

class  TimeConstantEnum{
    constructor(name,title){
        this.name  = name;
        this.title = title;
    }

    getName(){
        return this.name;
    }

    getTitle(){
        return this.title;
    }
}


class  UnitTypeEnum{
    constructor(unitTypeNo,unitTypeName,sort){
        this.unitTypeNo   = unitTypeNo;
        this.unitTypeName = unitTypeName;
        this.sort = sort;
    }
    getUnitTypeNo(){
        return this.unitTypeNo;
    }
    getUnitTypeName(){
        return this.unitTypeName;
    }
    getSort(){
        return this.sort;
    }
}

class  IndexEnum{
    constructor(indBNo,symbol,name,classify){
        this.indBNo   = indBNo;
        this.symbol   = symbol;
        this.name     = name;
        this.classify = classify;
    }
    /**
     * 获取指标编码
     * @return
     */
    getIndBNo(){
        return this.indBNo;
    }
    /**
     * 获取指标符号
     * @return
     */
    getSymbol(){
        return this.symbol;
    }
    /**
     * 获取指标名称
     * @return
     */
    getName(){
        return this.name;
    }
    /**
     * 获取指标分类
     * @return
     */
    getClassify(){
        return this.classify;
    }
}

/**
 * =====================================
 *  1.1	日期常量
 * =====================================
 */
export const TimeConstant = {
    Today     : new TimeConstantEnum("today","今日"),
    Yesterday : new TimeConstantEnum("yesterday","昨日"),
    TheDate   : new TimeConstantEnum("theDate","今日"),
    TheMonth  : new TimeConstantEnum("theMonth","今月"),
    TheYear   : new TimeConstantEnum("theYear","今年"),
    LastDate  : new TimeConstantEnum("lastDate","昨日"),
    LastMonth : new TimeConstantEnum("lastMonth","上月"),
    LastYear  : new TimeConstantEnum("lastYear","去年"),
    SelfDate  : new TimeConstantEnum("selfDate","指定日"),
    SelfMonth : new TimeConstantEnum("selfMonth","指定月"),
    SelfYear  : new TimeConstantEnum("selfYear","指定年"),
    PrevDate  : new TimeConstantEnum("prevDate","指定日前一天"),
    PrevMonth : new TimeConstantEnum("prevMonth","指定月前一月"),
    PrevYear  : new TimeConstantEnum("prevYear","指定年前一年"),
    NextDate  : new TimeConstantEnum("nextDate","指定日后一天"),
    NextMonth : new TimeConstantEnum("nextMonth","指定月后一月"),
    NextYear  : new TimeConstantEnum("nextYear","指定年后一年"),
}

/**
 * =====================================
 *  1.2	单元常量
 * =====================================
 */
export const UnitType = {
    Unknown    : new UnitTypeEnum("0","未知",1),
    User       : new UnitTypeEnum("1","用户",1),
    Building   : new UnitTypeEnum("2","建筑",2),
    Factory    : new UnitTypeEnum("3","厂房",3),
}

/**
 * =====================================
 *  1.3	指标常量
 * =====================================
 */
export const Index = {
    Ua    : new IndexEnum("01010001","ua","A相电压","0101"),
    Ub    : new IndexEnum("01010002","ub","B相电压","0101"),
    Uc    : new IndexEnum("01010003","uc","C相电压","0101"),
    Ia    : new IndexEnum("01020001","ia","A相电流","0102"),
    Ib    : new IndexEnum("01020002","ib","B相电流","0102"),
    Ic    : new IndexEnum("01020003","ic","C相电流","0102"),
    Pa    : new IndexEnum("01030001","pa","A相有功功率","0103"),
    Pb    : new IndexEnum("01030002","pb","B相有功功率","0103"),
    Pc    : new IndexEnum("01030003","pc","C相有功功率","0103"),
    P     : new IndexEnum("01030004","p","总有功功率","0103"),
    SPZW  : new IndexEnum("01040001","spzw","正向有功电能示值","0104"),
    SWZW  : new IndexEnum("11040001","swzw","用水示数","1104"),
    SGZW  : new IndexEnum("12040001","sgzw","用气示数","1204"),
    SHZW  : new IndexEnum("13040001","shzw","用热示数","1304"),
}



