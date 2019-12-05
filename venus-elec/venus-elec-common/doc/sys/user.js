/**
 * 后台JSON通用返回结构
 * @type {{code: number, data: number, success: boolean, message: string}}
 */
ajaxReponse = {
    version: 1,
    requestId: "bc44f7c4-86ba-4965-94ad-074ec0ed80a8",
    time: "2018-09-08 12:12:12",
    code: 200,   //返回状态码 200请求正常
    success: true,  //操作成功
    message: "成功", //返回消息
    data: [] | {} | String | Object | null,  //返回数据     具体内容参考对应的业务模块
    dataExt: [] | {} | String | Object | null,  //返回扩展数据  具体内容参考对应的业务模块(保留)
}

/**
 *  1.1 查询用户列表
 * 【请求URL】/sys/user/findUser
 * 【参数方式】GET|POST
 * 【请求参数】
 *  1.userName     | 可选参数 | 用户名  | ()
 */
(function () {
    ajaxReponseData =
        [
            {
                token: "zhang_san123",  //用户token
                userId: "1",            //用户id
                userIds: "1,2",          //批量删除用到,传递多个用户id，用‘,’隔开
                userName: "zhang_san",  //用户名
                userPassword: "234",     //密码
                userNickname: "幸福的",     //昵称
                url: "www.baidu.com",              //地址
                userStatus: "1",        //用户状态
                userAvatar: "sdfsdf3sfsf34",       //用户头像
                userEmail: "290827@qq.com",        //用户邮箱
                userPhone: "18021543605",        //用户手机
                orgId: "123",             //组织id
                partId: "01233",            //部门id
                loginErrorCount: 0,     //登陆错误次数
                loginErrorTime: "2019-07-01 12:23:34",   //用户登陆错误时间
                createTime: "2019-07-01 12:23:34",       //用户建立时间
                loginTime: "2019-07-01 12:23:34",        //上次登录时间
                expire: "2019-07-01 12:23:34",           //过期时间
                logoutTime: "2019-07-01 12:23:34",       //登出时间
                roles:
                    [
                        {
                            roleId: "1", //角色id
                            sysId: "1",  //系统平台标志
                            roleNo: "sys_admin",  //角色编码
                            roleName: "系统管理员", //角色名称
                            roleLeavl: "10",//角色等级
                            roleDesc: null,//角色描述
                            roleRemark: null,//角色备注
                            roleStatus: "1"//角色状态
                        },
                        {
                            roleId: "1", //角色id
                            sysId: "1",  //系统平台标志
                            roleNo: "test",  //角色编码
                            roleName: "普通用户", //角色名称
                            roleLeavl: "10",//角色等级
                            roleDesc: null,//角色描述
                            roleRemark: null,//角色备注
                            roleStatus: "1"//角色状态
                        }
                    ],
                accesses: null,         //权限集合
                menus: null             //菜单集合
            },
            {
                token: "lisi",  //用户token
                userId: "1",            //用户id
                userIds: "1,2",          //批量删除用到,传递多个用户id，用‘,’隔开
                userName: "lisi",  //用户名
                userPassword: "234",     //密码
                userNickname: "幸福的",     //昵称
                url: "www.baidu.com",              //地址
                userStatus: "1",        //用户状态
                userAvatar: "sdfsdf3sfsf34",       //用户头像
                userEmail: "290827@qq.com",        //用户邮箱
                userPhone: "18021543605",        //用户手机
                orgId: "123",             //组织id
                partId: "01233",            //部门id
                loginErrorCount: 0,     //登陆错误次数
                loginErrorTime: "2019-07-01 12:23:34",   //用户登陆错误时间
                createTime: "2019-07-01 12:23:34",       //用户建立时间
                loginTime: "2019-07-01 12:23:34",        //上次登录时间
                expire: "2019-07-01 12:23:34",           //过期时间
                logoutTime: "2019-07-01 12:23:34",       //登出时间
                roles:
                    [
                        {
                            roleId: "1", //角色id
                            sysId: "1",  //系统平台标志
                            roleNo: "sys_admin",  //角色编码
                            roleName: "系统管理员", //角色名称
                            roleLeavl: "10",//角色等级
                            roleDesc: null,//角色描述
                            roleRemark: null,//角色备注
                            roleStatus: "1"//角色状态
                        }
                    ],
                accesses: null,         //权限集合
                menus: null             //菜单集合
            }
        ]
})();