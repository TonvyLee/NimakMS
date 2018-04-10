
/** @View */
function showMessage(text) {
	dorado.MessageBox.alert(text);
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
 
// @Bind view.onReady
!function(ajaxactionLogin,updateActionSave,dsUsers) {
	
	
	
	// 登录按钮点击
	var loginButton = document.getElementById("loginbutton");
	loginButton.onclick = function(){
		ajaxactionLogin.execute();
	};
	
	// 回车键登录
	var passwordInput = document.getElementById("password");
	passwordInput.onkeydown = function(e){
		if (13 == e.keyCode) {
			ajaxactionLogin.execute();
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
		
			var dataSet = dsUsers.get("data");
			var i=0;
			dataSet.each(function(){
				i++;
			});
			var entity = dsUsers.insert();
			

			// 获取页面的输入值
			var usersName = document.getElementById("usernamesignup").value;
			var usersPassword = document.getElementById("passwordsignup").value;
			var usersPassword2 = document.getElementById("passwordsignup_confirm").value;
			var userPhonenumber = document.getElementById("usersPhonenum").value;
			var content = document.getElementById("content").value;
			var userId = i+1;
			var usersAuthority = "visitor";
			
			// 页面输入值为entity的各属性值
			entity.set("usersId",userId);
			entity.set("usersAuthority",usersAuthority);
			entity.set("usersName",usersName);
			entity.set("usersPassword",usersPassword);
			entity.set("usersPhonenum",userPhonenumber);
			entity.set("content",content);
			entity.set("usersAuthoritydeclare","");
			
		
			if (usersPassword == usersPassword2) {
				if (usersName && usersPassword && userPhonenumber) {
						updateActionSave.execute();
						layer.msg('注册成功', {icon: 1,anim: 4});
				} else {
					//dorado.MessageBox.alert("请输入相关信息！");
					layer.msg('请输入相关信息！', {
						    time: 1000, //20s后自动关闭
						    btn: ['知道了'],
						    anim: 4
						  });
					e.processDefault = false;
				}
			} else {
				//showMessage("两次密码输入不一致，请确认一致！");
				layer.msg('两次密码输入不一致，请确认一致！', {
				    time: 5000, //20s后自动关闭
				    btn: ['知道了'],
				    anim: 4
				  });
			}
		  
		}, function(){
		  layer.msg('已取消', {icon: 2});
		});
	};
};


//@Bind #ajaxactionLogin.beforeExecute
!function(self, arg) {
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



