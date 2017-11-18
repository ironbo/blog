layui.use('layer', function() {
		var layer = layui.layer;
})

$(function() {
	$("#username").blur(function() {
	});

})

function login() {
	$("#form").attr("action","login");
	$("#form").attr("type","POST");
	$("#form").submit();
	
}
//function login() {
//	var username = $("#username").val();
//	var password = $("#password").val();
//	var loginData = {
//		'username' : username,
//		'password' : password,
//		"type" : "POST"
//	};
//	ajaxSend({url : 'login',data : loginData}, forward);
//	return false;
//}
//function forward(options,data) {
//	if (data.code == "0000") {
//		window.location.href = "forward";
//	} else {
//		layer.alert(data.msg, {icon : 5});
//	}
//}
function register() {
		layer.open({
			type : 2,
			title : '注册信息',
			skin : 'layui-layer-rim', // 加上边框
			shadeClose : false,
			shade : 0.8,
			anim : 3,// 载入动画
			area : [ '600px', '500px' ], // 宽高自定义设置
			content : 'register_content.html' // iframe的url
		});
}

