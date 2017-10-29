function ajaxSend(options, callBackSuccess,failedCallBack) {
	options.type == "GET" ? options.type : "POST";
	$.ajax({
		type : options.type,
		url : options.url,
		dataType : 'json',
		data : options.data,
		success : function(data) {
			callBackSuccess(options,data);
		},
		error : function(json, textStatus) {
			common_resubmit_flag = false;
			if (failedCallBack) {
				failedCallBack(json, textStatus);
			} else {
				alert("tongxunyichang");
			}
		}
	});
}

function iframeCallSuccess(options,data) {
	
	if (data.code == "0000") {
		options.msg == null?data.msg:options.msg;
		layer.alert(options.msg, {
			icon : 6
		}, function(index) {
			layer.close(index);
			var parentIndex = parent.layer.getFrameIndex(window.name);
			parent.layer.close(parentIndex);
		});
		
	} else {
		layer.alert(data.msg, {
			icon : 5
		});
	}
}