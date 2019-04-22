$(function(){
	$('#tab').datagrid({
  		url:path+'/user/getInfo',
  		rownumbers:true,//是否显示行号
   	 	striped:true,//是否显示斑马线效果
   	 	singleSelect:true,//只允许选择一行
		pagination:true,//是否显示分页工具栏
		border:true,//是否显示边框
		fit:true,//是否自适应父容器
		fitColumns:true,//自动使列适应表格宽度以防止出现水平滚动
		scrollbarSize:0,//滚动条的宽度
		pageList:[50, 100, 300],//初始化页面大小选择列表
		pageSize:50,
		showFooter:true,//是否显示行脚
		loadMsg :"加载数据中...",//加载数据时显示的提示消息
		toolbar : '#tb',
	    columns:[[
			{field:'ck',checkbox:true},//复选框
			{field:'id',title:"编号",width:500},
            {field:'yhmc',title:"用户名称",width:500},
            {field:'yhxb',title:"性别",width:500},
            {field:'jslb',title:"教师类别",width:500},
			{field:'userName',title:"账号",width:500},
			{field:'password',title:"密码",width:500},
            {field:'sfzhm',title:"证件号码",width:500},
            {field:'userType',title:"用户类型",width:500,formatter:formatUserType}
	    ]],
	    onLoadSuccess:function(data){
	    	console.log(data);
	    }
	});
});

/**
 * 获得参数
 */
function getParms() {
	var userName = $("#userName").textbox("getValue").trim();
    var sfzhm = $("#sfzhm").textbox("getValue").trim();
    var jslb = $("#jslb").textbox("getValue").trim();
	var paramDate = {
		userName:userName,
        sfzhm:sfzhm,
        jslb:jslb
	};
	return paramDate;
}

function getParms1() {
    var id = $("#fid").textbox('getValue');
    var yhmc = $("#fyhmc").textbox('getValue');
    var yhxb = $("#fyhxb").textbox('getValue');
    var username = $("#fuserName").textbox('getValue');
    var password = $("#fpassword").textbox('getValue');
    var jslb = $("#fjslb").textbox('getValue');
    var sfzhm = $("#fsfzhm").textbox('getValue');
    var userType = $("#fuserType").textbox('getValue');
    var params = {
        id:id,
        yhmc:yhmc,
        username:username,
        yhxb:yhxb,
        jslb:jslb,
        sfzhm:sfzhm,
        password:password,
        userType:userType
    };
    return params;
}

function getParms2() {
    var id = $("#f2id").textbox('getValue');
    var yhmc = $("#f2yhmc").textbox('getValue');
    var yhxb = $("#f2yhxb").textbox('getValue');
    var userName = $("#f2userName").textbox('getValue');
    var password = $("#f2password").textbox('getValue');
    var jslb = $("#f2jslb").textbox('getValue');
    var sfzhm = $("#f2sfzhm").textbox('getValue');
    var userType = $("#f2userType").textbox('getValue');
    var params = {
        id:id,
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

/**
 * 查询
 */
function doSearch() {
	console.log(getParms());
	$("#tab").datagrid("load",getParms())
}
/**
 * 重置
 */
doClear = function () {
    $("#userName").textbox("clear");
    $("#sfzhm").textbox("clear");
    $("#jslb").combobox().select("--请选择--");
}
/**
 * 删除
 */
doDelete = function () {
    var row1 = $("#tab").datagrid("getSelected");
    console.log(row1.id)
    $.ajax({
        url:path+'/user/delUser',
        method:'post',
        data:{
            id:row1.id
        },
        success:function (data) {
            console.log(data);
            $("#wid").window('close');
            $("#tab").datagrid('reload');
            $.messager.show({
                title:'提示消息',
                msg:data.message,
                timeout:5000,
                showType:'slide'
            });
        }
    });
}

    /**
 * 编辑
 */
var rows = null;
doedit = function () {
    var row = $("#tab").datagrid("getSelected");
    rows = row;
    if(row != null){
        $("#wid").window("open");
        $('#form1').form('load',row);
    }
    else{
        $.messager.show({
            title:'提示消息',
            msg:'请选择一条需要编辑的数据',
            timeout:5000,
            showType:'slide'
        });
	}
};

/**
 * 新增
 */
doadd = function () {
	$("#wid1").window('open');
	$("#f2userType").combobox({
		data:[{label:1,type:"1"},{label:2,type:"2"}],
        valueField:"label",
        textField:"type",
        editable:false,
        panelHeight:"auto",
	})
	$("#form2").form('reset');
}

/**
 * 返回
 */
doback = function () {
    $("#wid").window("close");
    $("#wid1").window("close");
};

/**
 * 保存
 */
dosave = function () {

    console.log(getParms1());
	$.ajax({
		url:path+'/user/editUser',
		method:'post',
		data:getParms1(),
		success:function (data) {
			console.log(data);
			$("#wid").window('close');
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

dosave1 = function () {

    console.log(getParms2());
    $.ajax({
        url:path+'/user/addUser',
        method:'post',
        data:getParms2(),
        success:function (data) {
            console.log(data);
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

/*--------------正则表达式-----------------*/
$.extend($.fn.validatebox.defaults.rules, {
    fage:{//可分配数量
        validator: function(value){
            var reg=/^[0-9]*[1-9][0-9]*$/;
            if(reg.test(value)){
                return true;
            }else{
                return false;
            }
        },
        message:'此项只可填正整数'
    }
});

function formatUserType(value,row,index){
    if (value == undefined) {
        return "";
    }
    if (value == 1){
        return "超级管理员";
    }else{
        return "普通用户";
    }
}