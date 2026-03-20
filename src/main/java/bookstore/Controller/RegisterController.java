package bookstore.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bookstore.DTOs.registerRequest;
import bookstore.Services.RegisterService;
import jakarta.validation.Valid;

 
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/auth")
public class RegisterController {
	
@Autowired 
RegisterService registerService;

	@PostMapping("/register")
	public String register( @Valid @RequestBody registerRequest req){
	  return registerService.findByusername(req);
	}
}
	
	
	