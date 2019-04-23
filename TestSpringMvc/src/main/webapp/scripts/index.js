$(function(){

	$(".easyui-tree").tree({
		url:path+"/menu/getMenu.json",
        lines:true,
		onClick: function(node){
			if(node.leaf == false){
				addTabs(node.text,node.url); // 在用户点击的时候提示
			}
			else {
				$(this).tree(node.state === 'closed' ? 'expand' : 'collapse', node.target);
			}
			
		}
	});
	$.ajax({
		url:path+'/user/getUser',
		method:'post',
		data:{},
		success:function (data) {
			console.log(data)
			$('#myusername').textbox('setValue',data.userName);
		}
	});
});




loginOut = function () {
	$.ajax({
		url:path+'/user/loginOut',
		method:'post',
		data:{},
		success:function (data) {
			window.location.href=path+"/views/login.html";
		}
	});
}