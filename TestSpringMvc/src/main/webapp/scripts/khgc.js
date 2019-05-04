var nowxmlsh = "";
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
            {field:'xmmc',title:"项目名称",width:300,align:'center'},
            {field:'xmxz',title:"项目性质",width:80,align:'center',formatter:formatXmxz},
            {field:'fzr',title:"负责人",width:50,align:'center'},
            {field:'xkfl',title:"学科分类",width:100,align:'center'},
            {field:'kssj',title:"开始时间",width:200,align:'center',formatter:formatDateTime},
            {field:'jhwcsj',title:"计划完成时间",width:200,align:'center',formatter:formatDateTime},
            {field:'xmcyry',title:"项目参与人员",width:200,align:'center'},
            {field:'cjsj',title:"创建时间",width:200,align:'center',formatter:formatDateTime},
            {field:'xmzt',title:"项目状态",width:60,align:'center',formatter:formatXmzt},
            {field:'khr',title:"考核人",width:100,align:'center'},
            {field:'khsj',title:"终止时间",width:200,align:'center',formatter:formatDateTime},
            {field:'bz',title:"备注",width:200,align:'center'},
            {field:'xmlsh',title:'操作',width:200,align:'center',
                formatter:function(value,rec,index){
                    console.log(index+","+rec+","+value);
                    nowxmlsh = value;
                    var d = '<a href="#" mce_href="#" onclick="addkycg(\''+ value +'\')">项目考核</a> ';
                    return d;
                }
            }
        ]],
        onLoadSuccess:function(data){
            console.log(data);
        }
    });
});


addkycg = function (value) {
    $("#widcg").window('open');
    $("#xmcggl_add_form").form('reset');
    $("#xmcggl").combobox({
        url:path+"/kycg/getCgListByCjr?xmlsh"+value,
        queryParams: { xmlsh:value },
        valueField:"cglsh",
        textField:"cgmc",
        editable:false,
        panelHeight:"auto",
        onLoadSuccess:function(data) {
            var array=$(this).combobox("getData");
            $(this).combobox('select',array[0].cglsh);
        }

    });
    $('#tab1').datagrid({
        url:path+'/xmcggl/getKyjfPageInfo',
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
        queryParams: { xmlsh:value }, //往后台传参数用的。
        //toolbar : '#tb',
        columns:[[
            {field:'cgmc',title:"成果名称",width:100,align:'center'},
            {field:'cgjb',title:"成果级别",width:50,align:'center'},
            {field:'cgfl',title:"成果分类",width:50,align:'center'},
            {field:'bh',title:'操作',width:100,align:'center',
                formatter:function(value,rec,index){
                    console.log(index+","+rec+","+value);
                    var d = '<a href="#" mce_href="#" onclick="delcglb(\''+ value +'\')">删除</a> ';
                    return d;
                }
            }
        ]],
        onLoadSuccess:function(data){
            console.log(data);
        }
    });
};

function addcg() {
    var xmcggl = $("#xmcggl").textbox("getValue").trim();
    console.log(xmcggl);
    console.log(nowxmlsh);
    $.ajax({
        url:path+'/xmcggl/add',
        method:'get',
        data:{
            xmlsh:nowxmlsh,
            cglsh:xmcggl
        },
        success:function (data) {
            console.log(data);
            $("#tab1").datagrid('reload');
            $.messager.show({
                title:'提示消息',
                msg:"删除数据成功",
                timeout:5000,
                showType:'slide'
            });
        }
    });
}

/**
 * 获得参数
 */
function getParms() {
    var xmmc = $("#xmmc").textbox("getValue").trim();
    var xmxz = $("#xmxz").textbox("getValue").trim();
    var xmzt = $("#xmzt").textbox("getValue").trim();
    var starDate = $("#starDate").textbox("getValue").trim();
    var endDate = $("#endDate").textbox("getValue").trim();
    var paramDate = {
        xmmc:xmmc,
        xmxz:xmxz,
        xmzt:xmzt,
        starDate:starDate,
        endDate:endDate
    };
    return paramDate;
}

function getParmsadd() {
    var xmmc = $("#add_xmmc").textbox('getValue');
    var xmxz = $("#add_xmxz").textbox('getValue');
    var xmcyry = $("#add_xmcyry").textbox('getValue');
    var kssj = $("#add_kssj").textbox('getValue');
    var xkfl = $("#add_xkfl").textbox('getValue');
    var jhwcsj = $("#add_jhwcsj").textbox('getValue');
    var params = {
        xmmc:xmmc,
        xmxz:xmxz,
        xmcyry:xmcyry,
        kssj:kssj,
        xkfl:xkfl,
        jhwcsj:jhwcsj
    };
    return params;
}

function getParmsEdit() {
    var xmlsh = $("#edit_xmlsh").textbox('getValue');
    var xmmc = $("#edit_xmmc").textbox('getValue');
    var xmxz = $("#edit_xmxz").textbox('getValue');
    var xmcyry = $("#edit_xmcyry").textbox('getValue');
    var fzr = $("#edit_fzr").textbox('getValue');
    var kssj = $("#edit_kssj").textbox('getValue');
    var xkfl = $("#edit_xkfl").textbox('getValue');
    var jhwcsj = $("#edit_jhwcsj").textbox('getValue');
    var params = {
        xmlsh:xmlsh,
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
    $("#xmmc").textbox("clear");
    $("#xmzt").textbox("clear");
    $("#starDate").textbox("clear");
    $("#endDate").textbox("clear");
    $("#xmxz").combobox().select("--请选择--");
}
/**
 * 删除
 */
doDelete = function () {
    var row1 = $("#tab").datagrid("getSelected");
    console.log(row1.id)
    $.ajax({
        url:path+'/xmsb/deleteByKey',
        method:'get',
        data:{
            xmlsh:row1.xmlsh
        },
        success:function (data) {
            console.log(data);
            $("#wid").window('close');
            $("#tab").datagrid('reload');
            $.messager.show({
                title:'提示消息',
                msg:"删除数据成功",
                timeout:5000,
                showType:'slide'
            });
        }
    });
};

function delcglb(value) {
    console.log(value)
    $.ajax({
        url:path+'/xmcggl/deleteByKey',
        method:'get',
        data:{
            bh:value
        },
        success:function (data) {
            console.log(data);
            $("#tab1").datagrid('reload');
            $.messager.show({
                title:'提示消息',
                msg:"删除数据成功",
                timeout:5000,
                showType:'slide'
            });
        }
    });
};

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
    $("#widcg").window("close");

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

editsave = function () {

    console.log(getParmsEdit());
    $.ajax({
        url:path+'/xmsb/update',
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

function formatXmzt(value,row,index){
    if (value == undefined) {
        return "";
    }
    if (value == 1){
        return "已立项";
    }
    if(value == 2){
        return "已终止";
    }
}