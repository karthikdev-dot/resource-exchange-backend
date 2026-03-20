package bookstore.JWT;

import java.util.Date;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import javax.crypto.spec.SecretKeySpec;
import javax.crypto.SecretKey;


@Component
public class JWTgenerator {
 
	private final String secret="hellomynameis@karthiktodayimdoingprojecton123loginauthentication&*(@";//should be 256 bits 1char=8bits//
	
	private final SignatureAlgorithm signatureAlgorithm=SignatureAlgorithm.HS256;//signing the token with proper signature algorithm//
	
    byte[] secretBytes=secret.getBytes();//should convert the string into bytes//
    
    private final SecretKey key=new SecretKeySpec(secretBytes, signatureAlgorithm.getJcaName());//those bytes & signature algorithm shift into secret key object for cryptography algorithm// 
    
    private final Long accessTokenExpiration=15*60*1000L;// expiration time is 15min//
    
    private final Long refreshTokenExpiration=1000L*60*60*24*7;//expiration time is 7 days or 30days//

public String generateaccesstoken(String username) {
	return generateaccessToken( username, accessTokenExpiration);
}                                                            
public String generateRefreshtoken(String username) {
	return generateRefreshToken(username,refreshTokenExpiration);
}
		
	
	
	public  String generateaccessToken(String username,Long id){
		
		return Jwts.builder()
				.setExpiration(new Date(System.currentTimeMillis()+accessTokenExpiration))
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .claim("id",id)
                .claim("role","USER")
                .signWith(key)
                .setSubject(username)
                .compact();
	 
	
	}
	public String generateRefreshToken(String username,Long id) {
		return Jwts.builder()
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis()+refreshTokenExpiration))
				.claim("id", id)
				.signWith(key)
				.setSubject(username)
				.compact();
	}
	
	public String ExtractUsername(String tokens) {
	
              return Jwts.parserBuilder()
            		  .setSigningKey(key)
            		  .build()
            		  .parseClaimsJws(tokens)
            		  .getBody()
            		  .getSubject();
	}
	
	
	public boolean validateToken(String token, UserDetails userDetails) {
	    final String username = ExtractUsername(token);
	    return username.equals(userDetails.getUsername()) && !isTokenExpired(token);
	}
	private boolean isTokenExpired(String token) {
		
		return false;
	}

}
