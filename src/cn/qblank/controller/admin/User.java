package cn.qblank.controller.admin;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

public class User extends org.springframework.security.core.userdetails.User{
	public User(String username,String password,String... roles){
		super(username, password, buildAuthorities(roles));
	}
	
	public static List<GrantedAuthority> buildAuthorities(String[] roles){
		List<GrantedAuthority> authorities = new ArrayList<>();
		System.out.println(roles);
		for (String role : roles) {
			//��סҪƴ�ӽ�ɫ
			authorities.add(new SimpleGrantedAuthority("ROLE_"+role));
		}
		return authorities;
	}
	
	
}
