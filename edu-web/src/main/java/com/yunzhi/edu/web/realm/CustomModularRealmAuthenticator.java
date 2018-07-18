package com.yunzhi.edu.web.realm;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.pam.ModularRealmAuthenticator;
import org.apache.shiro.realm.Realm;

public class CustomModularRealmAuthenticator extends ModularRealmAuthenticator {

	@Override
	protected AuthenticationInfo doAuthenticate(AuthenticationToken authenticationToken)
			throws AuthenticationException {
		
		assertRealmsConfigured();
		
		CustomToken customizedToken = (CustomToken)authenticationToken;
		
		String logintype = customizedToken.getLogintype();
		Collection<Realm> realms = getRealms();
		
		Collection<Realm> typeRealms = new ArrayList<>();
		for(Realm realm: realms){
			if(realm.getName().contains(logintype)){
				typeRealms.add(realm);
			}
		}
		
		if (typeRealms.size() == 1)
            return doSingleRealmAuthentication(typeRealms.iterator().next(), customizedToken);
        else
            return doMultiRealmAuthentication(typeRealms, customizedToken);
	
	}
	
	
}
