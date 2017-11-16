layui.use('element', function() {
	var element = layui.element;
});

$(function() {
	var data = {
		"service_id" : "userInfoService"
	}
	ajaxSend({
		url : 'invoke',
		data : data,
		type : 'GET'
	}, getInfo);
});

function getInfo(options, data) {
	$("#username").text(data.data.nick);
	$(".layui-logo").text(data.data.nick + "的小屋");
}
