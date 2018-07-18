package com.yunzhi.edu.web.realm;


import java.util.HashSet;
import java.util.Set;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import com.yunzhi.edu.dao.UserMapper;
import com.yunzhi.edu.entity.User;
import com.yunzhi.edu.util.EncryptUtil;


public class UserRealm extends AuthorizingRealm {
	
	@Autowired
	private UserMapper userDao;
		
	public String getName(){
		return "UserRealm";
	}

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		try{
			String phone = (String)principals.getPrimaryPrincipal();
						
			SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
			Set<String> roles = new HashSet<String>();
			
			roles.add(userDao.selectByPhoneNumAuthentication(phone).getRoleName());
			info.setRoles(roles);

			return info;
		}catch(Exception e){
			
			return null;
		}
		
		
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		
		System.out.println("shiro user 认证");
		String phonenum = (String)token.getPrincipal();
		String password = String.copyValueOf((char [])token.getCredentials()) ;
				
		User user = userDao.selectByPhoneNumAuthentication(phonenum);
		
		if(null == user){
			throw new UnknownAccountException();
		}
		else if(user.getPassword().equals(EncryptUtil.encryptMD5(password, user.getSalt()))){
			
			AuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(user.getPhonenum(), password, getName());
            return authenticationInfo;
            
		}
		else{
			throw new UnknownAccountException();
		}
			
	}

}
