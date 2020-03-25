package com.Tadamon.Services;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.Tadamon.Entity.Accounts;
import com.Tadamon.Entity.Roles;






@Service
public class JwtUserDetailsService implements UserDetailsService{
	@Autowired 
	private IserviceAccounts serviceAccount;
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Accounts GU = serviceAccount.findByEmail(email);
		if (GU != null) {
			return new User(GU.getEmail(),GU.getPassword(),getGrantedAuthorities(GU));
		} 

		else {
			throw new UsernameNotFoundException("User not found with email: " + email);
		}

	}
	private List<GrantedAuthority> getGrantedAuthorities(Accounts user)
	 {
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		Roles role = user.getRole();
		
			authorities.add(new SimpleGrantedAuthority(role.getLabel()));
		System.out.println(authorities);
		
		return authorities;
	}
}
