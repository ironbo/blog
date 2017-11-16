layui.use([ 'form', 'upload' ],
	function() {
		var form = layui.form
		, layer = layui.layer
		, upload = layui.upload;

	// 自定义验证规则
	form.verify({
		username : function(value) {
			if ($("#usernameCheck").html().indexOf("red") > 1 ||value.length < 1) {
				return '用户名用户名<(￣3￣)> ';
			}
		},
		password : [ /(.+){6,18}$/, '密码位数不对哦<(￣3￣)>' ],
		verifyPassword : function(value) {
			if ($("#password").val() != value) {
				return '似乎密码不一致<(￣3￣)> ';
			}
		},
		myEmail : function(value) {
			if ($("#emailCheck").html().indexOf("red") > 1 ||value.indexOf('@') < 0||value.length < 1) {
				return '邮箱邮箱<(￣3￣)> ';
			}
		},
		nick : function(value) {
			if ($("#nickCheck").html().indexOf("red") > 1 ||value.length < 1) {
				return '昵称昵称<(￣3￣)> ';
			}
		}
	});
	// 普通图片上传
//	var uploadInst = upload
//			.render({
//				elem : '#avatarUrl',
//				url : '/uploadImg',
//				before : function(obj) {
//					// 预读本地文件示例，不支持ie8
//					obj.preview(function(index, file, result) {
////										$('#picture').attr('width', "100"); 
//						$('#picture').attr('height', "100"); 
//						$('#picture').attr('src', result); // 图片链接（base64）
//					});
//				},
//				done : function(res) {
//					// 如果上传失败
//					if (res.code > 0) {
//						return layer.msg('上传失败');
//					}
//					
//				},
//				error : function() {
//					// 演示失败状态，并实现重传
//					var demoText = $('#demoText');
//					demoText
//							.html('<span style="color: #FF5722;">上传失败</span> <a class="layui-btn layui-btn-mini demo-reload">重试</a>');
//					demoText.find('.demo-reload').on('click',
//							function() {
//								uploadInst.upload();
//							});
//				}
//			});
	// 监听提交
	form.on('submit(submit)', function(data) {
		var registerData = data.field;
		registerData.service_id = 'registerService';
		ajaxSend({url:'register',data:registerData,msg:"注册成功O(∩_∩)O"},iframeCallSuccess);	
		return false;
	});

});
$(function() {
	$("#reset").click(function(){
		$(".greenText").remove();
		$(".redText").remove();
	});
	$("#username").blur(function() {
		var username = $("#username").val();
		if (username == "") {
			layer.msg('用户名不能为空哦~', {
				  icon: 5,
				  time: 2000 //2秒关闭（如果不配置，默认是3秒）
				});
			return;
		}
		var checkData = {
				"service_id":"isUsernameUniqueService",
				"username":username
		};
		ajaxSend({url:'check',data:checkData,type:'GET',id:'username',name:'用户名'},checkReturn);
	});
	$("#email").blur(function() {
		var email = $("#email").val();
		if (email == "") {
			layer.msg('邮箱不能为空哦~', {
				  icon: 5,
				  time: 2000 //2秒关闭（如果不配置，默认是3秒）
				});
			return;
		}
		var checkData = {
				"service_id":"isEmailUniqueService",
				"email":email
		};
		ajaxSend({url:'check',data:checkData,type:'GET',id:"email",name:'邮箱'},checkReturn);
	});
	$("#nick").blur(function() {
		var nick = $("#nick").val();
		if (nick == "") {
			layer.msg('昵称不能为空哦~', {
				  icon: 5,
				  time: 2000 //2秒关闭（如果不配置，默认是3秒）
				});
			return;
		}
		var checkData = {
				"service_id":"isNickUniqueService",
				"nick":nick
		};
		ajaxSend({url:'check',data:checkData,type:'GET',id:"nick",name:'昵称'},checkReturn);
	});
})
function checkReturn(options,data){
	if (data.data != "true") {
		$("#"+options.id+"Check").html("<span class='redText'>该"+options.name+"已被注册</span>");
		$(".redText").css("color","red");
	}else{
		$("#"+options.id+"Check").html("<span class='greenText'>"+options.name+"可用哦~</span>");
		$(".greenText").css("color","green");		
	}
}
