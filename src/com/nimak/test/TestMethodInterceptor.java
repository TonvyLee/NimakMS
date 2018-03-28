package com.nimak.test;

import java.lang.reflect.Method;

import org.springframework.stereotype.Component;

import com.bstek.bdf2.core.aop.IMethodInterceptor;
import com.bstek.bdf2.core.context.ContextHolder;
import com.bstek.bdf2.core.view.frame.main.register.logininfo.ShowLoginInfoShortcutRegister;

@Component
public class TestMethodInterceptor implements IMethodInterceptor {

	
	public boolean support(Class<?> objectClass, Method method) {
		if (objectClass.getName().equals(
				ShowLoginInfoShortcutRegister.class.getName()) && method.getName().equals("registerToStatusBar")) {
			System.out.println("调用拦截方法,判断*ShortcutRegister方法调用是否出错！\n");
			return true;
		}
		return false;
	}

	public void doBefore(Class<?> objectClass, Method method, Object[] arguments)
			throws Exception {
		System.out.println("......before invoke:" + method.getName());
		System.out.println("......login user:"
				+ ContextHolder.getLoginUserName());

			/*if (ContextHolder.getLoginUserName() == null) {
				StringBuffer sb = new StringBuffer();
				// sb.append("dorado.MessageBox.alert(\"重新登录！\")");
				// throw new ClientRunnableException(sb.toString());
				throw new ClientRunnableException("Session超时,烦请重新登录！！！！！！",
						"window.top.location.href='./index.jsp';");
			}*/
	}

	public void doAfter(Class<?> objectClass, Method method,
			Object[] arguments, Object returnValue) throws Exception {
		System.out.println("......after invoke:" + method.getName());
		System.out.println("......return value:" + returnValue);
		System.out.println("......arguments:" + arguments);
	}
}