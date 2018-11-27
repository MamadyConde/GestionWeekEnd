package fr.Istic.service;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import fr.Istic.entities.Person;
@Service
public class PersonDetailService implements UserDetailsService {
	@Autowired
	private PersonMetier personMetier;
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Person person = personMetier.findPersonByEmail(email);
		Collection<GrantedAuthority> authorities=new ArrayList<>();
		person.getRoles().forEach(r->{
			authorities.add(new SimpleGrantedAuthority(r.getRoleName()));
		});
		if(person==null)throw new UsernameNotFoundException("User details not found with this username: " +email);
		return new User(person.getEmail(),person.getPassword(),authorities);
	}

}
