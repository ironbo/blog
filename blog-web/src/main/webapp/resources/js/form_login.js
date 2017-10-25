function login() {
	var username = $("#username").val();
	var password = $("#password").val();
	var checkData = {
		'username' : username,
		'password' : password,
	};
	$.ajax({
		type : 'POST',
		url : 'login',
		dataType : 'json',
		data : checkData,
		success : function(data) {
			console.log(data);
			if(data.code == 0000){				
				window.location.href = "/forward";
			}
		},
		error : function(xhr, type) {

		}
	});

	return false;
}
function register() {
	layer.open({
		  type: 2,
		  skin: 'layui-layer-rim', // 加上边框
		  shadeClose: false,
		  shade: 0.8,
		  area: ['800px', '600px'], // 宽高自定义设置
		  content: '/resources/index.html' // iframe的url
		});
// var username = $("#username").val();
// var password = $("#password").val();
// var email = $("#email").val();
// var nick = $("#nick").val();
// var checkData = {
// 'username' : username,
// 'password' : password,
// 'email' : email,
// 'nick' : nick,
// 'service_id':'registerService',
// };
// $.ajax({
// type : 'POST',
// url : '/register',
// dataType : 'json',
// data : checkData,
// success : function(data) {
// console.log(data);
// },
// error : function(xhr, type) {
//			
// }
// });
}
function test1() {
	var username = $("#abc").val();
	
	var checkData = {
			'username' : username,
			'service_id':'isUsernameUniqueService',
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
			'service_id':'isEmailUniqueService',
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
			'redirect_uri':'/weixinTest',
			'scope':'snsapi_login',
			'response_type':'code',
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
