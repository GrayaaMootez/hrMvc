package com.tez.hrMvc.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tez.hrMvc.model.UsrMen;


@Service("customUserDetailsService")
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private UsrMenService usrMenService;

	@Override
	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String ssoId) throws UsernameNotFoundException {
		UsrMen user = usrMenService.findById(ssoId);
		System.out.println("User : " + user);
		if (user == null) {
			System.out.println("User not found");
			throw new UsernameNotFoundException("Username not found");
		}
		return new org.springframework.security.core.userdetails.User(user.getUtil(), user.getPwd(),
				user.getUtilValid().equals("A"), true, true, true, getGrantedAuthorities(user));
	}

	private List<GrantedAuthority> getGrantedAuthorities(UsrMen user) {
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();

		/*for (Profil profil : user.getProfils()) {
			System.out.println("UserProfile : " + profil.getLibProfil());
			authorities.add(new SimpleGrantedAuthority("ROLE_" + profil.getLibProfil()));
		}
		System.out.print("authorities :" + authorities);*/
		return authorities;
	}

}
