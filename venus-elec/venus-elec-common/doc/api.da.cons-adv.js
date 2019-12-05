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
 *  2.3.3 查询企业【日单条】用量数据(含同比、环比)
 * 【请求URL】/app/da/cons/adv/dayDosageData
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

            monDataDate  : "2019-06-12",        //数据日期【环比】
            monMonth     : "2019-06",           //数据月份【环比】
            monTip       :  null,               //尖峰用量【环比】
            monTipRatio  :  21.2,               //尖峰占比值【环比】百分数
            monPeak      :  239.02,             //峰用量【环比】
            monPeakRatio :  12.2,               //峰占比值【环比】百分数
            monFlat      :  323,                //平用量【环比】
            monFlatRatio :  null,               //平占比值【环比】百分数
            monValley    :  26.24,              //谷用量【环比】
            monValleyRatio: null,               //谷占比值【环比】百分数
            monTotal      : 588.26,             //合计用量【环比】
            monTotalRatio : 21.2,               //合计占比值【环比】百分数

            yoyDataDate  : "2018-07-12",        //数据日期【同比】
            yoyMonth     : "2018-07",           //数据月份【同比】
            yoyTip       :  null,               //尖峰用量【同比】
            yoyTipRatio  :  21.2,               //尖峰占比值【同比】百分数
            yoyPeak      :  239.02,             //峰用量【同比】
            yoyPeakRatio :  12.2,               //峰占比值【同比】百分数
            yoyFlat      :  323,                //平用量【同比】
            yoyFlatRatio :  null,               //平占比值【同比】百分数
            yoyValley    :  26.24,              //谷用量【同比】
            yoyValleyRatio: null,               //谷占比值【同比】百分数
            yoyTotal      : 588.26,             //合计用量【同比】
            yoyTotalRatio : 21.2,               //合计占比值【同比】百分数
        }
})();


/**
 *  2.3.4 查询企业【日多条】用量数据(含同比、环比)
 * 【请求URL】/app/da/cons/adv/dayDosageDataList
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
                dataDate: "2019-07-12",         //数据日期
                month   : "2019-07",            //数据月份
                tip     : null,                 //尖峰用量
                peak : 239.02,                  //峰用量
                flat : 323,                     //平峰用量
                valley  : 26.24,                //谷用量
                total : 588.26,                 //合计用量

                monDataDate  : "2019-06-12",        //数据日期【环比】
                monMonth     : "2019-06",           //数据月份【环比】
                monTip       :  null,               //尖峰用量【环比】
                monTipRatio  :  21.2,               //尖峰占比值【环比】百分数
                monPeak      :  239.02,             //峰用量【环比】
                monPeakRatio :  12.2,               //峰占比值【环比】百分数
                monFlat      :  323,                //平用量【环比】
                monFlatRatio :  null,               //平占比值【环比】百分数
                monValley    :  26.24,              //谷用量【环比】
                monValleyRatio: null,               //谷占比值【环比】百分数
                monTotal      : 588.26,             //合计用量【环比】
                monTotalRatio : 21.2,               //合计占比值【环比】百分数

                yoyDataDate  : "2018-07-12",        //数据日期【同比】
                yoyMonth     : "2018-07",           //数据月份【同比】
                yoyTip       :  null,               //尖峰用量【同比】
                yoyTipRatio  :  21.2,               //尖峰占比值【同比】百分数
                yoyPeak      :  239.02,             //峰用量【同比】
                yoyPeakRatio :  12.2,               //峰占比值【同比】百分数
                yoyFlat      :  323,                //平用量【同比】
                yoyFlatRatio :  null,               //平占比值【同比】百分数
                yoyValley    :  26.24,              //谷用量【同比】
                yoyValleyRatio: null,               //谷占比值【同比】百分数
                yoyTotal      : 588.26,             //合计用量【同比】
                yoyTotalRatio : 21.2,               //合计占比值【同比】百分数

            },
            {
                orgNo      : "3701",            //供电单位编码
                orgName    : "济南市",           //供电单位名称
                consNo     : "5581821212",      //企业编号
                consName   : "荣昌制药有限公司",  //企业名称
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

                monDataDate  : "2019-06-12",        //数据日期【环比】
                monMonth     : "2019-06",           //数据月份【环比】
                monTip       :  null,               //尖峰用量【环比】
                monTipRatio  :  21.2,               //尖峰占比值【环比】百分数
                monPeak      :  239.02,             //峰用量【环比】
                monPeakRatio :  12.2,               //峰占比值【环比】百分数
                monFlat      :  323,                //平用量【环比】
                monFlatRatio :  null,               //平占比值【环比】百分数
                monValley    :  26.24,              //谷用量【环比】
                monValleyRatio: null,               //谷占比值【环比】百分数
                monTotal      : 588.26,             //合计用量【环比】
                monTotalRatio : 21.2,               //合计占比值【环比】百分数

                yoyDataDate  : "2018-07-12",        //数据日期【同比】
                yoyMonth     : "2018-07",           //数据月份【同比】
                yoyTip       :  null,               //尖峰用量【同比】
                yoyTipRatio  :  21.2,               //尖峰占比值【同比】百分数
                yoyPeak      :  239.02,             //峰用量【同比】
                yoyPeakRatio :  12.2,               //峰占比值【同比】百分数
                yoyFlat      :  323,                //平用量【同比】
                yoyFlatRatio :  null,               //平占比值【同比】百分数
                yoyValley    :  26.24,              //谷用量【同比】
                yoyValleyRatio: null,               //谷占比值【同比】百分数
                yoyTotal      : 588.26,             //合计用量【同比】
                yoyTotalRatio : 21.2,               //合计占比值【同比】百分数
            }
        ]
})();


/**
 *  2.3.5 查询企业【日单条】用量数据(含同比、环比、月份每天用量数据集合)
 * 【请求URL】/app/da/cons/adv/dayDosageMonthData
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

            monDataDate  : "2019-06-12",        //数据日期【环比】
            monMonth     : "2019-06",           //数据月份【环比】
            monTip       :  null,               //尖峰用量【环比】
            monTipRatio  :  21.2,               //尖峰占比值【环比】百分数
            monPeak      :  239.02,             //峰用量【环比】
            monPeakRatio :  12.2,               //峰占比值【环比】百分数
            monFlat      :  323,                //平用量【环比】
            monFlatRatio :  null,               //平占比值【环比】百分数
            monValley    :  26.24,              //谷用量【环比】
            monValleyRatio: null,               //谷占比值【环比】百分数
            monTotal      : 588.26,             //合计用量【环比】
            monTotalRatio : 21.2,               //合计占比值【环比】百分数

            yoyDataDate  : "2018-07-12",        //数据日期【同比】
            yoyMonth     : "2018-07",           //数据月份【同比】
            yoyTip       :  null,               //尖峰用量【同比】
            yoyTipRatio  :  21.2,               //尖峰占比值【同比】百分数
            yoyPeak      :  239.02,             //峰用量【同比】
            yoyPeakRatio :  12.2,               //峰占比值【同比】百分数
            yoyFlat      :  323,                //平用量【同比】
            yoyFlatRatio :  null,               //平占比值【同比】百分数
            yoyValley    :  26.24,              //谷用量【同比】
            yoyValleyRatio: null,               //谷占比值【同比】百分数
            yoyTotal      : 588.26,             //合计用量【同比】
            yoyTotalRatio : 21.2,               //合计占比值【同比】百分数

            items: [
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
                    dataDate: "2019-07-02",         //数据日期
                    month   : "2019-07",            //数据月份
                    tip     : null,                 //尖峰用量
                    peak : 239.02,                  //峰用量
                    flat : 323,                     //平峰用量
                    valley  : 26.24,                //谷用量
                    total : 588.26,                 //合计用量
                }
            ]
        }
})();


/**
 *  2.3.6 查询企业【日多条】用量数据(含同比、环比、月份每天用量数据集合)
 * 【请求URL】/app/da/cons/adv/dayDosageMonthDataList
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

           monDataDate  : "2019-06-12",        //数据日期【环比】
           monMonth     : "2019-06",           //数据月份【环比】
           monTip       :  null,               //尖峰用量【环比】
           monTipRatio  :  21.2,               //尖峰占比值【环比】百分数
           monPeak      :  239.02,             //峰用量【环比】
           monPeakRatio :  12.2,               //峰占比值【环比】百分数
           monFlat      :  323,                //平用量【环比】
           monFlatRatio :  null,               //平占比值【环比】百分数
           monValley    :  26.24,              //谷用量【环比】
           monValleyRatio: null,               //谷占比值【环比】百分数
           monTotal      : 588.26,             //合计用量【环比】
           monTotalRatio : 21.2,               //合计占比值【环比】百分数

           yoyDataDate  : "2018-07-12",        //数据日期【同比】
           yoyMonth     : "2018-07",           //数据月份【同比】
           yoyTip       :  null,               //尖峰用量【同比】
           yoyTipRatio  :  21.2,               //尖峰占比值【同比】百分数
           yoyPeak      :  239.02,             //峰用量【同比】
           yoyPeakRatio :  12.2,               //峰占比值【同比】百分数
           yoyFlat      :  323,                //平用量【同比】
           yoyFlatRatio :  null,               //平占比值【同比】百分数
           yoyValley    :  26.24,              //谷用量【同比】
           yoyValleyRatio: null,               //谷占比值【同比】百分数
           yoyTotal      : 588.26,             //合计用量【同比】
           yoyTotalRatio : 21.2,               //合计占比值【同比】百分数
            items: [
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
                   dataDate: "2019-07-02",         //数据日期
                   month   : "2019-07",            //数据月份
                   tip     : null,                 //尖峰用量
                   peak : 239.02,                  //峰用量
                   flat : 323,                     //平峰用量
                   valley  : 26.24,                //谷用量
                   total : 588.26,                 //合计用量
               }
            ]
        },
        {
            orgNo      : "3701",            //供电单位编码
            orgName    : "济南市",           //供电单位名称
            consNo     : "5581821212",      //企业编号
            consName   : "荣昌制药有限公司",  //企业名称
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

            monDataDate  : "2019-06-12",        //数据日期【环比】
            monMonth     : "2019-06",           //数据月份【环比】
            monTip       :  null,               //尖峰用量【环比】
            monTipRatio  :  21.2,               //尖峰占比值【环比】百分数
            monPeak      :  239.02,             //峰用量【环比】
            monPeakRatio :  12.2,               //峰占比值【环比】百分数
            monFlat      :  323,                //平用量【环比】
            monFlatRatio :  null,               //平占比值【环比】百分数
            monValley    :  26.24,              //谷用量【环比】
            monValleyRatio: null,               //谷占比值【环比】百分数
            monTotal      : 588.26,             //合计用量【环比】
            monTotalRatio : 21.2,               //合计占比值【环比】百分数

            yoyDataDate  : "2018-07-12",        //数据日期【同比】
            yoyMonth     : "2018-07",           //数据月份【同比】
            yoyTip       :  null,               //尖峰用量【同比】
            yoyTipRatio  :  21.2,               //尖峰占比值【同比】百分数
            yoyPeak      :  239.02,             //峰用量【同比】
            yoyPeakRatio :  12.2,               //峰占比值【同比】百分数
            yoyFlat      :  323,                //平用量【同比】
            yoyFlatRatio :  null,               //平占比值【同比】百分数
            yoyValley    :  26.24,              //谷用量【同比】
            yoyValleyRatio: null,               //谷占比值【同比】百分数
            yoyTotal      : 588.26,             //合计用量【同比】
            yoyTotalRatio : 21.2,               //合计占比值【同比】百分数
            items: [
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
                    dataDate: "2019-07-02",         //数据日期
                    month   : "2019-07",            //数据月份
                    tip     : null,                 //尖峰用量
                    peak : 239.02,                  //峰用量
                    flat : 323,                     //平峰用量
                    valley  : 26.24,                //谷用量
                    total : 588.26,                 //合计用量
                }
            ]
        }
     ]   
})();
