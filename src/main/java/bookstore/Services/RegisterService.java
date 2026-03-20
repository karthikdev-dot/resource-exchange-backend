package bookstore.Services;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;



import bookstore.DTOs.registerRequest;
import bookstore.Entity.Registerentity;
import bookstore.Repository.RegisterRepo;



@Service
public class RegisterService {

	@Autowired
	RegisterRepo registerRepo;
	@Autowired
	BCryptPasswordEncoder passwordEncoder;
	
	public String findByusername(registerRequest req){
	
	Optional<Registerentity>hello=registerRepo.findByUsername(req.getUsername());
	if(hello.isPresent()) {
		return "user is already is existed";
	}
	String hashpassword= passwordEncoder.encode(req.getPassword());
	
	
		 Registerentity reg=new Registerentity();
		 reg.setUsername(req.getUsername());
		 reg.setFirstname(req.getFirstname());
		 reg.setMiddlename(req.getMiddlename());
		 reg.setLastname(req.getLastname());
		 reg.setEmail(req.getEmail());
		 reg.setPassword(hashpassword);
		 reg.setRole("ROLE_USER");
		 reg.setAge(req.getAge());
		 reg.setLatitude(req.getLatitude());
		 reg.setLongitude(req.getLongitude());
		 reg.setAddress(req.getAddress());
		 
		 registerRepo.save(reg);
		 
	return "Registration successfull";
		}
	}




