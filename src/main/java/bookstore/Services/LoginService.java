package bookstore.Services;

import java.util.Optional;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import org.springframework.stereotype.Service;

import bookstore.DTOs.loginRequestDTO;
import bookstore.DTOs.responseDTO;
import bookstore.Entity.Registerentity;
import bookstore.JWT.JWTgenerator;
import bookstore.Repository.RegisterRepo;


@Service
public class LoginService {

	@Autowired
	RegisterRepo registerRepo;
	@Autowired
	JWTgenerator token;
	@Autowired
	BCryptPasswordEncoder passwordEncoder;
	
	public ResponseEntity<responseDTO> login(loginRequestDTO loginReq){
		Optional<Registerentity> customer=registerRepo.findByUsername(loginReq.getUsername());
		
		if(customer.isEmpty()) {
			throw new RuntimeException("User not found");
		}
		Registerentity data=customer.get();
		

		if(!passwordEncoder.matches(loginReq.getPassword(),data.getPassword())) {
			
			throw new RuntimeException("invalid password");
		}
			String tokens=token.generateaccessToken(data.getUsername(),data.getId());
			String tokenss=token.generateRefreshToken(data.getUsername(),data.getId());
			String usernames=loginReq.getUsername();
			
				responseDTO response=new responseDTO();
				response.setAccessToken(tokens);
				response.setRefreshToken(tokenss);
				response.setUsername(usernames);
				
				return ResponseEntity.ok(response);

}
}
	

	
	
