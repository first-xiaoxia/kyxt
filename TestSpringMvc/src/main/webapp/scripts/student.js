$(function(){
	$('#tab').datagrid({
  		url:path+'/student/getStudent',
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
			{field:'name',title:"姓名",width:500},
            {field:'studentId',title:"学号",width:500},
			{field:'sclass',title:"班级",width:500},
			{field:'age',title:"年龄",width:500},
            {field:'height',title:"身高",width:500},
            {field:'weight',title:"体重",width:500},
            {field:'creater',title:"创建人",width:500},
            {field:'createTime',title:"创建时间",width:500,formatter:formatDateTime},
            {field:'updater',title:"修改人",width:500},
            {field:'updateTime',title:"修改时间",width:500,formatter:formatDateTime},
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
	var starDate = $("#starDate").textbox("getValue").trim();
    var endDate = $("#endDate").textbox("getValue").trim();
    var name = $("#name").textbox("getValue").trim();
    var studentId = $("#studentId").textbox("getValue").trim();
    var sclass = $("#sclass").textbox("getValue").trim();
	var params = {
		starDate:starDate,
        endDate:endDate,
        name:name,
        studentId:studentId,
        sclass:sclass
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
    $("#starDate").textbox("clear");
    $("#endDate").textbox("clear");
	$("#name").textbox("clear");
    $("#studentId").textbox("clear");
    $("#sclass").textbox("clear");
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
    console.log(1);
    var id = $("#fid").textbox('getValue');
    var name = $("#fname").textbox('getValue');
    var studentId = $("#fstudentId").textbox('getValue');
    var sclass = $("#fsclass").textbox('getValue');
    var age = $("#fage").textbox('getValue');
    var height = $("#fheight").textbox('getValue');
    var weight = $("#fweight").textbox('getValue');
    console.log(id+name+studentId+sclass+age+height+weight);
    var params = {
    	id:id,
        name:name,
        studentId:studentId,
        sclass:sclass,
		age:age,
        height:height,
        weight:weight
	};
    console.log(params);
	$.ajax({
		url:path+'/student/editStudent',
		method:'post',
		data:params,
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

/**
 * 新增保存
 */
dosave1 = function () {
    var name = $("#f2name").textbox('getValue');
    var studentId = $("#f2studentId").textbox('getValue');
    var sclass = $("#f2sclass").textbox('getValue');
    var age = $("#f2age").textbox('getValue');
    var height = $("#f2height").textbox('getValue');
    var weight = $("#f2weight").textbox('getValue');
    var params = {
        name:name,
        studentId:studentId,
        sclass:sclass,
        age:age,
        height:height,
        weight:weight
    };
    $.ajax({
        url:path+'/student/addStudent',
        method:'post',
        data:params,
        success:function (data) {
            console.log("ssss"+data);
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