layui.use([ 'form', 'upload' ],
	function() {
		var form = layui.form
		, layer = layui.layer
		, upload = layui.upload;

	// 自定义验证规则
	form.verify({
		username : function(value) {
			if (value.length < 1) {
				return '用户名用户名<(￣3￣)> ';
			}
		},
		password : [ /(.+){6,18}$/, '密码位数不对哦<(￣3￣)>' ],
		verifyPassword : function(value) {
			if ($("#password").val() != value) {
				return '似乎密码不一致<(￣3￣)> ';
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
		var registerDate = data.field;
		registerDate.service_id = 'registerService', console.log(registerDate);
		$.ajax({
			type : 'POST',
			url : '/register',
			dataType : 'json',
			data : registerDate,
			success : function(data) {
				if (data.code == "0000") {
					layer.msg(data.msg, {
						icon: 1,
						time: 1000 //2秒关闭（如果不配置，默认是3秒）
					}); 
					var index = parent.layer.getFrameIndex(window.name);
					parent.layer.close(index);
				}else{
					layer.msg(data.msg, {icon: 6}); 
				}
			},
			error : function(json, textStatus) {
				common_resubmit_flag = false;
				logger.error('send ajax return error.');
				if (failedCallBack) {
					failedCallBack(json, textStatus);
				} else {
					alertMsg("通讯异常");
				}
			}
		});
		return false;
	});
	$("#password").blur(function(){
		alert("a");
	});
});

function test() {
	var content = $("#content").val();
	var pic_path = $("#pic_path").val();
	var checkData = {
		'content' : content,
		'pic_path' : pic_path,
		'service_id' : 'essaySaveService',
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
function test1() {
	var checkData = {
		'service_id' : 'essayGetService',
		'offset' : 10,
		'limit' : 10,
		'user_id' : 1,
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