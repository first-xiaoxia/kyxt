var path = "/TestSpringMvc";
//格式化日期字段
function formatDateTime(value,row,index){
    if (value == undefined) {
        return "";
    }
    var date = new Date(value);
    var getMonth = (date.getMonth()+1)<10?("0"+(date.getMonth()+1)):(date.getMonth()+1);
    var getDate = date.getDate()<10?("0"+date.getDate()):date.getDate();
    var getHours = date.getHours()<10?("0"+date.getHours()):date.getHours();
    var getMinutes = date.getMinutes()<10?("0"+date.getMinutes()):date.getMinutes();
    var getSeconds = date.getSeconds()<10?("0"+date.getSeconds()):date.getSeconds();
    return date.getFullYear()+"-"+getMonth+"-"+getDate+" "+getHours+":"+getMinutes+":"+getSeconds;
}

//日期格式转换
function myformatter(date){
    var y = date.getFullYear();
    var m = date.getMonth()+1;
    var d = date.getDate();
    return y+'-'+(m<10?('0'+m):m)+'-'+(d<10?('0'+d):d);
}
function myparser(s){
    if (!s) return new Date();
    var ss = (s.split('-'));
    var y = parseInt(ss[0],10);
    var m = parseInt(ss[1],10);
    var d = parseInt(ss[2],10);
    if (!isNaN(y) && !isNaN(m) && !isNaN(d)){
        return new Date(y,m-1,d);
    } else {
        return new Date();
    }
}

//使combobox下拉框兼容火狐浏览器
$(function(){
    if($.fn.combobox){
        $.fn.combobox.defaults.inputEvents.keyup=$.fn.combobox.defaults.inputEvents.keydown;
        $.fn.combobox.defaults.inputEvents.keydown=function(){};
    }
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