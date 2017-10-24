$(function() {
	$.ajax({
		type : 'POST',
		url : "getUsers",
		dataType : 'json',
		success : function(data) {
			console.log(data);
			console.log(data.length);
			for(var i=0;i<data.length;i++){
				var child = "<tr><td>"+data[i].name+"</td><td>"+data[i].email+"</td><td>未处理</td><td>操作</td></tr> ";
				$("#head").after($(child));		
			}
		},
		error : function(xhr, type) {
		}
	});
});