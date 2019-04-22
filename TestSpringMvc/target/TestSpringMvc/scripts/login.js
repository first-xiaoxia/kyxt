function login(){
	var name = $("#name").textbox("getValue");
	var password = $("#password").textbox("getValue");
	console.log(name+""+password);
	$.ajax({
        url:path+"/user/login",
        type:"post",
        data:{name:name,
			password:password
		},
        success:function(data){
        	if(data==1){
        		window.location.href=path+"/views/index.html";
        	}
        },error:function(){
        	console.log("aaa");
        }
	});
}

function reset(){
	$("#name").clear();
	$("#password").val("");
}
