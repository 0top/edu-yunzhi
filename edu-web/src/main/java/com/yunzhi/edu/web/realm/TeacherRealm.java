package com.yunzhi.edu.web.realm;

import java.util.HashSet;
import java.util.Set;

import javax.annotation.Resource;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.ShiroException;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import com.yunzhi.edu.dao.SchoolTeacherMapper;
import com.yunzhi.edu.entity.SchoolTeacher;
import com.yunzhi.edu.entity.User;
import com.yunzhi.edu.util.EncryptUtil;

public class TeacherRealm extends AuthorizingRealm {

	@Resource
	private SchoolTeacherMapper teacherDao;
	
	public String getName(){
		return "TeacherRealm";
	}
	
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		try{
			String staffNum = (String)principals.getPrimaryPrincipal();	
			SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
			
			Set<String> roles = new HashSet<String>();
			SchoolTeacher teacher = new SchoolTeacher();
			teacher.setStaffNum(staffNum);
			teacher = teacherDao.selectTeacherSelective(teacher);
			
			roles.add(teacher.getRoleName());
			info.setRoles(roles);
			return info;
		}catch(Exception e){
			return null;
		}
		
		
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		System.out.println(" shiro teacher 认证");
		String staffNum = (String)token.getPrincipal();
		String password = String.copyValueOf((char [])token.getCredentials()) ;
		String orgCode = SecurityUtils.getSubject().getSession().getAttribute("orgCode").toString();
		
//		System.out.println("staffNum"+staffNum+"  password:"+password+"   orgCode:"+orgCode);
		
		SchoolTeacher teacher = new SchoolTeacher();
		teacher.setStaffNum(staffNum);
		try{
		teacher = teacherDao.selectByStaffNumAuthentication(staffNum, orgCode);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		if(null == teacher){
			System.out.println(" no such teacher  ");
			throw new UnknownAccountException();
		}
		else if(teacher.getPassword().equals(EncryptUtil.encryptMD5(password, teacher.getSalt()))){
			System.out.println(" teacher can login ");
			AuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(teacher.getStaffNum(), password, getName());
			return authenticationInfo;
			
		}else{
			System.out.println(" exception "+teacher.toString());
			throw new UnknownAccountException();
		}
			
	}

}
