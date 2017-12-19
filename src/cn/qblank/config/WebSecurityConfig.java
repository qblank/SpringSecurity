package cn.qblank.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity  // ��̬��Դ��json��У���֧��
//����web security֧�֣�Ӧ��bean�������WebSecurityConfigurer
@EnableGlobalMethodSecurity(securedEnabled = true,
//����ע��
prePostEnabled = true)  
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
	@Autowired
	private UserDetailsService userDetailsService;
	/**
	 * ���û�����̬��Դ����Ȩ�޹���
	 */
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		.antMatchers("/login").permitAll()     //��login�ķ���Ȩ
		.antMatchers("/assets/**").permitAll()	//����̬�ļ��ķ���Ȩ
		.antMatchers("/admin/**").hasRole("ADMIN")	//����admin·���µ��ļ�ֻ��admin����
		.antMatchers("/**").authenticated().and()	//������Ա��ͨ������ͨ��Դ��Ȩ��
		.formLogin()	//���ڱ�
		.loginPage("/login") 	//�Զ�����ύҳ��
		.and()
		//��Ӽ�ס����
		.rememberMe()   
		//����remember Me��֧��
		.userDetailsService(userDetailsService)   
		//��ס��Сʱ
		.tokenValiditySeconds(8*3600); 
	}
	
	/**
	 * ʹ��BCryptPasswordEncoder��������
	 * @return
	 */
	@Bean
	public PasswordEncoder passwordEncoder(){
		System.out.println("WebSecurityConfig.passwordEncoder()");
		return new BCryptPasswordEncoder();
	}
}
