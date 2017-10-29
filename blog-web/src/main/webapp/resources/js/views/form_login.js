layui.use('layer', function() {
		var layer = layui.layer;
})

$(function() {
	$("#username").blur(function() {
	});

})

function login() {
	var username = $("#username").val();
	var password = $("#password").val();
	var loginData = {
		'username' : username,
		'password' : password,
	};
	ajaxSend({url : '/login',data : loginData}, forward);
	return false;
}
function forward(options,data) {
	if (data.code == "0000") {
		window.location.href = "/forward";
	} else {
		layer.alert(data.msg, {icon : 5});
	}
}
function register() {
		layer.open({
			type : 2,
			title : '注册信息',
			skin : 'layui-layer-rim', // 加上边框
			shadeClose : false,
			shade : 0.8,
			anim : 3,// 载入动画
			area : [ '600px', '500px' ], // 宽高自定义设置
			content : '/register_content.html' // iframe的url
		});
}

function test1() {
	var username = $("#abc").val();

	var checkData = {
		'username' : username,
		'service_id' : 'isUsernameUniqueService',
	};
	$.ajax({
		type : 'POST',
		url : '/invoke',
		dataType : 'json',
		data : checkData,
		success : function(data) {
			console.log(data);
		},
		error : function(xhr, type) {

		}
	});
}
function test2() {
	var username = $("#abc1").val();

	var checkData = {
		'username' : username,
		'service_id' : 'isEmailUniqueService',
	};
	$.ajax({
		type : 'POST',
		url : '/invoke',
		dataType : 'json',
		data : checkData,
		success : function(data) {
			console.log(data);
		},
		error : function(xhr, type) {

		}
	});
}
function test3() {
	var username = $("#abc2").val();

	var checkData = {
		'appid' : "wxfd6b5b9b1bf1aacf",
		'redirect_uri' : '/weixinTest',
		'scope' : 'snsapi_login',
		'response_type' : 'code',
	};
	$.ajax({
		type : 'GET',
		url : 'https://open.weixin.qq.com/connect/qrconnect',
		dataType : 'json',
		data : checkData,
		success : function(data) {
			console.log(data);
		},
		error : function(xhr, type) {

		}
	});
}
