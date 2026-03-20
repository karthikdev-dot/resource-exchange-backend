package bookstore.SecurityFilterChain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import bookstore.JWT.JWTgenerator;
import bookstore.LoadUsername.LoadUsername;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;


@Component
public class JWTFilter extends OncePerRequestFilter {
	
@Autowired
JWTgenerator JWTtoken;

@Autowired
LoadUsername load;

@Override
protected void doFilterInternal(HttpServletRequest request,
        HttpServletResponse response,
        FilterChain filterChain)
        throws ServletException, java.io.IOException {

	
	String token=null;
	String username=null;
String authHeader=request.getHeader("Authorization");	
	
if(authHeader!=null && authHeader.startsWith("Bearer ")) {
	
	token=authHeader.substring(7);
	username=JWTtoken.ExtractUsername(token);

if(username!=null && SecurityContextHolder.getContext().getAuthentication()==null) {
	 
    UserDetails userDetails=load.loadUserByUsername(username);
    System.out.println("Username: " + username);
    System.out.println("Auth header: " + authHeader);
    System.out.println("Is token valid: " + JWTtoken.validateToken(token, userDetails));
    
    if(JWTtoken.validateToken(token,userDetails)) {
    	UsernamePasswordAuthenticationToken authtoken=new UsernamePasswordAuthenticationToken(userDetails,null, userDetails.getAuthorities());
    	authtoken.setDetails(
                new WebAuthenticationDetailsSource().buildDetails(request));

        SecurityContextHolder.getContext().setAuthentication(authtoken);
    }
}
}
// 3️⃣ Continue filter chain
filterChain.doFilter(request, response);

    }
}
	


	



