package hu.qlm.flights.security;

import java.io.IOException;
import java.util.List;
import java.util.stream.Stream;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;
import org.springframework.web.filter.OncePerRequestFilter;

@Component
public class HeaderSecurityFilter extends OncePerRequestFilter{

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {

		final String userNameHeader = request.getHeader("x-jwt-username");
		final String authHeader = request.getHeader("x-jwt-auth");

		if (!ObjectUtils.isEmpty(authHeader) && !ObjectUtils.isEmpty(userNameHeader)) {
			
			
			String[] split = authHeader.split(",");
			List<SimpleGrantedAuthority> authorities = Stream.of(split).map(SimpleGrantedAuthority::new).toList();
			UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
					new User(userNameHeader, "dummy", authorities), "dummy", authorities);
					
			
			usernamePasswordAuthenticationToken
					.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
			
			SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
		}
		
		filterChain.doFilter(request, response);		
	}

}
