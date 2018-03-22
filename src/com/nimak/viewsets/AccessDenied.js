
// @Bind view.onReady
!function(dialog) {
	//dorado.MessageBox.alert("权限不足，访问被拒绝!");
	layer.msg('权限不足，访问被拒绝!', {
	    time: 5000, //20s后自动关闭
	    btn: ['知道了'],
	    anim: 4
	  });
};
