$(function(){
	$('#tab').datagrid({
  		url:path+'/organiseUnit/getInfo',
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
            {field:'name',title:"机构名称",width:500},
            {field:'dwbh',title:"单位编号",width:500},
            {field:'dwlx',title:"单位类型",width:500},
            {field:'yjxk',title:"一级学科",width:500},
			{field:'memo',title:"描述",width:500},
			{field:'fzr',title:"负责人",width:500},
            {field:'lxr',title:"联系人",width:500},
            {field:'lxdh',title:"联系电话",width:500}
	    ]],
	    onLoadSuccess:function(data){
	    	console.log(data);
	    }
	});

    initForm();

    function myformatter(date) {
        var y = date.getFullYear();
        var m = date.getMonth() + 1;
        var d = date.getDate();
        return y + '-' + (m < 10 ? ('0' + m) : m) + '-' + (d < 10 ? ('0' + d) : d);
    }
    function myparser(s) {
        if (!s) return new Date();
        var ss = (s.split('-'));
        var y = parseInt(ss[0], 10);
        var m = parseInt(ss[1], 10);
        var d = parseInt(ss[2], 10);
        if (!isNaN(y) && !isNaN(m) && !isNaN(d)) {
            return new Date(y, m - 1, d);
        } else {
            return new Date();
        }
    }
});




function initForm() {
   /* Win.edit.find("#btn-open-submit").click(function () {
        save();
    });*/
    $("#btn-open-close").click(function () {
        $.messager.confirm('警告', '你确定要关闭窗口吗?', function (r) {
            if (r) {
                Win.add.dialog('close');
            }
        });
    });

    $("#add-btn-open-submit").click(function () {
        console.log(getParms1());
        $.ajax({
            url:path+'/organiseUnit/addOrganiseUnit',
            method:'post',
            data:getParms1(),
            success:function (data) {
                console.log(data);
                Win.add.dialog('close');
                $("#tab").datagrid('reload');
                $.messager.show({
                    title:'提示消息',
                    msg:data.message,
                    timeout:5000,
                    showType:'slide'
                });
            }
        });
    });
}


function getParms1() {
    debugger;
    var name = $("#name").val();
    var dwbh = $("#dwbh").val();
    var dwlx = $("input[name='dwlx']:checked").val();
    var memo = $("#memo").val();
    var fzr = $("#fzr").val();
    var lxr = $("#lxr").val();
    var yjxk = $('#yjxk').combobox('getValue');
    var lxdh = $("#lxdh").val();
    var cz = $("#cz").val();
    var dz = $("#dz").val();
    var yb = $("#yb").val();
    var wz = $("#wz").val();
    var dzyx = $("#dzyx").val();
    var createTime = $('#createTime').textbox('getValue');
    var params = {
        name:name,
        dwbh:dwbh,
        dwlx:dwlx,
        memo:memo,
        fzr:fzr,
        lxr:lxr,
        yjxk:yjxk,
        lxdh:lxdh,
        cz:cz,
        dz:dz,
        yb:yb,
        wz:wz,
        dzyx:dzyx,
        createTime:createTime
    };
    return params;
}

//弹窗增加
function add() {
    Form.add.form('clear');
    Win.add.dialog('open');
}