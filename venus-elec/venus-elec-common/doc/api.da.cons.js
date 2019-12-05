/**
 * 后台JSON通用返回结构
 * @type {{code: number, data: number, success: boolean, message: string}}
 */
let  ajaxReponse = {
     version  : 1,
     requestId : "bc44f7c4-86ba-4965-94ad-074ec0ed80a8",
     time    : "2018-09-08 12:12:12",
     code    : 200,   //返回状态码 200请求正常
     success : true,  //操作成功
     message : "成功", //返回消息
     data    : [] | {} | String | Object | null,  //返回数据     具体内容参考对应的业务模块
     dataExt : [] | {} | String | Object | null,  //返回扩展数据  具体内容参考对应的业务模块(保留)
}

/**
 * ==============================
 *  更改信息
 * ==============================
 *
 */ 


/**
 * =====================================
 *  2.3	电力采集数据功能模块 【【企业数据】】
 * =====================================
 */

/**
 *  2.3.1 查询企业【日单条】数据
 * 【请求URL】/app/da/cons/dayData
 * 【参数方式】GET|POST
 * 【请求参数】
 *  1.dataDate     | 必填参数 | 数据日期  | (today=今日数据,yesterday=昨日数据,2019-07-12=指定某天)
 *  2.unitTypeNo   | 必填参数 | 单元编号  | (1=用户,2=建筑,3=厂房 ......)
 *  3.indBNo       | 必填参数 | 指标编号  | (01030004=总有功功率,01010001=A相电流 ......)
 *  4.pointCount   | 可选参数 | 数据频度  | (24=24个点,96=96个点,288=288个点,控制points数据显示数量}
 */
(function(){
let ajaxReponseData =
    {
            orgNo      : "3701",            //供电单位编码
            orgName    : "济南市",           //供电单位名称
            consNo     : "0181821212",      //企业编号
            consName   : "高速齿轮有限公司",  //企业名称
            unitTypeNo : 2,                 //单元编号
            unitType   :{                   //单元对象
                uintTypeNo  : 2,            //单元编号
                uintTypeName:"用户",         //单元名称
                sort        : 1             //单元排序
            },
            indBNo   : "01030004",          //指标编号
            index   :{                      //指标对象
                indBNo   : "01030004",      //指标编号
                symbol   : "szpw",          //指标符号
                name     : "总有功功率",      //指标名称
                classify : "0103"           //指标分类
            },
            dataDate: "2019-07-12",         //数据日期
            month   : "2019-07",            //数据月份
            lastTime: "2019-07-12 12:00:00",//最新数据时间
            lastVal : 239.02,               //最新数据值
            minTime : "2019-07-12 23:45:00",//最小数据时间
            minVal  : 26.24,                //最小数据值
            maxTime : "2019-07-12 13:45:00",//最大数据时间
            maxVal  : 321.24,               //最大数据值
            avgVal  : 268.92,               //平均数据时间
            points  : {                     //数据点位数据
                "00:00": 292,               //00:00的数据
                "00:05": 292,
                "00:10": 292,
                "23:55": 292,               //共计288个
            }
    }
})();

/**
 *  2.3.2 查询企业【日多条】数据(日、周、月、年时间范围查询)
 * 【请求URL】/app/da/cons/dayDataList
 * 【参数方式】GET|POST
 * 【请求参数】
 *  1.timeType       | 必填参数 | 日期类型  | (day=日,week=周,month=月,year=年)
 *  2.timeData       | 必填参数 | 日期内容  |  day     = (today=今日数据,yesterday=昨日数据,[today,yesterday][2019-07-11,2019-07-11]=指定多天)
 *                                           week   =  (2=第二周)
 *                                           month  =  (theMonth=当月,lastMonth=上月,[2019-07,2019-08]=指定多个月份)
 *                                           year   =  (theYear =当年,lastYear =上年|去年,2018=2018年数据,2019=2019年数据)
 *  3.unitTypeNo     | 可选参数 | 单元编号  | (空=全部单元,1=用户,2=建筑,3=厂房,[1,2]=用户和建筑 ......)
 *  4.indBNo         | 可选参数 | 指标编号  | (空=全部指标,01030004=总有功功率,01010001=A相电流,[01030004,01010001]总有功功率和A相电流 ......)
 *  5.pointCount     | 可选参数 | 数据频度  | (24=24个点,96=96个点,288=288个点,控制points数据显示数量}
 *  6.dataDateCycle  | 可选参数 | 数据周期  | (1=同比,2=环比 ......) 自动增加同比、环比查询参数
 *  7.orderBy        | 可选参数 | 排序      | orgNo asc,consName asc 多个排序字段用,隔开
 *  8.fill           | 可选参数 | 填充数据  |  如果按月,显示
 */
(function(){
    let ajaxReponseData =
    [
        {
            orgNo      : "3701",            //供电单位编码
            orgName    : "济南市",           //供电单位名称
            consNo     : "0181821212",      //企业编号
            consName   : "高速齿轮有限公司",  //企业名称
            unitTypeNo : 2,                 //单元编号
            unitType   :{                   //单元对象
                uintTypeNo  : 2,            //单元编号
                uintTypeName:"用户",         //单元名称
                sort        : 1             //单元排序
            },
            indBNo   : "01030004",          //指标编号
            index   :{                      //指标对象
                indBNo   : "01030004",      //指标编号
                symbol   : "szpw",          //指标符号
                name     : "总有功功率",      //指标名称
                classify : "0103"           //指标分类
            },
            dataDate: "2019-07-12",         //数据日期
            month   : "2019-07",            //数据月份
            lastTime: "2019-07-12 12:00:00",//最新数据时间
            lastVal : 239.02,               //最新数据值
            minTime : "2019-07-12 23:45:00",//最小数据时间
            minVal  : 26.24,                //最小数据值
            maxTime : "2019-07-12 13:45:00",//最大数据时间
            maxVal  : 321.24,               //最大数据值
            avgVal  : 268.92,               //平均数据时间
            points  : {                     //数据点位数据
                "00:00": 292,               //00:00的数据
                "00:05": 292,
                "00:10": 292,
                "23:55": 292,               //共计288个
            }
        },
        {
            orgNo      : "3701",            //供电单位编码
            orgName    : "济南市",           //供电单位名称
            consNo     : "0181821212",      //企业编号
            consName   : "高速齿轮有限公司",  //企业名称
            unitTypeNo : 2,                 //单元编号
            unitType   :{                   //单元对象
                uintTypeNo  : 2,            //单元编号
                uintTypeName:"用户",         //单元名称
                sort        : 1             //单元排序
            },
            indBNo   : "01010001",          //指标编号
            index   :{                      //指标对象
                indBNo   : "01010001",      //指标编号
                symbol   : "ia",            //指标符号
                name     : "A相电流",        //指标名称
                classify : "0101"           //指标分类
            },
            dataDate: "2019-07-12",         //数据日期
            month   : "2019-07",            //数据月份
            lastTime: "2019-07-12 12:00:00",//最新数据时间
            lastVal : 239.02,               //最新数据值
            minTime : "2019-07-12 23:45:00",//最小数据时间
            minVal  : 26.24,                //最小数据值
            maxTime : "2019-07-12 13:45:00",//最大数据时间
            maxVal  : 321.24,               //最大数据值
            avgVal  : 268.92,               //平均数据时间
            points  : {                     //数据点位数据
                "00:00": 292,               //00:00的数据
                "00:05": 292,
                "00:10": 292,
                "23:55": 292,               //共计288个
            }
        }
    ]
})();

/**
 *  2.3.3 查询企业【日单条】最值数据
 * 【请求URL】/app/da/cons/dayMostData
 * 【参数方式】GET|POST
 * 【请求参数】
 *  1.dataDate   | 必填参数 | 数据日期  | (today=今日数据,yesterday=昨日数据,2019-07-12=指定某天)
 *  2.unitTypeNo | 必填参数 | 单元编号  | (1=用户,2=建筑,3=厂房 ......)
 *  3.indBNo     | 必填参数 | 指标编号  | (01030004=总有功功率,01010001=A相电流 ......)
 */
(function(){
    let ajaxReponseData =
        {
            orgNo      : "3701",            //供电单位编码
            orgName    : "济南市",           //供电单位名称
            consNo     : "0181821212",      //企业编号
            consName   : "高速齿轮有限公司",  //企业名称
            unitTypeNo : 2,                 //单元编号
            unitType   :{                   //单元对象
                uintTypeNo  : 2,            //单元编号
                uintTypeName:"用户",         //单元名称
                sort        : 1             //单元排序
            },
            indBNo   : "01030004",          //指标编号
            index   :{                      //指标对象
                indBNo   : "01030004",      //指标编号
                symbol   : "szpw",          //指标符号
                name     : "总有功功率",      //指标名称
                classify : "0103"           //指标分类
            },
            dataDate: "2019-07-12",         //数据日期
            month   : "2019-07",            //数据月份
            lastTime: "2019-07-12 12:00:00",//最新数据时间
            lastVal : 239.02,               //最新数据值
            minTime : "2019-07-12 23:45:00",//最小数据时间
            minVal  : 26.24,                //最小数据值
            maxTime : "2019-07-12 13:45:00",//最大数据时间
            maxVal  : 321.24,               //最大数据值
            avgVal  : 268.92,               //平均数据时间
        }
})();

/**
 *  2.3.4 查询企业【日多条】最值数据(日、周、月、年时间范围查询)
 * 【请求URL】/app/da/cons/dayMostDataList
 * 【参数方式】GET|POST
 * 【请求参数】
 *  1.timeType       | 必填参数 | 日期类型  | (day=日,week=周,month=月,year=年)
 *  2.timeData       | 必填参数 | 日期内容  |  day     = (today=今日数据,yesterday=昨日数据,[today,yesterday][2019-07-11,2019-07-11]=指定多天)
 *                                           week   =  (2=第二周)
 *                                           month  =  (theMonth=当月,lastMonth=上月,[2019-07,2019-08]=指定多个月份)
 *                                           year   =  (theYear =当年,lastYear =上年|去年,2018=2018年数据,2019=2019年数据)
 *  3.unitTypeNo     | 可选参数 | 单元编号  | (空=全部单元,1=用户,2=建筑,3=厂房,[1,2]=用户和建筑 ......)
 *  4.indBNo         | 可选参数 | 指标编号  | (空=全部指标,01030004=总有功功率,01010001=A相电流,[01030004,01010001]总有功功率和A相电流 ......)
 *  5.dataDateCycle  | 可选参数 | 数据周期  | (1=同比,2=环比 ......) 自动增加同比、环比查询参数
 *  6.orderBy        | 可选参数 | 排序      | orgNo asc,consName asc 多个排序字段用,隔开
 */
(function(){
    let ajaxReponseData =
    [
        {
            orgNo      : "3701",            //供电单位编码
            orgName    : "济南市",           //供电单位名称
            consNo     : "0181821212",      //企业编号
            consName   : "高速齿轮有限公司",  //企业名称
            unitTypeNo : 2,                 //单元编号
            unitType   :{                   //单元对象
                uintTypeNo  : 2,            //单元编号
                uintTypeName:"用户",         //单元名称
                sort        : 1             //单元排序
            },
            indBNo   : "01030004",          //指标编号
            index   :{                      //指标对象
                indBNo   : "01030004",      //指标编号
                symbol   : "szpw",          //指标符号
                name     : "总有功功率",      //指标名称
                classify : "0103"           //指标分类
            },
            dataDate: "2019-07-01",         //数据日期
            month   : "2019-07",            //数据月份
            lastTime: "2019-07-01 12:00:00",//最新数据时间
            lastVal : 239.02,               //最新数据值
            minTime : "2019-07-01 23:45:00",//最小数据时间
            minVal  : 26.24,                //最小数据值
            maxTime : "2019-07-01 13:45:00",//最大数据时间
            maxVal  : 321.24,               //最大数据值
            avgVal  : 268.92,               //平均数据时间
        },
        {
            orgNo      : "3701",            //供电单位编码
            orgName    : "济南市",           //供电单位名称
            consNo     : "0181821212",      //企业编号
            consName   : "高速齿轮有限公司",  //企业名称
            unitTypeNo : 2,                 //单元编号
            unitType   :{                   //单元对象
                uintTypeNo  : 2,            //单元编号
                uintTypeName:"用户",         //单元名称
                sort        : 1             //单元排序
            },
            indBNo   : "01030004",          //指标编号
            index   :{                      //指标对象
                indBNo   : "01030004",      //指标编号
                symbol   : "szpw",          //指标符号
                name     : "总有功功率",      //指标名称
                classify : "0103"           //指标分类
            },
            dataDate: "2019-07-12",         //数据日期
            month   : "2019-07",            //数据月份
            lastTime: "2019-07-12 12:00:00",//最新数据时间
            lastVal : 239.02,               //最新数据值
            minTime : "2019-07-12 23:45:00",//最小数据时间
            minVal  : 26.24,                //最小数据值
            maxTime : "2019-07-12 13:45:00",//最大数据时间
            maxVal  : 321.24,               //最大数据值
            avgVal  : 268.92,               //平均数据时间
        }
    ]   
})();

/**
 *  2.3.5 查询企业【日单条】用量数据
 * 【请求URL】/app/da/cons/dayDosageData
 * 【参数方式】GET|POST
 * 【请求参数】
 *  1.dataDate   | 必填参数 | 数据日期  | (today=今日数据,yesterday=昨日数据,2019-07-12=指定某天)
 *  2.unitTypeNo | 必填参数 | 单元编号  | (1=用户,2=建筑,3=厂房 ......)
 *  3.indBNo     | 必填参数 | 指标编号  | (01030004=总有功功率,01010001=A相电流 ......)
 */
(function(){
    let ajaxReponseData =
        {
            orgNo      : "3701",            //供电单位编码
            orgName    : "济南市",           //供电单位名称
            consNo     : "0181821212",      //企业编号
            consName   : "高速齿轮有限公司",  //企业名称
            unitTypeNo : 2,                 //单元编号
            unitType   :{                   //单元对象
                uintTypeNo  : 2,            //单元编号
                uintTypeName:"用户",         //单元名称
                sort        : 1             //单元排序
            },
            indBNo   : "01030004",          //指标编号
            index   :{                      //指标对象
                indBNo   : "01030004",      //指标编号
                symbol   : "szpw",          //指标符号
                name     : "总有功功率",      //指标名称
                classify : "0103"           //指标分类
            },
            dataDate: "2019-07-12",         //数据日期
            month   : "2019-07",            //数据月份
            tip     : null,                 //尖峰用量
            peak : 239.02,                  //峰用量
            flat : 323,                     //平峰用量
            valley  : 26.24,                //谷用量
            total : 588.26,                 //合计用量

        }
})();


/**
 *  2.3.6 查询企业【日多条】用量数据(日、周、月、年时间范围查询)
 * 【请求URL】/app/da/cons/dayDosageDataList
 * 【参数方式】GET|POST
 * 【请求参数】
 *  1.timeType       | 必填参数 | 日期类型  | (day=日,week=周,month=月,year=年)
 *  2.timeData       | 必填参数 | 日期内容  |  day    = (today=今日数据,yesterday=昨日数据,[today,yesterday][2019-07-11,2019-07-11]=指定多天)
 *                                           week   =  (2=第二周)
 *                                           month  =  (theMonth=当月,lastMonth=上月,[2019-07,2019-08]=指定多个月份)
 *                                           year   =  (theYear =当年,lastYear =上年|去年,2018=2018年数据,2019=2019年数据)
 *  3.unitTypeNo     | 可选参数 | 单元编号  | (空=全部单元,1=用户,2=建筑,3=厂房,[1,2]=用户和建筑 ......)
 *  4.indBNo         | 可选参数 | 指标编号  | (空=全部指标,01030004=总有功功率,01010001=A相电流,[01030004,01010001]总有功功率和A相电流 ......)
 *  5.dataDateCycle  | 可选参数 | 数据周期  | (1=同比,2=环比 ......) 自动增加同比、环比查询参数
 *  6.orderBy        | 可选参数 | 排序      | orgNo asc,consName asc 多个排序字段用,隔开
 */
(function(){
    let ajaxReponseData =
     [
       {
            orgNo      : "3701",            //供电单位编码
            orgName    : "济南市",           //供电单位名称
            consNo     : "0181821212",      //企业编号
            consName   : "高速齿轮有限公司",  //企业名称
            unitTypeNo : 2,                 //单元编号
            unitType   :{                   //单元对象
                uintTypeNo  : 2,            //单元编号
                uintTypeName:"用户",         //单元名称
                sort        : 1             //单元排序
            },
            indBNo   : "01030004",          //指标编号
            index   :{                      //指标对象
                indBNo   : "01030004",      //指标编号
                symbol   : "szpw",          //指标符号
                name     : "总有功功率",      //指标名称
                classify : "0103"           //指标分类
            },
            dataDate: "2019-07-01",         //数据日期
            month   : "2019-07",            //数据月份
            tip     : null,                 //尖峰用量
            peak : 239.02,                  //峰用量
            flat : 323,                     //平峰用量
            valley  : 26.24,                //谷用量
            total : 588.26,                 //合计用量
        },
        {
            orgNo      : "3701",            //供电单位编码
            orgName    : "济南市",           //供电单位名称
            consNo     : "0181821212",      //企业编号
            consName   : "高速齿轮有限公司",  //企业名称
            unitTypeNo : 2,                 //单元编号
            unitType   :{                   //单元对象
                uintTypeNo  : 2,            //单元编号
                uintTypeName:"用户",         //单元名称
                sort        : 1             //单元排序
            },
            indBNo   : "01030004",          //指标编号
            index   :{                      //指标对象
                indBNo   : "01030004",      //指标编号
                symbol   : "szpw",          //指标符号
                name     : "总有功功率",      //指标名称
                classify : "0103"           //指标分类
            },
            dataDate: "2019-07-12",         //数据日期
            month   : "2019-07",            //数据月份
            tip     : null,                 //尖峰用量
            peak : 239.02,                  //峰用量
            flat : 323,                     //平峰用量
            valley  : 26.24,                //谷用量
            total : 588.26,                 //合计用量
        }
     ]   
})();

/**
 *  2.3.7 查询企业【月单条】数据
 * 【请求URL】/app/da/cons/monthData
 * 【参数方式】GET|POST
 * 【请求参数】
 *  1.dataMonth  | 必填参数 | 数据日期  | (theMonth=当月,lastMonth=上月,2019-07=指定月份)
 *  2.unitTypeNo | 必填参数 | 单元编号  | (1=用户,2=建筑,3=厂房 ......)
 *  3.indBNo     | 必填参数 | 指标编号  | (01030004=总有功功率,01010001=A相电流 ......)
 */
(function(){
    let ajaxReponseData =
        {
            orgNo      : "3701",            //供电单位编码
            orgName    : "济南市",           //供电单位名称
            consNo     : "0181821212",      //企业编号
            consName   : "高速齿轮有限公司",  //企业名称
            unitTypeNo : 2,                 //单元编号
            unitType   :{                   //单元对象
                uintTypeNo  : 2,            //单元编号
                uintTypeName:"用户",         //单元名称
                sort        : 1             //单元排序
            },
            indBNo   : "01030004",          //指标编号
            index   :{                      //指标对象
                indBNo   : "01030004",      //指标编号
                symbol   : "szpw",          //指标符号
                name     : "总有功功率",      //指标名称
                classify : "0103"           //指标分类
            },
            dataMonth : "2019-07",          //数据月份
            minTime : "2019-07-01 23:45:00",//最小数据时间
            minVal  : 26.24,                //最小数据值
            maxTime : "2019-07-12 13:45:00",//最大数据时间
            maxVal  : 321.24,               //最大数据值
            avgVal  : 268.92,               //平均数据时间
        }
})();


/**
 *  2.3.8 查询企业【月多条】数据(月、年时间范围查询)
 * 【请求URL】/app/da/cons/monthDataList
 * 【参数方式】GET|POST
 * 【请求参数】
 *  1.timeType       | 必填参数 | 日期类型  | (month=月,year=年)
 *  2.timeData       | 必填参数 | 日期内容  |  month  =  (theMonth=当月,lastMonth=上月,[2019-07,2019-08]=指定多个月份)
 *                                           year   =  (theYear =当年,lastYear =上年|去年,2018=2018年数据,2019=2019年数据)
 *  3.unitTypeNo     | 可选参数 | 单元编号  | (空=全部单元,1=用户,2=建筑,3=厂房,[1,2]=用户和建筑 ......)
 *  4.indBNo         | 可选参数 | 指标编号  | (空=全部指标,01030004=总有功功率,01010001=A相电流,[01030004,01010001]总有功功率和A相电流 ......)
 *  5.dataDateCycle  | 可选参数 | 数据周期  | (1=同比,2=环比 ......) 自动增加同比、环比查询参数
 *  6.orderBy        | 可选参数 | 排序      | orgNo asc,consName asc 多个排序字段用,隔开
 */
(function(){
    let ajaxReponseData =
     [ 
        {
            orgNo      : "3701",            //供电单位编码
            orgName    : "济南市",           //供电单位名称
            consNo     : "0181821212",      //企业编号
            consName   : "高速齿轮有限公司",  //企业名称
            unitTypeNo : 2,                 //单元编号
            unitType   :{                   //单元对象
                uintTypeNo  : 2,            //单元编号
                uintTypeName:"用户",         //单元名称
                sort        : 1             //单元排序
            },
            indBNo   : "01030004",          //指标编号
            index   :{                      //指标对象
                indBNo   : "01030004",      //指标编号
                symbol   : "szpw",          //指标符号
                name     : "总有功功率",      //指标名称
                classify : "0103"           //指标分类
            },
            dataMonth : "2019-06",          //数据月份
            minTime : "2019-06-01 23:45:00",//最小数据时间
            minVal  : 26.24,                //最小数据值
            maxTime : "2019-06-12 13:45:00",//最大数据时间
            maxVal  : 321.24,               //最大数据值
            avgVal  : 268.92,               //平均数据时间
        },
        {
            orgNo      : "3701",            //供电单位编码
            orgName    : "济南市",           //供电单位名称
            consNo     : "0181821212",      //企业编号
            consName   : "高速齿轮有限公司",  //企业名称
            unitTypeNo : 2,                 //单元编号
            unitType   :{                   //单元对象
                uintTypeNo  : 2,            //单元编号
                uintTypeName:"用户",         //单元名称
                sort        : 1             //单元排序
            },
            indBNo   : "01030004",          //指标编号
            index   :{                      //指标对象
                indBNo   : "01030004",      //指标编号
                symbol   : "szpw",          //指标符号
                name     : "总有功功率",      //指标名称
                classify : "0103"           //指标分类
            },
            dataMonth : "2019-07",          //数据月份
            minTime : "2019-07-01 23:45:00",//最小数据时间
            minVal  : 26.24,                //最小数据值
            maxTime : "2019-07-12 13:45:00",//最大数据时间
            maxVal  : 321.24,               //最大数据值
            avgVal  : 268.92,               //平均数据时间
        }
    ]    
})();

/**
 *  2.3.9 查询企业【月单条】用量数据
 * 【请求URL】/app/da/cons/monthDosageData
 * 【参数方式】GET|POST
 * 【请求参数】
 *  1.dataMonth  | 必填参数 | 数据日期  | (theMonth=当月,lastMonth=上月,2019-07=指定月份)
 *  2.unitTypeNo | 必填参数 | 单元编号  | (1=用户,2=建筑,3=厂房 ......)
 *  3.indBNo     | 必填参数 | 指标编号  | (01030004=总有功功率,01010001=A相电流 ......)
 */
(function(){
    let ajaxReponseData =
        {
            orgNo      : "3701",            //供电单位编码
            orgName    : "济南市",           //供电单位名称
            consNo     : "0181821212",      //企业编号
            consName   : "高速齿轮有限公司",  //企业名称
            unitTypeNo : 2,                 //单元编号
            unitType   :{                   //单元对象
                uintTypeNo  : 2,            //单元编号
                uintTypeName:"用户",         //单元名称
                sort        : 1             //单元排序
            },
            indBNo   : "01030004",          //指标编号
            index   :{                      //指标对象
                indBNo   : "01030004",      //指标编号
                symbol   : "szpw",          //指标符号
                name     : "总有功功率",      //指标名称
                classify : "0103"           //指标分类
            },
            month   : "2019-07",            //数据月份
            tip     : null,                 //尖峰用量
            peak : 239.02,                  //峰用量
            flat : 323,                     //平用量
            valley  : 26.24,                //谷用量
            total : 588.26,                 //合计用量
        }
})();


/**
 *  2.3.10 查询企业【月多条】用量数据(月、年时间范围查询)
 * 【请求URL】/app/da/cons/monthDosageDataList
 * 【参数方式】GET|POST
 * 【请求参数】
 *  1.timeType       | 必填参数 | 日期类型  | (month=月,year=年)
 *  2.timeData       | 必填参数 | 日期内容  |  month  =  (theMonth=当月,lastMonth=上月,[2019-07,2019-08]=指定多个月份)
 *                                           year   =  (theYear =当年,lastYear =上年|去年,2018=2018年数据,2019=2019年数据)
 *  3.unitTypeNo     | 可选参数 | 单元编号  | (空=全部单元,1=用户,2=建筑,3=厂房,[1,2]=用户和建筑 ......)
 *  4.indBNo         | 可选参数 | 指标编号  | (空=全部指标,01030004=总有功功率,01010001=A相电流,[01030004,01010001]总有功功率和A相电流 ......)
 *  5.dataDateCycle  | 可选参数 | 数据周期  | (1=同比,2=环比 ......) 自动增加同比、环比查询参数
 *  6.orderBy        | 可选参数 | 排序      | orgNo asc,consName asc 多个排序字段用,隔开
 *  
 */
(function(){
    let ajaxReponseData =
     [
        {
            orgNo      : "3701",            //供电单位编码
            orgName    : "济南市",           //供电单位名称
            consNo     : "0181821212",      //企业编号
            consName   : "高速齿轮有限公司",  //企业名称
            unitTypeNo : 2,                 //单元编号
            unitType   :{                   //单元对象
                uintTypeNo  : 2,            //单元编号
                uintTypeName:"用户",         //单元名称
                sort        : 1             //单元排序
            },
            indBNo   : "01030004",          //指标编号
            index   :{                      //指标对象
                indBNo   : "01030004",      //指标编号
                symbol   : "szpw",          //指标符号
                name     : "总有功功率",      //指标名称
                classify : "0103"           //指标分类
            },
            month   : "2019-06",            //数据月份
            tip     : null,                 //尖峰用量
            peak : 239.02,                  //峰用量
            flat : 323,                     //平峰用量
            valley  : 26.24,                //谷用量
            total : 588.26,                 //合计用量
        },
        {
            orgNo      : "3701",            //供电单位编码
            orgName    : "济南市",           //供电单位名称
            consNo     : "0181821212",      //企业编号
            consName   : "高速齿轮有限公司",  //企业名称
            unitTypeNo : 2,                 //单元编号
            unitType   :{                   //单元对象
                uintTypeNo  : 2,            //单元编号
                uintTypeName:"用户",         //单元名称
                sort        : 1             //单元排序
            },
            indBNo   : "01030004",          //指标编号
            index   :{                      //指标对象
                indBNo   : "01030004",      //指标编号
                symbol   : "szpw",          //指标符号
                name     : "总有功功率",      //指标名称
                classify : "0103"           //指标分类
            },
            month   : "2019-07",            //数据月份
            tip     : null,                 //尖峰用量
            peak : 239.02,                  //峰用量
            flat : 323,                     //平峰用量
            valley  : 26.24,                //谷用量
            total : 588.26,                 //合计用量
        }
     ]   
})();

/**
 *  2.3.11 获取统计企业用量数据(当日、当月、当年、上日、上月、上年)
 * 【请求URL】/app/da/cons/totalDosageData
 * 【参数方式】GET|POST
 * 【请求参数】
 *  1.dataDate       | 必填参数 | 数据日期  | (today=今日数据,yesterday=昨日数据,2019-07-12=指定某天)
 *  2.unitTypeNo     | 必填参数 | 单元编号  | (1=用户,2=建筑,3=厂房 ......)
 *  3.indBNo         | 必填参数 | 指标编号  | (01030004=总有功功率,01010001=A相电流 ......)
 */
(function(){
    let ajaxReponseData =
        {
            orgNo      : "3701",            //供电单位编码
            orgName    : "济南市",           //供电单位名称
            consNo     : "0181821212",      //企业编号
            consName   : "高速齿轮有限公司",  //企业名称
            unitTypeNo : 2,                 //单元编号
            unitType   :{                   //单元对象
                uintTypeNo  : 2,            //单元编号
                uintTypeName:"用户",         //单元名称
                sort        : 1             //单元排序
            },
            indBNo   : "01030004",          //指标编号
            index   :{                      //指标对象
                indBNo   : "01030004",      //指标编号
                symbol   : "szpw",          //指标符号
                name     : "总有功功率",      //指标名称
                classify : "0103",           //指标分类
            },
            selfDataDate   : "2019-07-22",         //当日
            selfDateTip    : 239.02,               //当日尖峰用量
            selfDatePeak   : 323,                   //当日峰用量
            selfDateFlat   : 26.24,                //当日平用量
            selfDateValley : 588.26,                 //当日谷用量
            selfDateTotal  : 232,                 //当日合计用量   the

            selfDataMonth   : "2019-07",                 //当月
            selfMonthTip    : 239.02,                  //当月尖峰用量
            selfMonthPeak   : 323,                     //当月峰用量
            selfMonthFlat   : 26.24,                //当月平用量
            selfMonthValley : 588.26,                 //当月谷用量
            selfMonthTotal  : 232,

            selfDataYear   : "2019",                  //当年
            selfYearTip    : 239.02,                  //当年尖峰用量
            selfYearPeak   : 323,                     //当年峰用量
            selfYearFlat   : 26.24,                //当年平用量
            selfYearValley : 588.26,                 //当年谷用量
            selfYearTotal  : 232,                    //当年合计用量

            prevDataDate   : "2019-07-21",                 //上一日
            prevDateTip    : 239.02,                  //上一日尖峰用量
            prevDatePeak   : 323,                     //上一日峰用量
            prevDateFlat   : 26.24,                //上一日平用量
            prevDateValley : 588.26,                 //上一日谷用量
            prevDateTotal  : 232,                    //上一日合计用量

            prevDataMonth   : "2019-06",                 //上一月
            prevMonthTip    : 239.02,                  //上一月尖峰用量
            prevMonthPeak   : 323,                     //上一月峰用量
            prevMonthFlat   : 26.24,                //上一月平用量
            prevMonthValley : 588.26,                 //上一月谷用量
            prevMonthTotal  : 232,                    //上一月合计用量

            prevDataYear   : "2018",                 //上一年
            prevYearTip    : 239.02,                  //上一年尖峰用量
            prevYearPeak   : 323,                     //上一年峰用量
            prevYearFlat   : 26.24,                //上一年平用量
            prevYearValley : 588.26,                 //上一年谷用量
            prevYearTotal  : 232,
        }
})();


