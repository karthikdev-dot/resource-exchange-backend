package bookstore.Controller;

import org.springframework.beans.factory.annotation.Autowired;



import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bookstore.DTOs.loginRequestDTO;
import bookstore.DTOs.responseDTO;
import bookstore.Services.LoginService;


@CrossOrigin(origins = "*")
@RestController

@RequestMapping("/auth")
public class LoginController {

	
	@Autowired
	LoginService loginService;
	
	@PostMapping("/login")
	public ResponseEntity<responseDTO> logins(@RequestBody loginRequestDTO loginReq ){
		
		return loginService.login(loginReq);
		
	
				
		}
			
		
	}
	
