$(function(){
	$('#tab').datagrid({
  		url:path+'/xmsb/getKymxPageInfo',
  		rownumbers:true,//是否显示行号
   	 	striped:true,//是否显示斑马线效果
   	 	singleSelect:true,//只允许选择一行
		pagination:true,//是否显示分页工具栏
		border:true,//是否显示边框
		fit:true,//是否自适应父容器
		//fitColumns:true,//自动使列适应表格宽度以防止出现水平滚动
		scrollbarSize:0,//滚动条的宽度
		pageList:[10, 50, 100],//初始化页面大小选择列表
		pageSize:10,
		showFooter:true,//是否显示行脚
		loadMsg :"加载数据中...",//加载数据时显示的提示消息
		toolbar : '#tb',
	    columns:[[
			{field:'ck',checkbox:true},//复选框
			{field:'xmlsh',title:"项目流水号",width:250,align:'center'},
            {field:'xmmc',title:"项目名称",width:500,align:'center'},
            {field:'xmxz',title:"项目性质",width:80,align:'center',formatter:formatXmxz},
            {field:'fzr',title:"负责人",width:50,align:'center'},
			{field:'xkfl',title:"学科分类",width:100,align:'center'},
			{field:'kssj',title:"开始时间",width:200,align:'center',formatter:formatDateTime},
            {field:'jhwcsj',title:"计划完成时间",width:200,align:'center',formatter:formatDateTime},
            {field:'xmcyry',title:"项目参与人员",width:200,align:'center'},
            {field:'cjsj',title:"创建时间",width:200,align
                    :'center',formatter:formatDateTime}
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
	var xmmc = $("#xmmc").textbox("getValue").trim();
    var xmxz = $("#xmxz").textbox("getValue").trim();
    var starDate = $("#starDate").textbox("getValue").trim();
    var endDate = $("#endDate").textbox("getValue").trim();
	var paramDate = {
        xmmc:xmmc,
        xmxz:xmxz,
        starDate:starDate,
        endDate:endDate
	};
	return paramDate;
}

function getParmsadd() {
    var xmmc = $("#add_xmmc").textbox('getValue');
    var xmxz = $("#add_xmxz").textbox('getValue');
    var xmcyry = $("#add_xmcyry").textbox('getValue');
    var fzr = $("#add_fzr").textbox('getValue');
    var kssj = $("#add_kssj").textbox('getValue');
    var xkfl = $("#add_xkfl").textbox('getValue');
    var jhwcsj = $("#add_jhwcsj").textbox('getValue');
    var params = {
        xmmc:xmmc,
        xmxz:xmxz,
        xmcyry:xmcyry,
        fzr:fzr,
        kssj:kssj,
        xkfl:xkfl,
        jhwcsj:jhwcsj
    };
    return params;
}

function getParms2() {
    var yhmc = $("#f2yhmc").textbox('getValue');
    var yhxb = $("#f2yhxb").textbox('getValue');
    var userName = $("#f2userName").textbox('getValue');
    var password = $("#f2password").textbox('getValue');
    var jslb = $("#f2jslb").textbox('getValue');
    var sfzhm = $("#f2sfzhm").textbox('getValue');
    var userType = $("#f2userType").textbox('getValue');
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
        $("#fyhxb").combobox({
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

        $("#fjslb").combobox({
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

        $("#fuserType").combobox({
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
    $("#kyxm_add_form").form('reset');
    $("#add_xmxz").combobox({
        data:[{label:'1',type:"国家级"},{label:'2',type:"省级"},{label:'3',type:"省级以下"},{label:'4',type:"其他"}],
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
addSave = function () {
    console.log(getParmsadd());
	$.ajax({
		url:path+'/xmsb/add',
		method:'post',
		data:getParmsadd(),
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

function formatXmxz(value,row,index){
    if (value == undefined) {
        return "";
    }
    if (value == 1){
        return "国家级";
    }
    if(value == 2){
        return "省级";
    }
    if(value == 3){
        return "省级以下";
    }
    else{
        return "其他";
    }
}