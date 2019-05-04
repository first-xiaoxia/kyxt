$(function(){
	$('#tab').datagrid({
  		url:path+'/kycg/getKyjfPageInfo',
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
            {field:'cgmc',title:"成果名称",width:300,align:'center'},
            {field:'cgjb',title:"成果级别",width:80,align:'center'},
            {field:'cgfl',title:"成果分类",width:80,align:'center'},
			{field:'ckwz',title:"查看网站",width:150,align:'center'},
            {field:'cjr',title:"申请人",width:100,align:'center'},
            {field:'cjsj',title:"申请时间",width:200,align:'center',formatter:formatDateTime},
            {field:'shzt',title:"申请状态",width:100,align:'center',formatter:formatjfzt},
            {field:'spr',title:"审批人",width:100,align:'center'},
            {field:'shsj',title:"审批时间",width:200,align:'center',formatter:formatDateTime},
            {field:'shly',title:"审批理由",width:200,align:'center'},
            {field:'cglsh',title:"成果流水号",width:250,align:'center'},
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
    var cgmc = $("#cgmc").textbox("getValue").trim();
    var shzt = $("#shzt").textbox("getValue").trim();
    var starDate = $("#starDate").textbox("getValue").trim();
    var endDate = $("#endDate").textbox("getValue").trim();
    var paramDate = {
        cgmc:cgmc,
        shzt:shzt,
        starDate:starDate,
        endDate:endDate
    };
    return paramDate;
}

function getParmsadd() {
    var xmmc = $("#add_xmmc").textbox('getValue');
    var jfhj = $("#add_jfhj").textbox('getValue');
    var fyzl = $("#add_fyzl").textbox('getValue');
    var fyyt = $("#add_fyyt").textbox('getValue')
    var params = {
        xmmc:xmmc,
        jfhj:jfhj,
        fyzl:fyzl,
        fyyt:fyyt
    };
    return params;
}

function getParmsEdit() {
    var cglsh = $("#edit_cglsh").textbox('getValue');
    var cgmc = $("#edit_cgmc").textbox('getValue');
    var cgjb = $("#edit_cgjb").textbox('getValue');
    var cgfl = $("#edit_cgfl").textbox('getValue');
    var ckwz = $("#edit_ckwz").textbox('getValue');
    var params = {
        cglsh:cglsh,
        cgmc:cgmc,
        cgjb:cgjb,
        cgfl:cgfl,
        cgfl:cgfl,
        ckwz:ckwz
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
    $("#cgmc").textbox("clear");
    $("#shzt").combobox().select("--请选择--");
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
            url:path+'/kycg/deleteByKey',
            method:'get',
            data:{
                cglsh:row1.cglsh
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
        if (rows.shzt != '0') {
            $.messager.show({
                title:'提示消息',
                msg:'该项目已审核，禁止修改',
                timeout:5000,
                showType:'slide'
            });
            return;
        }

        $("#wid").window("open");
        $('#kycg_edit_form').form('load',row);
        $('#tab1').datagrid({
            url:path+'/file/getMyFilePageInfo',
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
            queryParams: { cglsh: row.cglsh }, //往后台传参数用的。
            //toolbar : '#tb',
            columns:[[
                {field:'wjmc',title:"文件名称",width:100,align:'center'},
                {field:'wjlx',title:"文件类型",width:100,align:'center',formatter:formatWjlx},
                {field:'wjlsh',title:'操作',width:200,align:'center',
                    formatter:function(value,rec,index){
                    console.log(index+","+rec+","+value);
                        var dwon = '<a href="#" mce_href="#" onclick="downfj(\''+ value +'\')">下载</a> ';
                        var d = '<a href="#" mce_href="#" onclick="delfj(\''+ value +'\')">删除</a> ';
                        return dwon+d;
                    }
                }
            ]],
            onLoadSuccess:function(data){
                console.log(data);
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
};

/**
 * 新增
 */
doadd = function () {
    $("#wid1").window('open');
    $("#kycg_add_form").form('reset');
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
    $("#kycg_add_form").form('submit', {
        type:"post",
        url:path+"/kycg/add",
        success:function(data){
            console.log(data);
            $("#wid1").window('close');
            $("#tab").datagrid('reload');
            $.messager.show({
                title:'提示消息',
                msg:"成果上传成功",
                timeout:5000,
                showType:'slide'
            });
        }
    });
};

editsave = function () {
    $("#file1").filebox("clear");
    $("#kycg_edit_form").form('submit', {
        type:"post",
        url:path+"/kycg/update",
        success:function(data){
            console.log(data);
            $("#wid").window('close');
            $("#tab").datagrid('reload');
            $.messager.show({
                title:'提示消息',
                msg:"科研成果更新成果",
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

downfj = function(value){
    window.location.href=path+"/file/downFile?wjlsh="+value;
}
delfj = function(value){
    $.ajax({
        url:path+'/file/deleteByKey',
        method:'get',
        data:{
            wjlsh:value,
        },
        success:function (data) {
            console.log(data);
            $("#tab1").datagrid('reload');
            $.messager.show({
                title:'提示消息',
                msg:data.message,
                timeout:5000,
                showType:'slide'
            });
        }
    });
}

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

function formatWjlx(value,row,index){
    if (value == undefined) {
        return "";
    }
    if (value == 0){
        return "图片";
    }
    if(value == 1){
        return "音频";
    }
    if(value == 2){
        return "视频";
    }
    else{
        return "文件";
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

