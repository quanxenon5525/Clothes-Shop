package com.web.FinalProject.service;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.web.FinalProject.config.Encrypt;
import com.web.FinalProject.mapper.UserMapper;
import com.web.FinalProject.model.User;
import com.web.FinalProject.model.UserExample;

@Service
public class CustomUserDetailService implements UserDetailsService {
	private String SecretKey = "1@1231%&$$!";
	@Autowired
	UserMapper userMapper;
	 @Autowired HttpServletResponse response; 

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserExample example =  new UserExample();
		example.createCriteria().andUsernameEqualTo(username);
		List<User>listUser = userMapper.selectByExample(example);
		if(listUser.size() > 0) {
			
			User user =  listUser.get(0);
			List<GrantedAuthority> grantList =  new ArrayList<GrantedAuthority>();
			GrantedAuthority authority =  new SimpleGrantedAuthority("ADMIN");
			grantList.add(authority);
		    Cookie cookie = new Cookie("session_idUser", Encrypt.encrypt(user.getUsername(), SecretKey));
		    response.addCookie(cookie);

			UserDetails userDetails =  new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), grantList);

			return userDetails;
		}else {
			new UsernameNotFoundException("Login fail!");
		}
		return null;
	}

}
