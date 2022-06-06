package ifce.edu.br.MeuPrimeiroSpringBoot.config;

import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableGlobalMethodSecurity(prePostEnabled = true)
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
    protected void configure(HttpSecurity http) throws Exception { 
		http.authorizeRequests()
		.antMatchers("/webjars/**", "/css/**", "/image/**", "/js/**").permitAll()
		.antMatchers("/").permitAll()    		
		.anyRequest().authenticated()
		.and() 
		.formLogin()
		.loginPage("/login")
		.defaultSuccessUrl("/", true) 
		.failureUrl("/login-error") 
		.permitAll() 
	.and() 
		.logout() 
		.logoutSuccessUrl("/"); 
    }   
     
}
