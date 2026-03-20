package bookstore.ErrorHandling;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice

public class RegisterErrorHandler {

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String,String>>handleException(MethodArgumentNotValidException Ex){
		
		Map<String,String>error=new HashMap<>();
		 Ex.getBindingResult().getFieldErrors().forEach(fielderror ->
         error.put(fielderror.getField(),fielderror.getDefaultMessage()));

 return ResponseEntity.badRequest().body(error);
		
		
	}
}
