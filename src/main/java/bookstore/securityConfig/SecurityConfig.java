package bookstore.securityConfig;

	import bookstore.SecurityFilterChain.JWTFilter; // your JWT filter
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.context.annotation.Bean;
	import org.springframework.context.annotation.Configuration;
	import org.springframework.security.authentication.AuthenticationManager;
	
	import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
	import org.springframework.security.config.http.SessionCreationPolicy;
	

import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
	import org.springframework.security.config.annotation.web.builders.HttpSecurity;

	@Configuration
	public class SecurityConfig {

	    @Autowired
	    private JWTFilter jwtFilter;  // your JWT filter

	    

	    @Bean
	    public AuthenticationManager authenticationManager(AuthenticationConfiguration authConfig) throws Exception {
	        return authConfig.getAuthenticationManager();
	    }

	    @Bean
	    public DefaultSecurityFilterChain security(HttpSecurity http) throws Exception {
	        http
	            .csrf(csrf -> csrf.disable())
	            .authorizeHttpRequests(auth -> auth
	                .requestMatchers("/auth/login",
	                        "/auth/register").permitAll()
	                .requestMatchers("/api/get").hasAnyRole("USER","ADMIN")// public endpoints
	                .anyRequest().authenticated()           // all other endpoints require authentication
	            )
	            .sessionManagement(session -> session
	                .sessionCreationPolicy(SessionCreationPolicy.STATELESS) // JWT → stateless
	            )
	            .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);

	        return http.build();
	    }
	}


