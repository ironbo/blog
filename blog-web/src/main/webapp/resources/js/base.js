function ajaxSend(options, callBackSuccess) {
	options.type == "GET" ? options.type : "POST";
	$.ajax({
		type : options.type,
		url : options.url,
		dataType : 'json',
		data : options.data,
		success : function(data) {
			callBackSuccess(data,options);
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
}

function callSuccess(data) {
	if (data.code == "0000") {
		layer.alert(data.msg, {
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