$(function(){
	var node = $("#menu").tree('getChildren');
	console.log(node)
	//$('#tt').tree('select', node.target);
	$('#form1').form('reset');
	$("#f2yhxb").combobox({
		data:[{label:'男',type:"男"},{label:'女',type:"女"}],
		valueField:"label",
		textField:"type",
		editable:false,
		panelHeight:"auto",
		onLoadSuccess:function(data) {
			console.log("111")
			var array=$(this).combobox("getData");
			$(this).combobox('select',array[0].label);
		}

	});

	$("#f2jslb").combobox({
		data:[{label:'教师岗',type:"教师岗"},{label:'管理岗',type:"管理岗"}],
		valueField:"label",
		textField:"type",
		editable:false,
		panelHeight:"auto",
		onLoadSuccess:function(data) {
			console.log("222")
			var array=$(this).combobox("getData");
			$(this).combobox('select',array[0].label);

		}
	});

	$("#f2userType").combobox({
		data:[{label:'1',type:"超级管理员"},{label:'2',type:"普通用户"}],
		valueField:"label",
		textField:"type",
		editable:false,
		panelHeight:"auto",
		onLoadSuccess:function(data) {
			console.log("333")
			var array=$(this).combobox("getData");
			$(this).combobox('select',array[0].label);

		}
	});

});

function getParms2() {
	var yhmc = $("#f2yhmc").textbox('getValue');
	var yhxb = $("#f2yhxb").textbox('getValue');
	var userName = $("#f2userName").textbox('getValue');
	var password = $("#f2password").textbox('getValue');
	var jslb = $("#f2jslb").combobox('getValue');
	var sfzhm = $("#f2sfzhm").textbox('getValue');
	var userType = $("#f2userType").combobox('getValue');
	var params = {
		yhmc:yhmc,
		userName:userName,
		yhxb:yhxb,
		jslb:jslb,
		sfzhm:sfzhm,
		password:password,
		userType:userType
	};
	return params;
}

usereditSave = function () {
	//初始化下拉选框
	console.log(getParms2());
	$.ajax({
		url:path+'/user/addUser',
		method:'post',
		data:getParms2(),
		success:function (data) {
			console.log(data);
			$("#f2yhmc").textbox('disable');
			$("#f2yhxb").textbox('disable');
			$("#f2password").textbox('disable');
			$("#f2sfzhm").textbox('disable');
			$("#f2jslb").textbox('disable');
			$("#f2userName").textbox('disable');
			$("#f2userType").textbox('disable');
			$("#tab").datagrid('reload');
			$.messager.show({
				title:'提示消息',
				msg:data.message,
				timeout:5000,
				showType:'slide'
			});
		}
	});
};
