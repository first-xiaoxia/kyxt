$(function(){
	$.ajax({
		url:path+'/user/getUser',
		method:'post',
		data:{},
		success:function (data) {
			console.log(data)
			$('#f2id').textbox('setValue',data.id);
			$('#f2yhmc').textbox('setValue',data.yhmc);
			var yhxb = data.yhxb;
			$("#f2yhxb").combobox({
				data:[{label:'男',type:"男"},{label:'女',type:"女"}],
				valueField:"label",
				textField:"type",
				editable:false,
				panelHeight:"auto",
				onLoadSuccess:function(data) {
					console.log("onLoadSuccess")
					//默认选中第一个
					var array=$(this).combobox("getData");
					console.log(array)
					for(var item in array){
						console.log(array[item].label);
						if(array[item].label==yhxb){
							$(this).combobox('select',array[item].label);
							break;
						}
					}
				}

			});
			$('#f2userName').textbox('setValue',data.userName);
			$('#f2password').textbox('setValue',data.password);
			var jslb = data.jslb;
			console.log("jslb="+jslb);
			$("#f2jslb").combobox({
				data:[{label:'教师岗',type:"教师岗"},{label:'管理岗',type:"管理岗"}],
				valueField:"label",
				textField:"type",
				editable:false,
				panelHeight:"auto",
				onLoadSuccess:function(data) {
					//默认选中第一个
					var array=$(this).combobox("getData");
					for(var item in array){
						console.log(array[item].label);
						if(array[item].label==jslb){
							$(this).combobox('select',array[item].label);
							break;
						}
					}
				}

			});
			$('#f2sfzhm').textbox('setValue',data.sfzhm);
		}
	});
});

basedoedit = function () {
	console.log("basedoedit")
	$("#f2yhmc").textbox('enable');
	$("#f2yhxb").textbox('enable');
	$("#f2password").textbox('enable');
	$("#f2sfzhm").textbox('enable');
}

function getParms2() {
	var id = $("#f2id").textbox('getValue');
	var yhmc = $("#f2yhmc").textbox('getValue');
	var yhxb = $("#f2yhxb").textbox('getValue');
	var userName = $("#f2userName").textbox('getValue');
	var password = $("#f2password").textbox('getValue');
	var jslb = $("#f2jslb").textbox('getValue');
	var sfzhm = $("#f2sfzhm").textbox('getValue');
	var params = {
		id:id,
		yhmc:yhmc,
		userName:userName,
		yhxb:yhxb,
		jslb:jslb,
		sfzhm:sfzhm,
		password:password
	};
	return params;
}

baseSave = function () {
	//初始化下拉选框
	console.log(getParms2());
	$.ajax({
		url:path+'/user/editUser',
		method:'post',
		data:getParms2(),
		success:function (data) {
			console.log(data);
			$("#f2yhmc").textbox('disable');
			$("#f2yhxb").textbox('disable');
			$("#f2password").textbox('disable');
			$("#f2sfzhm").textbox('disable');
			$("#wid1").window('close');
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
