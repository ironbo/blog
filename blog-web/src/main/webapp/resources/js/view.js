var menu;
$(function() {
	$.ajax({
		type : 'POST',
		url : 'testAjax',
		dataType : 'json',
		success : function(data) {
			menu =  data.roles[0].menu;
			menu = menu.sort();
			for(var i=0;i<menu.length;i++){
				var child = "<a href='#'id="+menu[i].url+" onclick='handle(this);' >"+menu[i].name+"</a><br>";
				$("#nav").append($(child));		
			}
		},
		error : function(xhr, type) {
		}
	});
});
function handle(tag){
	$.ajax({
		type : 'GET',
		url : "handle"+tag.id,
		dataType : 'text',
		success : function(data) {
			console.log(data);
			$("#iframe").attr("src",data);
		},
		error : function(xhr, type) {
		}
	});
	return false;
}
