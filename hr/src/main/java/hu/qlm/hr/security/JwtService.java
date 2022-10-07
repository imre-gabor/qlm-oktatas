package hu.qlm.hr.security;

import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

@Service
public class JwtService {
	
	private static final String ISSUER = "HrApp";
	private Algorithm algorithm = Algorithm.HMAC256("secret");


	public String createJwt(UserDetails userDetails) {
		return JWT.create()
				.withSubject(userDetails.getUsername())
				.withArrayClaim("auth",
						userDetails.getAuthorities().stream()
						.map(GrantedAuthority::getAuthority).toArray(String[]::new))
				.withExpiresAt(new Date(System.currentTimeMillis() + TimeUnit.HOURS.toMillis(2)))
				.withIssuer(ISSUER)
				.sign(algorithm);
	}

	public UserDetails parseJwt(String jwtToken) {

		DecodedJWT decodedJwt = JWT.require(algorithm)
				.withIssuer(ISSUER)
				.build()
				.verify(jwtToken);
				
		return new User(decodedJwt.getSubject(), "dummy", 
				decodedJwt.getClaim("auth").asList(String.class)
					.stream()
					.map(SimpleGrantedAuthority::new)
					.toList());

	}
}
