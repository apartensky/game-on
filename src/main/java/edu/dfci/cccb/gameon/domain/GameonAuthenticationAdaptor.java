package edu.dfci.cccb.gameon.domain;

import java.util.Collection;

import org.mitre.openid.connect.model.OIDCAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

public class GameonAuthenticationAdaptor implements Authentication {

	private static final long serialVersionUID = 1L;
	private final Authentication authentication;
	
	public GameonAuthenticationAdaptor(Authentication authentication){
		this.authentication=authentication;		
	}
	
	@Override
	public String getName() {
		if(this.authentication instanceof OIDCAuthenticationToken){
			return ((OIDCAuthenticationToken) this.authentication).getUserInfo().getEmail();		
		}else{
			return this.authentication.getName();
		}			 
	}
	
	@Override
	public Object getPrincipal() {
		return this.authentication.getPrincipal();
	}
	@Override
	public Object getDetails() {
		return this.authentication.getDetails();
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return this.authentication.getAuthorities();
	}

	@Override
	public Object getCredentials() {
		return authentication.getCredentials();
	}

	@Override
	public boolean isAuthenticated() {
		return authentication.isAuthenticated();
	}

	@Override
	public void setAuthenticated(boolean isAuthenticated)
			throws IllegalArgumentException {
		// TODO Auto-generated method stub
		
	}

	

}
