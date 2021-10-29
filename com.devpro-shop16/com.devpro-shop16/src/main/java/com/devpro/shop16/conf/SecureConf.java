package com.devpro.shop16.conf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;



@Configuration // -> là 1 bean spring hiểu được
@EnableWebSecurity
public class SecureConf extends WebSecurityConfigurerAdapter {
	@Autowired
	UserDetailsService userDetailsService;
	 
	
	@Override
	protected void configure(final HttpSecurity http) throws Exception {
		http.csrf().disable().authorizeRequests() // bắt đầu cấu hình: tất cả các requests từ 
		// trình duyệt đều được bắt trong hàm này

		//cho phép các request static resources không bị ràng buộc(permitAll)
		.antMatchers("/css/**", "/js/**", "/upload/**","/images/**","/bootstrap/**").permitAll()
		.antMatchers("/home")./*authenticated()*/hasAuthority("user")
		//các request kiểu: "/admin/" là phải đăng nhập (authenticated)
		.antMatchers("/Admin")./*authenticated()*/hasAuthority("admin")
		

		.and()
		
		//cấu hình trang đăng nhập
		// /login là 1 action
		.formLogin().loginPage("/login").loginProcessingUrl("/perform_login")./*defaultSuccessUrl("/Admin/product/list", true)*/successHandler(myAuthenticationSuccessHandler())
		.failureUrl("/login?login_error=true")
		.permitAll()

		.and()

		//cấu hình cho phần logout
		.logout().logoutUrl("/logout").logoutSuccessUrl("/home").invalidateHttpSession(true)
		.deleteCookies("JSESSIONID")
		.permitAll();
	}
	@Bean
	public AuthenticationSuccessHandler myAuthenticationSuccessHandler(){
	    return new MySimpleUrlAuthenticationSuccessHandler();
	}
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder(4));
	}
	
	
}
