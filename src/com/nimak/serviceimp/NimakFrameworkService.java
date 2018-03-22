package com.nimak.serviceimp;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;

import com.bstek.bdf2.core.business.IUser;
import com.bstek.bdf2.core.service.IFrameworkService;
import com.nimak.entity.NimakUser;

public class NimakFrameworkService implements IFrameworkService {

	@Override
	public void authenticate(IUser user,
			UsernamePasswordAuthenticationToken authentication)
			throws AuthenticationException {
		NimakUser u = (NimakUser) user;
		System.out.println(u.getPassword());
		String pwd = (String) authentication.getCredentials();
		System.out.println(pwd);
		if (!u.getPassword().equals(pwd)) {
			throw new BadCredentialsException("The password is invalid");
		}
	}

}
