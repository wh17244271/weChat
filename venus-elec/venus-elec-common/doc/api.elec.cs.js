
/**
 * ==============================
 *    后台JSON通用返回结构
 * ==============================
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
 *  2019-07-17 15:16:18
 * + 新增查询企业一次接线图信息集合接口
 * + 新增查询企业一次接线图单个详细内容接口
 * + 新增查询企业一次接线图实时数据接口
 */ 


/**
 * 1.1	电力功能模块
 */

/**
 * 1.1.1 查询企业所有监测点-树控件
 * 请求URL:/app/elec/cs/topologyTree?id=600359710482292737&disableCheckbox=ids
 * 参数：
 * id              : 非必要参数| 节点Id       |显示该节点及其子节点的树
 * disableCheckbox : 非必要参数| 禁用checkbox |(no=全部不禁用,all=全部禁用checkbox,ids=指定节点Ids禁用,@ids=反向指定节点Ids禁用)
 *                   disableCheckbox=no,disableCheckbox=all,disableCheckbox=600359710482292737,500359710482292737,disableCheckbox=@600359710482292737,500359710482292737
 * checked:328382,328382
 */
let elecNodes = (function(){
     return [
        {
            title   : "1#变压器",   //名称
            expand  : true,        //是否展开直子节点 true|false
            disabled: false,       //禁掉响应 true|false
            disableCheckbox: false, //禁掉 checkbox true|false
            selected       : false, //是否选中子节点 true | false,
            checked        : false, //是否勾选(如果勾选，子节点也会全部勾选) true | false
            id             : "600359710482292737", //唯一ID``
            unitId         : 600359710482292737,   //【具体业务属性】具体业务主键ID
            unitName       : "1#变压器",  //【具体业务属性】
            nodeType       : 1,          //【具体业务属性】节点类型(企业、单元、测点、供电单位等等)业务属性数量不定....
            children       : [
                {
                    title   : "1#变压器",
                    expand  : true,
                    disabled: false,
                    disableCheckbox: false,
                    selected       : false,
                    checked        : false,
                    id             : "500359710482292737", //唯一ID
                    mpId         : 500359710482292737,   //【具体业务属性】具体业务主键ID
                    mpName       : "1#空压机",  //【具体业务属性】
                    mpRate       : 10,         //【具体业务属性】综合倍率
                    nodeType     : 2,          //【具体业务属性】节点类型(企业、单元、测点、供电单位等等)业务属性数量不定....

                }
            ]
        }
    ]
}());


/**
 * ==============================
 *  一次接线图功能模块
 * ==============================
 */
/**
 * 1.2.2 查询企业一次接线图信息
 * 【请求URL】/app/elec/monitor/diagram/list
 * 【参数方式】GET|POST
 * 【请求参数】
 *  1.pGId       | 可选参数 | 上一级一次图标识  | 默认空查询企业所有一次接线图
 *  2.depth      | 可选参数 | 查询深度级别     | (默认空=所有子的节点,0=同辈的,1=儿子辈,2=儿子&孙子辈 ...... )
 */
(function(){
    let ajaxReponseData =
        [
          {
            gId        : 600324778418561025,  //接线图标识
            orgNo      : "3701",              //供电单位编号
            orgName    : "济南市",             //供电单位名称
            consNo     : "0181821212",        //企业编号
            consName   : "高速齿轮有限公司",    //企业名称
            gName      : "1#配电房",           //一次接线名称
            gDesc      : "1#配电房描述",       //一次接线图描述
            pGId       : -1                  //上级一次接线图
          },
          {
            gId        : 700324778418561026,  //接线图标识
            orgNo      : "3701",              //供电单位编号
            orgName    : "济南市",             //供电单位名称
            consNo     : "0181821212",        //企业编号
            consName   : "高速齿轮有限公司",    //企业名称
            gName      : "2#配电房",            //一次接线名称
            gDesc      : "2#配电房描述",       //一次接线图描述
            pGId       : -1                  //上级一次接线图
          }
        ]
})();


/**
 * 1.2.2 查询企业一次接线图单个详细数据
 * 【请求URL】/app/elec/monitor/diagram/detail
 * 【参数方式】GET|POST
 * 【请求参数】
 *  1.gId        | 必填参数 | 一次图标识
 */
(function(){
    let ajaxReponseData =
          {
            gId        : 600324778418561025,  //接线图标识
            orgNo      : "3701",              //供电单位编号
            orgName    : "济南市",             //供电单位名称
            consNo     : "0181821212",        //企业编号
            consName   : "高速齿轮有限公司",    //企业名称
            gName      : "1#配电房",           //一次接线名称
            gDesc      : "1#配电房描述",       //一次接线图描述
            gData      : "<svg></svg>",       //一次接线图svg数据 定义在diagram.svg文件中
            pGId       : -1,                 //上级一次接线图
            elements   : 
            [
               {
                   mId     : 700324778418561025,
                   mpName  : "1#变压器",
                   indexes :
                   [
                      {
                          indBNo   : "01030004",      //指标编号
                          symbol   : "szpw",          //指标符号
                          name     : "总有功功率",      //指标名称
                          classify : "0103"           //指标分类
                      },
                      {
                          indBNo   : "01020001",      //指标编号
                          symbol   : "ia",            //指标符号
                          name     : "A相电流",        //指标名称
                          classify : "0101"           //指标分类
                      }
                   ]
               },
               {
                   mId     : 700324778418561025,
                   mpName  : "2#变压器",
                   indexes :
                   [
                      {
                          indBNo   : "01030004",      //指标编号
                          symbol   : "szpw",          //指标符号
                          name     : "总有功功率",      //指标名称
                          classify : "0103"           //指标分类
                      },
                      {
                          indBNo   : "01020001",      //指标编号
                          symbol   : "ia",            //指标符号
                          name     : "A相电流",        //指标名称
                          classify : "0101"           //指标分类
                      }
                   ]
               }
            ]
          }
})();


/**
 *  1.2.1 查询企业一次接线图实时数据
 * 【请求URL】/app/elec/monitor/diagram/data
 * 【参数方式】GET|POST
 * 【请求参数】
 *  1.gId        | 必填参数 | 一次图标识
 */
(function(){
let ajaxReponseData =
    [
      {
            orgNo      : "3701",            //供电单位编码
            orgName    : "济南市",           //供电单位名称
            consNo     : "0181821212",      //企业编号
            consName   : "高速齿轮有限公司",  //企业名称
            mpId       : 600359710482292737,//测点标识
            mpName     : "1#空压机",         //测点名称
            data       : 
            [
                { 
                   indexBNo : "01010001", 
                   value    : 282.32,
                   dataTime :"2019-07-17 14:12:12",
                   symbol   : "ia",               //指标符号
                },
                { 
                   indexBNo : "01010001", 
                   value    : 282.32,
                   dataTime :"2019-07-17 14:12:12",
                   symbol   : "szpw",            //指标符号
                }
            ]
       },
       {
            orgNo      : "3701",            //供电单位编码
            orgName    : "济南市",           //供电单位名称
            consNo     : "0181821212",      //企业编号
            consName   : "高速齿轮有限公司",  //企业名称
            mpId       : 600359710482292737,//测点标识
            mpName     : "2#空压机",         //测点名称
            data       : 
            [
                { 
                   indexBNo : "01010001", 
                   value    : 282.32,
                   dataTime :"2019-07-17 14:12:12",
                   symbol   : "ia",               //指标符号
                },
                { 
                   indexBNo : "01010001", 
                   value    : 282.32,
                   dataTime :"2019-07-17 14:12:12",
                   symbol   : "szpw",            //指标符号
                }
            ]
       }
    ]
})();


/**
 *  1.2.2 查看企业监测点健康状态
 * 【请求URL】/app/elec/cs/mp/count
 * 【参数方式】GET|POST
 * 【请求参数】
 */
(function(){
let ajaxReponseData =
    [
     {
            orgNo         : "3701",            //供电单位编码
            orgName       : "济南市",           //供电单位名称
            consNo        : "0181821212",      //企业编号
            consName      : "高速齿轮有限公司",  //企业名称
            totalCount    : 32,                //监测点数量
            onlineCount   : 20,                //监测点在线数
            offlineCount  : 30,                //监测点离线率
            list          :
            [
                   
            ]
       }
    ]
})();

/**
 *  1.2.3 查看企业监测点健康状态
 * 【请求URL】/app/elec/cs/mp/objects
 * 【参数方式】GET|POST
 * 【请求参数】
 *  1.gId        | 必填参数 | 一次图标识
 */
(function(){
let ajaxReponseData =
    [
      {
            orgNo         : "3701",            //供电单位编码
            orgName       : "济南市",           //供电单位名称
            consNo        : "0181821212",      //企业编号
            consName      : "高速齿轮有限公司",  //企业名称
            totalCount    : 32,                //监测点数量
            onlineCount   : 20,                //监测点在线数
            offlineCount  : 30,                //监测点离线率
            list          :
            [
                
            ]
       }
    ]
})();



