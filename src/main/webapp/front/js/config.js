
var projectName = '基于B/S的高考志愿咨询平台的设计与实现';
/**
 * 轮播图配置
 */
var swiper = {
	// 设定轮播容器宽度，支持像素和百分比
	width: '100%',
	height: '400px',
	// hover（悬停显示）
	// always（始终显示）
	// none（始终不显示）
	arrow: 'none',
	// default（左右切换）
	// updown（上下切换）
	// fade（渐隐渐显切换）
	anim: 'default',
	// 自动切换的时间间隔
	// 默认3000
	interval: 2000,
	// 指示器位置
	// inside（容器内部）
	// outside（容器外部）
	// none（不显示）
	indicator: 'outside'
}

/**
 * 个人中心菜单
 */
var centerMenu = [{
	name: '个人中心',
	url: '../' + localStorage.getItem('userTable') + '/center.jsp'
}, 
{
	name: '我的收藏',
	url: '../storeup/list.jsp?storeupType=1'
},
]


var indexNav = [

{
	name: '高校信息',
	url: './pages/gaoxiaoxinxi/list.jsp'
}, 
{
	name: '招生简章',
	url: './pages/zhaoshengjianzhang/list.jsp'
}, 
{
	name: '专业简讯',
	url: './pages/zhuanyejianxun/list.jsp'
}, 
{
	name: '录取信息',
	url: './pages/luquxinxi/list.jsp'
}, 

{
	name: '公告信息',
	url: './pages/news/list.jsp'
},
]

var adminurl =  "http://localhost:8080/jspm7v4wr/index.jsp";

var cartFlag = false

var chatFlag = false


chatFlag = true


var menu = [{"backMenu":[{"child":[{"appFrontIcon":"cuIcon-vipcard","buttons":["新增","查看","修改","删除"],"menu":"用户","menuJump":"列表","tableName":"yonghu"}],"menu":"用户管理"},{"child":[{"appFrontIcon":"cuIcon-pic","buttons":["新增","查看","修改","删除","院校类型统计","查看评论","首页总数","首页统计","简章","专业","录取"],"menu":"高校信息","menuJump":"列表","tableName":"gaoxiaoxinxi"}],"menu":"高校信息管理"},{"child":[{"appFrontIcon":"cuIcon-circle","buttons":["新增","查看","修改","删除"],"menu":"院校类型","menuJump":"列表","tableName":"yuanxiaoleixing"}],"menu":"院校类型管理"},{"child":[{"appFrontIcon":"cuIcon-time","buttons":["查看","修改","删除","查看评论"],"menu":"招生简章","menuJump":"列表","tableName":"zhaoshengjianzhang"}],"menu":"招生简章管理"},{"child":[{"appFrontIcon":"cuIcon-link","buttons":["查看评论","删除","修改","查看"],"menu":"专业简讯","menuJump":"列表","tableName":"zhuanyejianxun"}],"menu":"专业简讯管理"},{"child":[{"appFrontIcon":"cuIcon-pic","buttons":["查看","修改","删除","高校录取人数统计","高校分数统计","查看评论","首页总数","首页统计"],"menu":"录取信息","menuJump":"列表","tableName":"luquxinxi"}],"menu":"录取信息管理"},{"child":[{"appFrontIcon":"cuIcon-camera","buttons":["新增","查看","修改","删除"],"menu":"专业名称","menuJump":"列表","tableName":"zhuanyemingcheng"}],"menu":"专业名称管理"},{"child":[{"appFrontIcon":"cuIcon-full","buttons":["新增","查看","修改","删除"],"menu":"录取分数","menuJump":"列表","tableName":"luqufenshu"}],"menu":"录取分数管理"},{"child":[{"appFrontIcon":"cuIcon-paint","buttons":["查看","修改"],"menu":"系统简介","tableName":"systemintro"},{"appFrontIcon":"cuIcon-circle","buttons":["查看","修改"],"menu":"轮播图管理","tableName":"config"},{"appFrontIcon":"cuIcon-news","buttons":["新增","查看","修改","删除"],"menu":"公告信息","tableName":"news"},{"appFrontIcon":"cuIcon-service","buttons":["新增","查看","修改","删除"],"menu":"智能客服","tableName":"chat"},{"appFrontIcon":"cuIcon-album","buttons":["查看","修改"],"menu":"关于我们","tableName":"aboutus"}],"menu":"系统管理"}],"frontMenu":[{"child":[{"appFrontIcon":"cuIcon-skin","buttons":["查看","查看评论"],"menu":"高校信息列表","menuJump":"列表","tableName":"gaoxiaoxinxi"}],"menu":"高校信息模块"},{"child":[{"appFrontIcon":"cuIcon-goodsnew","buttons":["查看","查看评论"],"menu":"招生简章列表","menuJump":"列表","tableName":"zhaoshengjianzhang"}],"menu":"招生简章模块"},{"child":[{"appFrontIcon":"cuIcon-brand","buttons":["查看评论","查看"],"menu":"专业简讯列表","menuJump":"列表","tableName":"zhuanyejianxun"}],"menu":"专业简讯模块"},{"child":[{"appFrontIcon":"cuIcon-cardboard","buttons":["查看","查看评论"],"menu":"录取信息列表","menuJump":"列表","tableName":"luquxinxi"}],"menu":"录取信息模块"}],"hasBackLogin":"是","hasBackRegister":"否","hasFrontLogin":"否","hasFrontRegister":"否","roleName":"管理员","tableName":"users"},{"backMenu":[],"frontMenu":[{"child":[{"appFrontIcon":"cuIcon-skin","buttons":["查看","查看评论"],"menu":"高校信息列表","menuJump":"列表","tableName":"gaoxiaoxinxi"}],"menu":"高校信息模块"},{"child":[{"appFrontIcon":"cuIcon-goodsnew","buttons":["查看","查看评论"],"menu":"招生简章列表","menuJump":"列表","tableName":"zhaoshengjianzhang"}],"menu":"招生简章模块"},{"child":[{"appFrontIcon":"cuIcon-brand","buttons":["查看评论","查看"],"menu":"专业简讯列表","menuJump":"列表","tableName":"zhuanyejianxun"}],"menu":"专业简讯模块"},{"child":[{"appFrontIcon":"cuIcon-cardboard","buttons":["查看","查看评论"],"menu":"录取信息列表","menuJump":"列表","tableName":"luquxinxi"}],"menu":"录取信息模块"}],"hasBackLogin":"否","hasBackRegister":"否","hasFrontLogin":"是","hasFrontRegister":"是","roleName":"用户","tableName":"yonghu"}]


var isAuth = function (tableName,key) {
    let role = localStorage.getItem("userTable");
    let menus = menu;
    for(let i=0;i<menus.length;i++){
        if(menus[i].tableName==role){
            for(let j=0;j<menus[i].backMenu.length;j++){
                for(let k=0;k<menus[i].backMenu[j].child.length;k++){
                    if(tableName==menus[i].backMenu[j].child[k].tableName){
                        let buttons = menus[i].backMenu[j].child[k].buttons.join(',');
                        return buttons.indexOf(key) !== -1 || false
                    }
                }
            }
        }
    }
    return false;
}

var isFrontAuth = function (tableName,key) {
    let role = localStorage.getItem("userTable");
    let menus = menu;
    for(let i=0;i<menus.length;i++){
        if(menus[i].tableName==role){
            for(let j=0;j<menus[i].frontMenu.length;j++){
                for(let k=0;k<menus[i].frontMenu[j].child.length;k++){
                    if(tableName==menus[i].frontMenu[j].child[k].tableName){
                        let buttons = menus[i].frontMenu[j].child[k].buttons.join(',');
                        return buttons.indexOf(key) !== -1 || false
                    }
                }
            }
        }
    }
    return false;
}
