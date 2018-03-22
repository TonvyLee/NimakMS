/*function CloseWebPage(){
 if (navigator.userAgent.indexOf("MSIE") > 0) {
  if (navigator.userAgent.indexOf("MSIE 6.0") > 0) {
   window.opener = null;
   window.close();
  } else {
   window.open('', '_top');
   window.top.close();
  }
 }
 else if (navigator.userAgent.indexOf("Firefox") > 0) {
  window.location.href = 'about:blank ';
 } else {
  window.opener = null;
  window.open('', '_self', '');
  window.close();
 }
}*/

// @Bind view.onReady
!function(self,dialog) {
	dorado.MessageBox.confirm("成功退出系统，是否重新登录",function(){
		//window.location.href="http://localhost:8080/NimakMS/com.nimak.viewsets.Login1.d";
		window.location.href="./com.nimak.viewsets.Login1.d";
		return;
	});
	//CloseWebPage();	
};
