/**
 * date:2020/4/13
 * author: 杨不易
 * description: 前后端分离 toen存储 ,页面验证登陆,部门权限
 */
var api = 'http://192.168.137.1:8879/';
var baseUrl = 'http://yangbuyi.top/';
var loginUrl = 'http://localhost:63342/Landlor/landlord/user/login.html';
var indexUrl = 'http://localhost:63342/Landlor/landlord/';
// 下次再发ajax请求把token带到后台 
// 获取前端存入进去的token
var token = $.cookie('TOKEN');
//设置全局ajax前置拦截  每一次ajax都把token带过去确保登陆成功凭证
$.ajaxSetup({
	headers: {
		'TOKEN': token //每次ajax请求时把token带过去
	}
});



//如果访问登陆页面这外的页面并且还没有登陆成功之后写入cookie的token就转到登陆页面
// if(token==undefined){
// 	if(window.location!=loginUrl){
// 		window.top.location=loginUrl;
// 	}
// }else{
// 	if(window.location!=loginUrl){
// 		$.ajax({
// 				url:api+"login/checkLogin",
// 				async:true,
// 				type:'post',
// 				dataType:'json',
// 				success:function(res){
// 					if(res.code==-1){
// 						window.top.location=loginUrl;
// 					}
// 				},
// 				error:function(res){
// 					window.top.location=loginUrl;
// 				}
// 		});
// 	}
// }



//如果访问登陆页面之外的页面
//并且还没有登陆成功
//则写入cookie的token就转到登陆页面  
//把token带到了后台
//后端的TokenWebSessionManager进行获取token  判断该ajax请求是否有token
//也就是说没有登陆成功也就没有token 访问以外的页面则跳转到登陆页面
// if (token == undefined) {
// 	// 没有token
// 	if (window.location != loginUrl) {
// 		// 获取顶部窗体 改变顶级窗体的url 实现跳转 到登陆
// 		window.top.location = loginUrl;
// 	}
// }
// // else {
// // 	// 有token
// // 	// 进行判断当前url 是否 等于  loginUrl
// // 	if (window.location == loginUrl) {
// // 		// 直接跳转到主页 不想让你访问登陆页面
// // 		window.top.location = indexUrl;
// // 	}
// // }
// else {
// 	// 验证是否登陆成功
// 	if (window.location != loginUrl) {
// 		// 登陆验证
// 		$.ajax({
// 			url: api + "login/checkLogin",
// 			async: true,
// 			type: 'post',
// 			dataType: 'json',
// 			success: function(res) {
// 				// 未登录过则跳转到 登陆页面
// 				if (res.code == -1) {
// 					window.top.location = loginUrl;
// 				}
// 			},
// 			error: function(res) {
// 				window.top.location = loginUrl;
// 			}
// 		});
// 	}
// }


/*
var pers=localStorage.getItem("permissions");
// console.log(pers);
var usertype=localStorage.getItem("usertype");
if(usertype==1){
	if(pers!=null){
		var permissions=pers.split(",");
		//部门权限开始
		if(permissions.indexOf("dept:add")<0){
			$(".btn_add").hide();
		}
		if(permissions.indexOf("dept:update")<0){
			$(".btn_update").hide();
		}
		if(permissions.indexOf("dept:delete")<0){
			$(".btn_delete").hide();
		}
		//部门权限结束
	}else{
		$(".btn_add").hide();
		$(".btn_update").hide();
		$(".btn_delete").hide();
		$(".btn_dispatch").hide();
		$(".btn_reset").hide();
	}
}

 */

//给页面显示登陆用户名
// var username=localStorage.getItem("username");
// $(".login_name").html(username);





