package hu.qlm.hr.security;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import hu.qlm.hr.mapper.HrUserMapper;
import hu.qlm.hr.model.HrUser;

@Service
public class HrUserDetailsService implements UserDetailsService{

	@Autowired
	private HrUserMapper hrUserMapper;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		HrUser hrUser = hrUserMapper.selectByPrimaryKey(username)
			.orElseThrow(() -> new UsernameNotFoundException(username));
		
		return new User(hrUser.getUsername(), hrUser.getPassword(), Arrays.asList(new SimpleGrantedAuthority("CREATE_EMP")));
		
	}

}
