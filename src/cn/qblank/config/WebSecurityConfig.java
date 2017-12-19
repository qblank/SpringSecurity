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
@EnableWebSecurity  // 静态资源、json、校验等支持
//开启web security支持：应用bean容器里的WebSecurityConfigurer
@EnableGlobalMethodSecurity(securedEnabled = true,
//开启注解
prePostEnabled = true)  
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
	@Autowired
	private UserDetailsService userDetailsService;
	/**
	 * 给用户、静态资源进行权限管理
	 */
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		.antMatchers("/login").permitAll()     //给login的访问权
		.antMatchers("/assets/**").permitAll()	//给静态文件的访问权
		.antMatchers("/admin/**").hasRole("ADMIN")	//设置admin路径下的文件只能admin访问
		.antMatchers("/**").authenticated().and()	//给管理员普通赋予普通资源的权限
		.formLogin()	//用于表单
		.loginPage("/login") 	//自定义表单提交页面
		.and()
		//添加记住功能
		.rememberMe()   
		//开启remember Me的支持
		.userDetailsService(userDetailsService)   
		//记住八小时
		.tokenValiditySeconds(8*3600); 
	}
	
	/**
	 * 使用BCryptPasswordEncoder管理密码
	 * @return
	 */
	@Bean
	public PasswordEncoder passwordEncoder(){
		System.out.println("WebSecurityConfig.passwordEncoder()");
		return new BCryptPasswordEncoder();
	}
}
