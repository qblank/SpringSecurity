package cn.qblank.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserDetailServiceImpl implements UserDetailsService{
	@Autowired
	private PasswordEncoder passwordEncoder;
	/**
	 * �û�Ȩ�޹���
	 */
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// ��spring security��Ҫ�û�����ʱ���ô˷����������û���
		System.out.println("����:123456 = " + passwordEncoder.encode("123456"));
		System.out.println("����:admin = " + passwordEncoder.encode("admin"));
		switch(username){
			case "user": 
				return new User("user", "$2a$10$spEZnJMseKZKynWV.X5/AuJjg.hpkeGJNx8ehCdARoNRpa3xLHMmW", "USER");
			case "admin":
				return new User("admin", "$2a$10$OvXZsFpWZlVYwvDa.Q9grOnxeWvAlaLPmtFTZCI7XM5dFfGlb1oVW", "ADMIN");
			case "hr":
				return new User("hr", "$2a$10$spEZnJMseKZKynWV.X5/AuJjg.hpkeGJNx8ehCdARoNRpa3xLHMmW", "ADMIN","HR");
			default:
				throw new UsernameNotFoundException( username+"������");
		}
	}

}
