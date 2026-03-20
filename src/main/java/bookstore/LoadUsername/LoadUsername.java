package bookstore.LoadUsername;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import bookstore.Entity.Registerentity;
import bookstore.Repository.RegisterRepo;

@Service
public class LoadUsername implements UserDetailsService{
	
	@Autowired
	RegisterRepo registerRepo;
	
	@Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Registerentity user = registerRepo.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
        return org.springframework.security.core.userdetails.User.builder()
                .username(user.getUsername())
                .password(user.getPassword())  // encrypted password
                .authorities(user.getRole())   // e.g. ROLE_USER, ROLE_ADMIN
                .build();
	
}
	}
