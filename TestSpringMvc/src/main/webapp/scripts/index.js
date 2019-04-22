$(function(){
	$(".easyui-tree").tree({
		url:path+"/menu/getMenu.json",
		onClick: function(node){
			if(node.leaf == false){
				addTabs(node.text,node.url); // 在用户点击的时候提示
			}
			else {
				$(this).tree(node.state === 'closed' ? 'expand' : 'collapse', node.target);
			}
			
		}
	});
});


/*打开选项板*/
function addTabs(title, url){
	if ($('#tt').tabs('exists', title)){
		$('#tt').tabs('select', title);
		var tab = $('#tt').tabs('getSelected');
		var content = '<iframe scrolling="auto" frameborder="0" src="'+path+"/views/"+url+'" style="width:100%;height:99%;"></iframe>';
		$('#tt').tabs('update', {
			tab: tab,
			options: {
				title: title,
				content: content,
				closable: true,
				selected:true
			}
		});
	} else {
		var content = '<iframe scrolling="auto" frameborder="0" src="'+path+"/views/"+url+'" style="width:100%;height:99%;"></iframe>';
		$('#tt').tabs('add',{
			title:title,
			content:content,
			closable:true
		});
	}
}