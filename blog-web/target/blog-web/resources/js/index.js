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
		'user_id':1,
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