package com.easyjob.security;

import java.lang.reflect.InvocationTargetException;

import javax.annotation.Resource;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.shiro.authc.AccountException;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.easyjob.domain.User;
import com.easyjob.service.UserService;

public class ShiroDataBaseRealm extends AuthorizingRealm {
	
	private static final Logger logger = LoggerFactory.getLogger(ShiroDataBaseRealm.class);

	@Resource
	private UserService userService;
	/**
	 * ��Ȩ
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(
			PrincipalCollection principals) {
		if(principals == null) {
			throw new AuthorizationException("principals ������Ϊ�գ�");
		}
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		return info;
	}

	/**
	 * ��֤
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		
		UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) token;
		
		String username = usernamePasswordToken.getUsername();
		String password = new String(usernamePasswordToken.getPassword());
		
		if(username == null) {
			throw new AccountException("�û�������Ϊ�գ�");
		}
		
		User user = null;
		try {
			user = userService.findByNameAndPwd(username, password);
		} catch (Exception e) {
			logger.error("",e);
			new AuthenticationException("ϵͳ�ڲ�����");
		}
		
		if(user == null) {
			throw new UnknownAccountException("�û������ڣ�");
		}
		
		UserDetails userDetails = new UserDetails();
		try {
			BeanUtils.copyProperties(userDetails, user);
		} catch (IllegalAccessException | InvocationTargetException e) {
			logger.error("",e);
			new AuthenticationException("ϵͳ�ڲ�����");
		}
		return new SimpleAuthenticationInfo(userDetails, user.getPassword(), getName());
	}

}
