

/** @View */
var curIndex = 0;
function showMessage(text) {
	dorado.MessageBox.alert(text);
}


function changeImg()
{
	var arr=new Array();
	arr[0]="images/backgrounds/1.jpg";
	arr[1]="images/backgrounds/2.jpg";
	arr[2]="images/backgrounds/3.jpg";
	arr[3]="images/backgrounds/4.jpg";
	/*arr[0]="images/backgrounds/login-bg1.jpg";
	arr[1]="images/backgrounds/login-bg1.jpg";
	arr[2]="images/backgrounds/login-bg1.jpg";
	arr[3]="images/backgrounds/login-bg1.jpg";*/
    var obj=document.getElementById("obj");
    if (curIndex == arr.length-1) 
    {
        curIndex=0;
    }
    else
    {
        curIndex+=1;
    }
    obj.src=arr[curIndex];
}

/*// @Bind view.onReady
!function(ajaxactionLogin) {
	alert(1);
	var element = document.getElementById("button");
	element.onclick = function(){
		alert(2);
		//ajaxactionLogin.execute();
	};
};


// @Bind #ajaxactionLogin.beforeExecute
!function(self, arg, autoformLogin) {
	var entity = autoformLogin.get("entity");
	var username = entity.get("username");
	var password = entity.get("password");
	if (username && password) {
		self.set("parameter", entity);
	} else {
		showMessage("用户名和密码不能为空");
		arg.processDefault = false;
	}
};

// @Bind #ajaxactionLogin.onSuccess
!function(self, arg) {
	var result = self.get("returnValue");
	if (result.result) {
		location.href = result.url;
	} else {
		dorado.MessageBox.alert(result.errormsg, {
			title : "提示",
			icon : "WARNING"
		});
	}
};

// @Bind #password.onKeyDown
!function(self, arg, ajaxactionLogin) {
	var keyCode = arg.keyCode;
	if (13 == keyCode) {
		ajaxactionLogin.execute();
	}
};

// @Bind #buttonCancel.onClick
!function(self, arg, autoformLogin) {
	autoformLogin.set("entity", {});
};

// @Bind #buttonRegister.onClick
!function(self, arg, dialog, updateActionSave, autoformUser, usersPassword1) {

	var entity = autoformUser.get("entity");
	var usersId = entity.get("usersId");
	var usersName = entity.get("usersName");
	var usersPassword = entity.get("usersPassword");
	var usersPassword2 = usersPassword1.get("value");
	var userPhonenumber = entity.get("usersPhonenum");
	//
	if (usersPassword == usersPassword2) {
		if (usersName && usersPassword && userPhonenumber) {
			dorado.MessageBox.confirm("确认注册信息？", function() {
				updateActionSave.execute();
				dialog.hide();
			});
		} else {
			dorado.MessageBox.alert("请输入相关信息！");
			arg.processDefault = false;
		}
	} else {
		showMessage("两次密码输入不一致，请确认一致！");
	}
};

// @Bind #buttonCancel1.onClick
!function(self, arg, dsUsers, dialog) {
	dsUsers.get("data:#").cancel();
	dialog.hide();
};*/







/**************************************************************************************
 * 修改以后
 * *********************************************************************************/
 
//* @Bind view.onReady
!function(ajaxactionRegisterUser,updateActionSave,dsUsers) {
	
	
	// 验证码点击
	var captchaImg = document.getElementById("captchaImg");
	captchaImg.onclick = function() {
		this.src="generate.captcha.action?width=200&height=60&random="+Math.random();
	};
	
	
	// 登录按钮点击
	var loginButton = document.getElementById("loginbutton");
	loginButton.onclick = function(){
		ajaxactionLogin.execute();
	};
	
	// 回车键登录
	var passwordInput = document.getElementById("captcha_");
	passwordInput.onkeydown = function(e){
		if (13 == e.keyCode) {
			document.getElementById("loginForm").submit();
		}
	};
	
	// 注册按钮点击
	var registerButton = document.getElementById("registerbutton");
	registerButton.onclick = function(e){
		
		//询问框
		layer.confirm('确认注册？', {
		  btn: ['是的','取消'],
		  anim: 4
		  //按钮
		}, function(){
		
			var entity = {};						
			// 获取页面的输入值
			var username = document.getElementById("usernamesignup").value;
			var password = document.getElementById("passwordsignup").value;
			var usersPassword2 = document.getElementById("passwordsignup_confirm").value;
			var mobile = document.getElementById("usersPhonenum").value;
			var cname = document.getElementById("cname").value;
			var male = 1;
			var radio = document.getElementsByName("sex");
			
			// 判断输入是否为空
			if(username != null && password != null && mobile != null && cname != null && male != null &&
					username != "" && password != "" && mobile != "" && cname != "" && male != "" ) {
				
			}else {
				layer.msg('请输入相关信息！', {
					    time: 1000, //20s后自动关闭
					    btn: ['知道了'],
					    anim: 4
					  });
				e.processDefault = false;
				return;
			}
			// 密码长度校验
			if (typeof password !== 'undefined') {
				if (password.length <= 5) {  
					layer.msg('密码长度至少为6位', {
					    time: 5000, //20s后自动关闭
					    btn: ['知道了'],
					    anim: 4
					  });  
					return;
				}
			}
			
			
			// 密码校验
			if (password != usersPassword2) {
				layer.msg('两次密码输入不一致，请确认一致！', {
				    time: 5000, //20s后自动关闭
				    btn: ['知道了'],
				    anim: 4
				  });
				throw new dorado.Exception("两次输入的口令不一致！");
			}
			
			// 手机号校验
			var myreg=/^[1][3,4,5,7,8][0-9]{9}$/;  
			if (!myreg.test(mobile)) {  
				layer.msg('手机号格式有误,请输入正确的手机号！', {
				    time: 5000, //20s后自动关闭
				    btn: ['知道了'],
				    anim: 4
				  });  
				return;
			} 
			
			// 姓名校验
			if (typeof cname !== 'undefined') {
				//alert(cname.length);
				if (cname.length <= 2) {  
					layer.msg('请输入正确的姓名！', {
					    time: 5000, //20s后自动关闭
					    btn: ['知道了'],
					    anim: 4
					  });  
					return;
				}
			}
			 
			
			
			// 性别获取处理
			for(var i = 0;i<radio.length;i++)  
	        {  
	            if(radio[i].checked==true)  
	            {
	            	male = radio[i].value;  
	            	break;
	            }  
	        }  
			
			entity.username = username;
			entity.password = password;
			entity.mobile = mobile;
			entity.cname = cname;
			entity.male = male;				
			ajaxactionRegisterUser.set("parameter",entity).execute();
			
			
			// 页面输入值为entity的各属性值
			/*entity.set("username",username);
			entity.set("password",password);
			entity.set("mobile",mobile);
			entity.set("cname",cname);
			entity.set("male",male);*/
			
		
		}, function(){
		  layer.msg('已取消', {icon: 2});
		});
	};
	
	// 背景图片切换3秒切换
	setInterval(changeImg,5000);	
};


//@Bind #ajaxactionLogin.beforeExecute
/*!function(self, arg) {
	var username = document.getElementById("username").value;
	var password = document.getElementById("password").value;
	if (username && password) {
		self.set("parameter", $map({
			"username":username,
			"password":password,
		}));
	} else {
		//showMessage("用户名和密码不能为空");
		layer.alert('用户名和密码不能为空', {
			  skin: 'layui-layer-molv' //样式类名
			  ,closeBtn: 0
			  ,anim: 4 //动画类型
			});
		arg.processDefault = false;
	}
};*/

/*// @Bind #ajaxactionLogin.onSuccess
!function(self, arg) {
	var result = self.get("returnValue");
	if (result.result) {
		location.href = result.url;
	} else {
		dorado.MessageBox.alert(result.errormsg, {
			title : "提示",
			icon : "WARNING"
		});
		layer.alert(result.errormsg, {
			  skin: 'layui-layer-molv' //样式类名
			  ,closeBtn: 0
			  ,anim: 4 //动画类型
			});
	}
};
*/
// @Bind #ajaxactionRegisterUser.onSuccess
!function(self,arg) {
	var result = self.get("returnValue");
	if(result == "S_OK") {
		layer.msg('注册成功', {icon: 1,anim: 4});
	}else {
		layer.msg('用户名已存在，注册失败', {icon: 1,anim: 4});
	}
	
};





