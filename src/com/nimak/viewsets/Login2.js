
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
		showMessage("�û��������벻��Ϊ��");
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
			title : "��ʾ",
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
			dorado.MessageBox.confirm("ȷ��ע����Ϣ��", function() {
				updateActionSave.execute();
				dialog.hide();
			});
		} else {
			dorado.MessageBox.alert("�����������Ϣ��");
			arg.processDefault = false;
		}
	} else {
		showMessage("�����������벻һ�£���ȷ��һ�£�");
	}
};

// @Bind #buttonCancel1.onClick
!function(self, arg, dsUsers, dialog) {
	dsUsers.get("data:#").cancel();
	dialog.hide();
};*/







/**************************************************************************************
 * �޸��Ժ�
 * *********************************************************************************/
 
// @Bind view.onReady
!function(ajaxactionLogin,updateActionSave,dsUsers) {
	
	
	
	// ��¼��ť���
	var loginButton = document.getElementById("loginbutton");
	loginButton.onclick = function(){
		ajaxactionLogin.execute();
	};
	
	// �س�����¼
	var passwordInput = document.getElementById("password");
	passwordInput.onkeydown = function(e){
		if (13 == e.keyCode) {
			ajaxactionLogin.execute();
		}
	};
	
	// ע�ᰴť���
	var registerButton = document.getElementById("registerbutton");
	registerButton.onclick = function(e){
		
		//ѯ�ʿ�
		layer.confirm('ȷ��ע�᣿', {
		  btn: ['�ǵ�','ȡ��'],
		  anim: 4
		  //��ť
		}, function(){
		
			var dataSet = dsUsers.get("data");
			var i=0;
			dataSet.each(function(){
				i++;
			});
			var entity = dsUsers.insert();
			

			// ��ȡҳ�������ֵ
			var usersName = document.getElementById("usernamesignup").value;
			var usersPassword = document.getElementById("passwordsignup").value;
			var usersPassword2 = document.getElementById("passwordsignup_confirm").value;
			var userPhonenumber = document.getElementById("usersPhonenum").value;
			var content = document.getElementById("content").value;
			var userId = i+1;
			var usersAuthority = "visitor";
			
			// ҳ������ֵΪentity�ĸ�����ֵ
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
						layer.msg('ע��ɹ�', {icon: 1,anim: 4});
				} else {
					//dorado.MessageBox.alert("�����������Ϣ��");
					layer.msg('�����������Ϣ��', {
						    time: 1000, //20s���Զ��ر�
						    btn: ['֪����'],
						    anim: 4
						  });
					e.processDefault = false;
				}
			} else {
				//showMessage("�����������벻һ�£���ȷ��һ�£�");
				layer.msg('�����������벻һ�£���ȷ��һ�£�', {
				    time: 5000, //20s���Զ��ر�
				    btn: ['֪����'],
				    anim: 4
				  });
			}
		  
		}, function(){
		  layer.msg('��ȡ��', {icon: 2});
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
		//showMessage("�û��������벻��Ϊ��");
		layer.alert('�û��������벻��Ϊ��', {
			  skin: 'layui-layer-molv' //��ʽ����
			  ,closeBtn: 0
			  ,anim: 4 //��������
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
			title : "��ʾ",
			icon : "WARNING"
		});
	}
};



