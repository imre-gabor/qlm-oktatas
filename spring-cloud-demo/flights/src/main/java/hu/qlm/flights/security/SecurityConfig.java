package hu.qlm.flights.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig {
	
	@Autowired
	HeaderSecurityFilter headerSecurityFilter;

	@Bean
	  public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		 
	        http
	            .authorizeHttpRequests((authz) -> authz
	                .anyRequest().permitAll()
	            )
	            .csrf().disable()
	            .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
	            .and()
	            .addFilterBefore(headerSecurityFilter, UsernamePasswordAuthenticationFilter.class);
	        
	        return http.build();
	    }
}
