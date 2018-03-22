
// @Bind view.onReady
!function(dialog) {
	//dorado.MessageBox.alert("权限不足，访问被拒绝!");
	layer.msg('登录会话过期，请重新登录', {
	    time: 5000, //20s后自动关闭
	    btn: ['知道了'],
	    anim: 4
	  });
};
