$(function(){
	$('#tab').datagrid({
  		url:path+'/khbz/getKyjfPageInfo',
  		rownumbers:true,//是否显示行号
   	 	striped:true,//是否显示斑马线效果
   	 	singleSelect:true,//只允许选择一行
		pagination:true,//是否显示分页工具栏
		border:true,//是否显示边框
		fit:true,//是否自适应父容器
		fitColumns:true,//自动使列适应表格宽度以防止出现水平滚动
		scrollbarSize:0,//滚动条的宽度
		pageList:[10, 50, 100],//初始化页面大小选择列表
		pageSize:10,
		showFooter:true,//是否显示行脚
		loadMsg :"加载数据中...",//加载数据时显示的提示消息
		toolbar : '#tb',
	    columns:[[
			{field:'ck',checkbox:true},//复选框
            {field:'bzmc',title:"标准名称",width:300,align:'center'},
            {field:'fz',title:"标准分值",width:80,align:'center'},
            {field:'dw',title:"单位",width:80,align:'center'},
			{field:'cjr',title:"创建人",width:100,align:'center'},
            {field:'cjsj',title:"创建时间",width:200,align:'center',formatter:formatDateTime},
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
	var bzmc = $("#bzmc").textbox("getValue").trim();
    var cjr = $("#cjr").textbox("getValue").trim();
    var starDate = $("#starDate").textbox("getValue").trim();
    var endDate = $("#endDate").textbox("getValue").trim();
	var paramDate = {
        bzmc:bzmc,
        cjr:cjr,
        starDate:starDate,
        endDate:endDate
	};
	return paramDate;
}

function getParmsadd() {
    var bzmc = $("#add_bzmc").textbox('getValue');
    var fz = $("#add_fz").textbox('getValue');
    var dw = $("#add_dw").textbox('getValue');
    var params = {
        bzmc:bzmc,
        fz:fz,
        dw:dw
    };
    return params;
}

function getParmsEdit() {
    var bzlsh = $("#edit_bzlsh").textbox('getValue');
    var bzmc = $("#edit_bzmc").textbox('getValue');
    var dw = $("#edit_fz").textbox('getValue');
    var fz = $("#edit_dw").textbox('getValue');
    var params = {
        bzlsh:bzlsh,
        bzmc:bzmc,
        dw:dw,
        fz:fz
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
function doClear () {
    console.log("重置")
    $("#bzmc").textbox("clear");
    $("#cjr").textbox("clear");
    $("#starDate").textbox("clear");
    $("#endDate").textbox("clear");
}
/**
 * 删除
 */
doDelete = function () {
    var row1 = $("#tab").datagrid("getSelected");
    console.log(row1)
    if (row1 != null) {
        $.ajax({
            url:path+'/khbz/deleteByKey',
            method:'get',
            data:{
                bzlsh:row1.bzlsh
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
    else{
        $.messager.show({
            title:'提示消息',
            msg:'请选择一条需要编辑的数据',
            timeout:5000,
            showType:'slide'
        });
    }
}

    /**
 * 编辑
 */
var rows = null;
function doedit () {
    var row = $("#tab").datagrid("getSelected");
    rows = row;
    if(row != null){
        console.log("xmzt"+rows.xmzt);
        if (rows.xmzt == '2') {
            $.messager.show({
                title:'提示消息',
                msg:'该项目已终止，禁止修改',
                timeout:5000,
                showType:'slide'
            });
            return;
        }

        $("#wid").window("open");
        $("#edit_xmxz").combobox({
            data:[{label:'1',type:"国家级"},{label:'2',type:"省级"},{label:'3',type:"省级以下"},{label:'4',type:"其他"}],
            valueField:"label",
            textField:"type",
            editable:false,
            panelHeight:"auto",
            onLoadSuccess:function(data) {
                console.log(rows);
                var array=$(this).combobox("getData");
                for(var i=0;i<array.length;i++){
                    if(rows.xmxz == array[i].label){
                        console.log(rows.xmxz);
                        console.log(array[i].label);
                        $(this).combobox('select',array[i].label);
                        break;
                    }
                }

            }

        });
        $('#kyxm_edit_form').form('load',row);
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
    $("#kyjf_add_form").form('reset');
    $("#add_xmmc").combobox({
        url:path+"/xmsb/getXmshList",
        valueField:"xmmc",
        textField:"xmmc",
        editable:false,
        panelHeight:"auto",
        onLoadSuccess:function(data) {
            console.log("111")
            var array=$(this).combobox("getData");
            $(this).combobox('select',array[0].xmmc);
        }

    });
}

doAddBZ = function () {
    var row = $("#tab").datagrid("getSelected");
    rows = row;
    if(row != null){
        if (rows.xmzt == '2') {
            $.messager.show({
                title:'提示消息',
                msg:'该项目已终止了，无需终止',
                timeout:5000,
                showType:'slide'
            });
            return;
        }
        $("#bz_dialog").window('open');
    }
    else{
        $.messager.show({
            title:'提示消息',
            msg:'请选择一条需要编辑的数据',
            timeout:5000,
            showType:'slide'
        });
    }
}

/**
 * 返回
 */
doback = function () {
    $("#wid").window("close");
    $("#wid1").window("close");
    $("#bz_dialog").window("close");
};

/**
 * 保存
 */
addSave = function () {
    console.log(getParmsadd());
	$.ajax({
		url:path+'/khbz/add',
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

editsave = function () {

    console.log(getParmsEdit());
    $.ajax({
        url:path+'/khbz/update',
        method:'post',
        data:getParmsEdit(),
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

bzSave = function () {
    var bz = $("#bz").textbox('getValue');
    console.log(bz+rows.id);
    $.ajax({
        url:path+'/xmsb/update',
        method:'post',
        data:{
            xmlsh:rows.xmlsh,
            bz:bz
        },
        success:function (data) {
            console.log(data);
            $("#bz_dialog").window('close');
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

function formatjfzt(value,row,index){
    if (value == undefined) {
        return "";
    }
    if (value == 0){
        return "待审批";
    }
    if(value == 1){
        return "已同意";
    }
    if(value == 2){
        return "拒绝";
    }
}

$("#add_jfhj").keydown(function(){
    if(!(event.keyCode==46)&&!(event.keyCode==8)&&!(event.keyCode==37)&&!		(event.keyCode==39))
        if(!((event.keyCode>=48&&event.keyCode<=57)||(event.keyCode>=96&&event.keyCode<=105)))
            event.returnValue=false;
});