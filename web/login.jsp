<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html style="overflow:hidden">
<head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="icon" href="favicon.ico" type="image/x-icon">
    <meta http-equiv="X-UA-Compatible" content="IE=Edge,chrome=IE8">
    <meta name="renderer" content="webkit">
    
<title>NimakManageSystem</title>
<script language="javascript" type="text/javascript" charset="UTF-8" src="./NimakManageSystem_files/boot.dpkg"></script>
<script language="javascript" type="text/javascript">
window.$setting={
	"common.debugEnabled":true,
	"common.showExceptionStackTrace":true,
	"common.enterAsTab":false,
	"common.preventBackspace":"true",
	"common.contextPath":"\/NimakMS",
	"common.abortAsyncLoadingOnSyncLoading":false,
	"widget.skinRoot":">dorado\/client\/skins\/",
	"widget.skin":"modern"
};
$import("desktop-support,widget,entypo-support,font-awesome-support,nprogress");
</script><script id="_package_jquery" type="text/javascript" charset="UTF-8" src="./NimakManageSystem_files/jquery.dpkg"></script>
<script id="_package_jquery-plugins" type="text/javascript" charset="UTF-8" src="./NimakManageSystem_files/jquery-plugins.dpkg"></script>
<script id="_package_jquery-ui" type="text/javascript" charset="UTF-8" src="./NimakManageSystem_files/jquery-ui.dpkg"></script>
<script id="_package_json2" type="text/javascript" charset="UTF-8" src="./NimakManageSystem_files/json2.dpkg"></script>
<script id="_package_underscore" type="text/javascript" charset="UTF-8" src="./NimakManageSystem_files/underscore.dpkg"></script>
<script id="_package_core" type="text/javascript" charset="UTF-8" src="./NimakManageSystem_files/core.dpkg"></script>
<script id="_package_desktop-support" type="text/javascript" charset="UTF-8" src="./NimakManageSystem_files/desktop-support.dpkg"></script>
<script id="_package_touch-patch" type="text/javascript" charset="UTF-8" src="./NimakManageSystem_files/touch-patch.dpkg"></script>
<script id="_package_data" type="text/javascript" charset="UTF-8" src="./NimakManageSystem_files/data.dpkg"></script>
<script id="_package_widget-support" type="text/javascript" charset="UTF-8" src="./NimakManageSystem_files/widget-support.dpkg"></script>
<script id="_package_widget" type="text/javascript" charset="UTF-8" src="./NimakManageSystem_files/widget.dpkg"></script>
<script id="_package_nprogress" type="text/javascript" charset="UTF-8" src="./NimakManageSystem_files/nprogress.dpkg"></script>
<link id="_package_core-skin" rel="stylesheet" type="text/css" charset="UTF-8" href="./NimakManageSystem_files/core-skin.dpkg">
<link id="_package_desktop-support-skin" rel="stylesheet" type="text/css" charset="UTF-8" href="./NimakManageSystem_files/desktop-support-skin.dpkg">
<link id="_package_widget-support-skin" rel="stylesheet" type="text/css" charset="UTF-8" href="./NimakManageSystem_files/widget-support-skin.dpkg">
<link id="_package_entypo-support" rel="stylesheet" type="text/css" charset="UTF-8" href="./NimakManageSystem_files/entypo-support.dpkg">
<link id="_package_font-awesome-support" rel="stylesheet" type="text/css" charset="UTF-8" href="./NimakManageSystem_files/font-awesome-support.dpkg">
<link id="_package_nprogress-skin" rel="stylesheet" type="text/css" charset="UTF-8" href="./NimakManageSystem_files/nprogress-skin.dpkg">

<script language="javascript" type="text/javascript">
dorado.onInit(function(){
try{
var view=new dorado.widget.View({
	"id":"viewMain",
	"name":"bdf2.core.view.frame.Login",
	"listener":{
		"onReady":function(self,arg){
var useCaptcha="true";
var useRemember="true";
window.checkForm=function(){
	var errorInfo=$("#errorInfo");
	var username=$("#username_").val();
	if(username==""){
		errorInfo.html("用户名不能为空!");
		$("#username_").focus();
		return false;
	}
	var password=$("#password_").val();
	if(password==""){
		errorInfo.html("密码不能为空!");
		$("#password_").focus();
		return false;
	}	
	var captcha=$("#captcha_").val();
	if(useCaptcha=="true" && captcha==""){
		errorInfo.html("验证码不能为空!");
		$("#captcha_").focus();
		return false;
	}	
}
function showTime(){
	var date = new Date();
	
	var month = date.getMonth() + 1;  
	var day = date.getDate();  
	var week = new Array("星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六")[date.getDay()];  
	
	var hour = date.getHours() < 10 ? "0" + date.getHours() : date.getHours();  
	var minute = date.getMinutes() < 10 ? "0" + date.getMinutes() : date.getMinutes();  
	var second = date.getSeconds() < 10 ? "0" + date.getSeconds() : date.getSeconds();
	var timeInfo = hour + ":" + minute + ":" + second;  
	$("#timeInfo").html(timeInfo);
	var noon="AM";
	if(hour>11 && hour<24){
		noon="PM";
	}
	$("#noon").html(noon);
	$("#dayMonthInfo").html(month+"月"+day+"日,"+week);
}
function layoutLoginContainer(){
	var height=$(window).height();
	var width=$(window).width();
	var bgImgFolder="dorado/res/icons";
	var bgImg="login-bg1.jpg";
	var bgHeight=464;
	var loginInfoHeight=380;
	if(useCaptcha=="true" && useRemember=="false"){
		loginInfoHeight=360;
	}
	if(useCaptcha=="false" && useRemember=="true"){
		loginInfoHeight=310;
	}	
	if(useCaptcha=="false" && useRemember=="false"){
		loginInfoHeight=290;
	}		
	if(width<1670 && width>1370){
		bgImg="login-bg2.jpg";
		var bgHeight=543;
	}else if(width<1950 && width>1660){
		bgImg="login-bg3.jpg";
		var bgHeight=652;
	}else if(width>1950){
		bgImg="login-bg4.jpg";
		var bgHeight=869;
	}
	var container=$("#loginContainer");
	container.css("position","absolute");
	container.css("top",(height-bgHeight)/2);
	container.css("background","url("+bgImgFolder+"/"+bgImg+")");
	container.css("height",bgHeight+"px");
	container.css("width","100%");
	var loginInfo=$("#loginInfo");
	loginInfo.css("position","absolute");
	loginInfo.css("right","100px");
	loginInfo.css("height",loginInfoHeight+"px");
	loginInfo.css("top",(bgHeight-loginInfoHeight)/2+"px");
	
	var titleContainer=$("#titleContainer");
	titleContainer.css("position","absolute");
	titleContainer.css("left","20px");
	titleContainer.css("top",(height-bgHeight)/2-55);
}
$(window).resize(function(){
	layoutLoginContainer();
});
$(document).ready(function(){
	layoutLoginContainer();
	var container=$("#loginContainer");
	showTime();
	window.setInterval(function(){
		showTime();
	},1000);
	var showType=Math.floor(Math.random()*10);
	if(showType<2){
		container.slideDown(500);
	}else if(showType>1 && showType<3){
		container.show(500);
	}else if(showType>2 && showType<5){
		container.fadeIn(500);
	}else if(showType>4 && showType<7){
		container.slideToggle(500);
	}else{
		container.fadeIn(500);
	}
	$("#captchaImg").click(function(){
		this.src="/NimakMS/generate.captcha.action?width=181&height=60&random="+Math.random();
	});
	var error="";
	if(error && error!=""){
		if(error=="Bad credentials")error="用户名或密码不正确";
		$("#errorInfo").html(error);
	}
	if(useRemember=="true"){
		$("#rememberMeContainer").show();
	}else{
		$("#rememberMeContainer").hide();
	}
	if(useCaptcha=="true"){
		$("#captchaContainer").show();
	}else{
		$("#captchaContainer").hide();
	}	
	$("#username_").focus();
});
}
	}
});
function f(view){view.set("children",[
	{
		"$type":"HtmlContainer",
		"content":"<div id=\"titleContainer\" style=\"color:#40403f\"><h1>NimakManageSystem<\/h1><\/div>\r\n<div id=\"loginContainer\" style=\"display:none;font-family:\u5FAE\u8F6F\u96C5\u9ED1;background-repeat:no-repeat;background-position: center top\">\r\n\t<div id=\"timeInfoContainer\" style=\"position:absolute;top:20px;left:20px;display:block;color:#fff\">\r\n\t\t<div id=\"noon\" style=\"font-size:12px\"><\/div>\r\n\t\t<div id=\"timeInfo\" style=\"font-size:60px;\"><\/div>\r\n\t\t<div id=\"dayMonthInfo\" style=\"font-size:36px;\"><\/div>\r\n\t<\/div>\r\n\t<div id=\"loginInfo\" style=\"border:solid 1px green;background:#FDFDFD;width:320px\">\r\n\t\t<div style=\"margin:20px\">\r\n\t\t\t<div style=\"font-size:24px;color:#0094da;height:50px\">\u7528\u6237\u767B\u5F55<\/div>\r\n\t\t\t<div align=\"right\" style=\"margin-right:20px;margin-bottom:5px;font-size:14px;color:red\" id=\"errorInfo\"><\/div>\r\n\t\t\t<div style=\"margin-right:20px\">\r\n\t\t\t<form name=\"loginForm\" onsubmit=\"return checkForm()\" method=\"post\" action=\"\/NimakMS\/security_check_\">\r\n\t\t\t\t<div  align=\"right\" style=\"color:#999;font-size:14px;height:42px\">\r\n\t\t\t\t\t\u7528\u6237\u540D\uFF1A<input id=\"username_\" tabindex=\"1\" style=\"font-size:18px;height:24px;line-height:22px;width:180px;border:solid 1px #999999\" type=\"text\" name=\"username_\"><\/input>\r\n\t\t\t\t<\/div>\r\n\t\t\t\t<div align=\"right\" style=\"color:#999;font-size:14px;height:42px\">\r\n\t\t\t\t\t\u5BC6\u7801\uFF1A<input tabindex=\"2\" style=\"font-size:18px;height:24px;line-height:22px;width:180px;border:solid 1px #999999\" type=\"password\" id=\"password_\" name=\"password_\"><\/input>\r\n\t\t\t\t<\/div>\r\n\t\t\t\t<div id=\"captchaContainer\" align=\"right\" style=\"color:#999;font-size:14px;height:95px\">\r\n\t\t\t\t\t\u9A8C\u8BC1\u7801\uFF1A<input tabindex=\"3\" style=\"font-size:18px;height:24px;line-height:22px;width:180px;border:solid 1px #999999\" type=\"text\" id=\"captcha_\" name=\"captcha_\"><\/input>\r\n\t\t\t\t\t<img style=\"margin-top:2px\" id=\"captchaImg\" src=\"\/NimakMS\/generate.captcha.action?width=181&height=60\"\/>\r\n\t\t\t\t<\/div>\r\n\t\t\t\t<div id=\"rememberMeContainer\" align=\"right\" style=\"color:#999;font-size:14px;height:33px\">\r\n\t\t\t\t\t\u81EA\u52A8\u767B\u5F55<input type=\"checkbox\" name=\"remember_me_\"><\/input>\r\n\t\t\t\t<\/div>\r\n\t\t\t\t<div align=\"right\" style=\"line-height:80px\">\r\n\t\t\t\t\t<input style=\"width:120px;height:42px;line-height:40px;font-size:20px;text-align:center;\" type=\"submit\" name=\"btn_Login\" value=\"\u767B  \u5F55\">\r\n\t\t\t\t<\/div>\r\n\t\t\t\t\r\n\t\t\t<\/form>\r\n\t\t\t<\/div>\r\n\t\t<\/div>\r\n\t<\/div>\r\n<\/div>"
	}
]);}
view.get("dataTypeRepository").parseJsonData([
]);
f(view);
view.set("renderOn","#doradoView");
view.render();
}
catch(e){dorado.Exception.processException(e);}
});
$import("debugger,common");
</script><script id="_package_base-widget" type="text/javascript" charset="UTF-8" src="./NimakManageSystem_files/base-widget.dpkg"></script>
<script id="_package_debugger" type="text/javascript" charset="UTF-8" src="./NimakManageSystem_files/debugger.dpkg"></script>
<script id="_package_common" type="text/javascript" charset="UTF-8" src="./NimakManageSystem_files/common.dpkg"></script>
<link id="_package_base-widget-skin" rel="stylesheet" type="text/css" charset="UTF-8" href="./NimakManageSystem_files/base-widget-skin.dpkg">
<link id="_package_debugger-skin" rel="stylesheet" type="text/css" charset="UTF-8" href="./NimakManageSystem_files/debugger-skin.dpkg">

</head>
<body scroll="no"
	style="margin: 0px; overflow: hidden; height: 834px; width: 1280px;"
	class="d-chrome d-chrome64">
	<div id="d_viewMain"
		class="d-view d-view-default d-focused d-view-focused"
		style="width: 100%; height: 100%;">
		<div class="d-container-ui-default"
			style="width: 100%; height: 100%; overflow: hidden; position: relative;">
			<div class="d-dock-layout" style="width: 100%; height: 100%;">
				<span id="d__uid_13"
					class="d-html-container d-html-container-default d-container-ui-default d-focused d-html-container-focused"
					style="position: absolute; left: 0px; top: 0px; display: inline-block; width: 1280px; overflow: hidden; height: 834px;"><div
						id="titleContainer"
						style="color: rgb(64, 64, 63); position: absolute; left: 20px; top: 130px;">
						<h1>NimakManageSystem</h1>
					</div>
					<div id="loginContainer"
						style="font-family: 微软雅黑; position: absolute; top: 185px; background: url(&quot;dorado/res/icons/login-bg1.jpg&quot;); height: 464px; width: 100%;">
						<div id="timeInfoContainer"
							style="position: absolute; top: 20px; left: 20px; display: block; color: #fff">
							<div id="noon" style="font-size: 12px">showTime()</div>
							<div id="timeInfo" style="font-size: 60px;">09:01:25</div>
							<div id="dayMonthInfo" style="font-size: 36px;">3月13日,星期二</div>
						</div>
						<div id="loginInfo"
							style="border: 1px solid green; background: rgb(253, 253, 253); width: 320px; position: absolute; right: 100px; height: 380px; top: 42px;">
							<div style="margin: 20px">
								<div style="font-size: 24px; color: #0094da; height: 50px">用户登录</div>
								<div align="right"
									style="margin-right: 20px; margin-bottom: 5px; font-size: 14px; color: red"
									id="errorInfo"></div>
								<div style="margin-right: 20px">
									<form name="loginForm" onsubmit="return checkForm()"
										method="post"
										action="security_check_">
										<div align="right"
											style="color: #999; font-size: 14px; height: 42px">
											用户名：<input id="username_" tabindex="1"
												style="font-size: 18px; height: 24px; line-height: 22px; width: 180px; border: solid 1px #999999"
												type="text" name="username_">
										</div>
										<div align="right"
											style="color: #999; font-size: 14px; height: 42px">
											密码：<input tabindex="2"
												style="font-size: 18px; height: 24px; line-height: 22px; width: 180px; border: solid 1px #999999"
												type="password" id="password_" name="password_">
										</div>
										<div id="captchaContainer" align="right"
											style="color: #999; font-size: 14px; height: 95px">
											验证码：<input tabindex="3"
												style="font-size: 18px; height: 24px; line-height: 22px; width: 180px; border: solid 1px #999999"
												type="text" id="captcha_" name="captcha_"> <img
												style="margin-top: 2px" id="captchaImg"
												src="./NimakManageSystem_files/generate.captcha.action">
										</div>
										<div id="rememberMeContainer" align="right"
											style="color: #999; font-size: 14px; height: 33px">
											自动登录<input type="checkbox" name="remember_me_">
										</div>
										<div align="right" style="line-height: 80px">
											<input
												style="width: 120px; height: 42px; line-height: 40px; font-size: 20px; text-align: center;"
												type="submit" name="btn_Login" value="登  录">
										</div>

									</form>
								</div>
							</div>
						</div>
					</div></span>
			</div>
		</div>
	</div>
</body>
</html>