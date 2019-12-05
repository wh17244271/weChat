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
 *  2019-07-22 15:16:18
 * + 新增获取验证码接口
 * + 新增用户登录接口
 * + 新增用户登出接口
 * + 新增获取用户菜单
 */ 


/**
 * =====================================
 *  1.0	系统安全支撑模块 【【安全模块】】
 * =====================================
 */
/**
 *  1.0.1 获取验证码
 * 【请求URL】/plat/secure/code
 * 【参数方式】GET
 * 【请求参数】
 */
(function(){
    //获取验证码成功
    let ajaxReponseSuccessData =
        {
            code      : '',      //免验证码登录会直接返回验证码(若为空,需要人工输入验证码)
            src       : 'base64:323232ew323423',      //图片的base64数据(免验证码 src位空)
            utSrc     : '323'    //生成加密因数,临时参数(预留功能)
        }

    //获取验证码成功(免输入)
    let ajaxReponseSuccessNoCodeData =
        {
            code      : '!3283', //免验证码登录会直接返回验证码(若为空,需要人工输入验证码)
            src       : null,     //图片的base64数据(免验证码 src位空)
            utSrc     : '323'    //生成加密因数,临时参数(预留功能)
        }
    //登录成功
    let ajaxReponseFailData =
        {

        }
})();


/**
 * =====================================
 *  1.1	系统核心支撑模块 【【用户模块】】
 * =====================================
 */
/**
 *  1.1.0 用户登录
 * 【请求URL】/plat/sys/user/login
 * 【参数方式】GET|POST
 * 【请求参数】
 *  1.type    | 必填参数 | 登录类型(1=账户密码,2=登录秘钥)
 *  1.ua      | 必填参数 | 登录用户(loginType=1必填)(用户+密码)用户加密因子混淆后的值
 *  3.code    | 可选参数 | 目前验证码(验证码暂时机制,默认2次 不需要验证密码，当错误时需要验证码)如果不用输入,后台回直接返回验证的
 *  4.token   | 可选参数(loginType=2必填) | 登录密钥用于记住密码登录
 *  4.ut      | 可选参数 | 登录用户(loginType=1必填) 加密因子,用户前端混淆加密密码的
 */
(function(){
    //登录成功
    let ajaxReponseSuccessData =
        {
            token      : '32382837283782323232363rwerwe3322',//用户登录成功标识
            userId     : 2382812,//用户Id
            userName   : 12,     //用户信息
            nickName   : '高速齿轮公司',          //昵称
            loginTime  : '2019-08-12 12:12:12', //登录时间
            expire     : '2019-08-12 12:30:12', //登录到期时间,
            url        : null //登录成功跳转url,如果为空执行成功后默认url
            // mainRole   : {
            //     roleId   : 3232823,
            //     roleName : '管理员'
            // }
            // role
        }

    //登录失败
    let ajaxReponseFailData =
        {

        }
})();

/**
 *  1.1.0 用户登录
 * 【请求URL】/plat/sys/user/complexInfo
 * 【参数方式】GET|POST
 * 【请求参数】
 *  1.token    | 必填参数 | 用户登录标识
 */
(function(){
    //登录成功
    let ajaxReponseSuccessData =
        {
            token      : '32382837283782323232363rwerwe3322',//用户登录成功标识
            userId     : 2382812,//用户Id
            userName   : 12,     //用户信息
            nickName   : '高速齿轮公司',          //昵称
            avatar     : 'https://file.iviewui.com/dist/a0e88e83800f138b94d2414621bd9704.png', //用户头像
            loginTime  : '2019-08-12 12:12:12', //登录时间
            expire     : '2019-08-12 12:30:12', //登录到期时间
            url        : null, //登录成功跳转url,如果为空执行成功后默认url
            // mainRole   : {
            //     roleId   : 3232823,
            //     roleName : '管理员'
            // }
            // role
            accesses :
                [
                    {
                        name     : 'plat_user_add',
                        title    : '添加用户',
                        control  : '1',    //(1=隐藏,2=禁用)
                        tip      : '该功能只能在12:00-14:00之间使用',
                    },
                    {
                        name     : 'plat_menu_add',
                        title    : '添加菜单',
                        control  : '1',    //(1=隐藏,2=禁用)
                        tip      : '该功能只能在12:00-14:00之间使用',
                    }
                ],
            menus :
                [
                    {
                        name : "home",      //菜单名称
                        path : "/home",     //菜单路径
                        icon : "md-flower", //菜单图标 可选属性
                        title: "标题",      //菜单标题
                        meta : {
                            hideInMenu : true , //是否因此菜单
                        },
                        component : "main",    //菜单组件
                        children :             //子菜单
                            [
                                {
                                    path: 'params/:id',
                                    name: 'params',
                                    meta:
                                        {
                                            icon: 'md-flower',
                                            title: '{{params.id}}',
                                            notCache: true,                                          //菜单是否缓存
                                            beforeCloseName: 'before_close_normal'
                                        },
                                    component: 'params'
                                }
                            ]
                    }
                ]
        }

    //登录失败
    let ajaxReponseFailData =
        {

        }
})();

/**
 *  1.1.0 用户登录
 * 【请求URL】/plat/sys/user/info
 * 【参数方式】GET|POST
 * 【请求参数】
 *  1.token    | 必填参数 | 用户登录标识
 */
(function(){
    //登录成功
    let ajaxReponseSuccessData =
        {
            token      : '32382837283782323232363rwerwe3322',//用户登录成功标识
            userId     : 2382812,//用户Id
            userName   : 12,     //用户信息
            nickName   : '高速齿轮公司',          //昵称
            avatar     : 'https://file.iviewui.com/dist/a0e88e83800f138b94d2414621bd9704.png', //用户头像
            loginTime  : '2019-08-12 12:12:12', //登录时间
            expire     : '2019-08-12 12:30:12', //登录到期时间
            url        : null, //登录成功跳转url,如果为空执行成功后默认url
        }

    //登录失败
    let ajaxReponseFailData =
        {

        }
})();

/**
 *  1.1.1 用户登出
 * 【请求URL】/plat/sys/user/logout
 * 【参数方式】GET|POST
 * 【请求参数】
 *  1.token    | 必填参数 | 用户登录标识
 */
(function(){
    //登录成功
    let ajaxReponseSuccessData =
        {
            token      : '32382837283782323232363rwerwe3322',//用户登录成功标识
            userId     : 2382812,//用户Id
            userName   : 12,     //用户信息
            nickName   : '高速齿轮公司',          //昵称
            logoutTime : '2019-08-12 12:12:12', //登出时间
        }

    //登录失败
    let ajaxReponseFailData =
        {

        }
})();

/**
 * =====================================
 *  1.2	系统核心支撑模块 【【菜单权限模块】】
 * =====================================
 */

/**
 * 1.2.1 获取用户菜单
 * 【请求URL】/plat/sys/menu/list
 * 【参数方式】GET|POST
 * 【请求参数】
 */
(function(){
    //菜单返回
    let ajaxReponseData =
         [
            {
                name : "home",      //菜单名称
                path : "/home",     //菜单路径
                icon : "md-flower", //菜单图标 可选属性
                title: "标题",      //菜单标题
                meta : {
                    hideInMenu : true , //是否因此菜单
                },
                component : "main",    //菜单组件
                children :             //子菜单
                [
                    {
                        path: 'params/:id',
                        name: 'params',
                        meta:
                            {
                                icon: 'md-flower',
                                title: '{{params.id}}',
                                notCache: true,                                          //菜单是否缓存
                                beforeCloseName: 'before_close_normal'
                            },
                        component: 'params'
                    }
                ]
            }
        ]
})();

/**
 * 1.2.1 系统用户登录
 * 【参数方式】POST
 * 【请求参数】
 *  1.type    | 必填参数 | 登录类型(1=账户密码,2=登录秘钥)
 *  1.ua      | 必填参数 | 登录用户(loginType=1必填)(用户+密码)用户加密因子混淆后的值
 *  3.code    | 可选参数 | 目前验证码(验证码暂时机制,默认2次 不需要验证密码，当错误时需要验证码)如果不用输入,后台回直接返回验证的
 *  4.token   | 可选参数(loginType=2必填) | 登录密钥用于记住密码登录
 *  4.ut      | 可选参数 | 登录用户(loginType=1必填) 加密因子,用户前端混淆加密密码的
 */
(function(){
    //登录成功
    let ajaxReponseSuccessData =
        {
            token      : '32382837283782323232363rwerwe3322',//用户登录成功标识
            userId     : 2382812,//用户Id
            userName   : 12,     //用户信息
            nickName   : '高速齿轮公司',          //昵称
            loginTime  : '2019-08-12 12:12:12', //登录时间
            expire     : '2019-08-12 12:30:12', //登录到期时间
        }

    //登录成功
    let ajaxReponseFailData =
        {

        }
})();


/**
 * 1.1.1 获取消息栏 消息 （返回默认的条数的通知、消息、任务数据）(默认排序规则:未读|未处理|进行中的消息优先显示,如果数量不够在显示已读|已处理|已完成)
 * 【请求URL】/plat/sys/message/bar
 * 【参数方式】GET|POST
 * 【请求参数】
 */
(function(){
    let ajaxReponseData =
        {
            notices  :
                [
                    {
                        nId        : 500359710482292737,            //通知ID
                        title      : "1百张被很再即二声色济况验志并全",  //通知标题
                        createTime : "2010-07-12 12:12:12",         //通知消息
                        isRead     : true,                          //已读状态 0 未读 1已读
                        readTime   : "2010-07-12 13:12:12",         //阅读时间
                        content    : "内容",                        //内容
                        icon       : "",                            //消息图标
                        levelId    : "1" ,                          //消息级别（字典表定义）
                        levelLabel : "一般",                         //消息级别
                        classifyId : "1",                           //消息分类标识
                        classifyName:"电能质量",                     //消息分类名称
                        userId      : "用户ID",
                        url         : "",                           //消息地址
                        displayMode : "1"                          //显示方式
                    },
                    {
                        nId        : 600359710482292737,            //通知ID
                        title      : "2百张被很再即二声色济况验志并全",  //通知标题
                        createTime : "2010-07-12 12:12:12",         //通知消息
                        isRead     : true,                          //已读状态 0 未读 1已读
                        readTime   : "2010-07-12 13:12:12",         //阅读时间
                        icon       : "",                            //消息图标
                        content    : "内容",                     //内容
                        levelId    : "1" ,                          //消息级别（字典表定义）
                        levelLabel : "一般",                         //消息级别
                        classifyId : "1",                           //消息分类标识
                        classifyName:"电能质量",                     //消息分类名称
                        userId      : "用户ID",
                        url         : "",                           //消息地址，
                        displayMode : "1"                          //显示方式
                    }
                ],
            messages  :
                [
                    {
                        nId        : 500359710482292737,            //通知ID
                        title      : "1百张被很再即二声色济况验志并全",  //通知标题
                        createTime : "2010-07-12 12:12:12",         //通知消息
                        isRead     : true,                          //已读状态 0 未读 1已读
                        readTime   : "2010-07-12 13:12:12",         //阅读时间
                        icon       : "",                            //消息图标
                        content    : "内容",                     //内容
                        levelId    : "1" ,                          //消息级别（字典表定义）
                        levelLabel : "一般",                         //消息级别
                        classifyId : "1",                           //消息分类标识
                        classifyName:"电能质量",                     //消息分类名称
                        userId      : "用户ID",
                        url         : "",                           //消息地址
                        displayMode : "1"                          //显示方式
                    },
                    {
                        nId        : 600359710482292737,            //通知ID
                        title      : "2百张被很再即二声色济况验志并全",  //通知标题
                        createTime : "2010-07-12 12:12:12",         //通知消息
                        isRead     : true,                          //已读状态 0 未读 1已读
                        readTime   : "2010-07-12 13:12:12",         //阅读时间
                        icon       : "",                            //消息图标
                        content    : "内容",                     //内容
                        levelId    : "1" ,                          //消息级别（字典表定义）
                        levelLabel : "一般",                         //消息级别
                        classifyId : "1",                           //消息分类标识
                        classifyName:"电能质量",                     //消息分类名称
                        userId      : "用户ID",
                        url         : "",                           //消息地址
                        displayMode : "1",                          //显示方式
                        html        : "dfsdfsdfsdf<a >打开</a>"
                    }
                ],
            tasks  :
                [
                    {
                        nId        : 500359710482292737,            //通知ID
                        title      : "1百张被很再即二声色济况验志并全",  //通知标题
                        createTime : "2010-07-12 12:12:12",         //通知消息
                        isRead     : true,                          //已读状态 0 未读 1已读
                        readTime   : "2010-07-12 13:12:12",         //阅读时间
                        content    : "内容",                     //内容
                        icon       : "",                            //消息图标
                        levelId    : "1" ,                          //消息级别（字典表定义）
                        levelLabel : "一般",                         //消息级别
                        classifyId : "1",                           //消息分类标识
                        classifyName:"电能质量",                     //消息分类名称
                        userId      : "用户ID",
                        url         : "",                           //消息地址
                        displayMode : "1"                          //显示方式
                    },
                    {
                        nId        : 600359710482292737,            //通知ID
                        title      : "2百张被很再即二声色济况验志并全",  //通知标题
                        createTime : "2010-07-12 12:12:12",         //通知消息
                        isRead     : true,                          //已读状态 0 未读 1已读
                        readTime   : "2010-07-12 13:12:12",         //阅读时间
                        content    : "内容",                     //内容
                        icon       : "",                            //消息图标
                        levelId    : "1" ,                          //消息级别（字典表定义）
                        levelLabel : "一般",                         //消息级别
                        classifyId : "1",                           //消息分类标识
                        classifyName:"电能质量",                     //消息分类名称
                        userId      : "用户ID",
                        url         : "",                           //消息地址
                        displayMode : "1"                           //显示方式
                    }
                ]
        }
})();



