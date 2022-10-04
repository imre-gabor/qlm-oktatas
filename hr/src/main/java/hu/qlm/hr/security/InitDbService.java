package hu.qlm.hr.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import hu.qlm.hr.mapper.HrUserMapper;
import hu.qlm.hr.model.HrUser;

@Service
public class InitDbService {

	@Autowired
	HrUserMapper hrUserMapper;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Transactional
	public void initDb() {
		Optional<HrUser> testuser = hrUserMapper.selectByPrimaryKey("test");
		if(testuser.isEmpty()) {
			hrUserMapper.insert(new HrUser("test",  passwordEncoder.encode("pass")));
		}
	}
}
