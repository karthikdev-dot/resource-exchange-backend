package bookstore.DTOs;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class registerRequest {

	
	
	
	private String username;
	
	@NotBlank(message = "firstname is requried")
	@Size(min = 6,message = "firstname must be 6 characters")
	private String firstname;
	
	
	private String middlename;
	
	private String role;

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getMiddlename() {
		return middlename;
	}

	public void setMiddlename(String middlename) {
		this.middlename = middlename;
	}
	
	
	@NotBlank(message = "lastname is requried")
	@Size(min = 6,message = "lastname must be 6 characters")
	private String lastname;

	@NotBlank(message = "password invalid")
	@Size(min = 6,message ="password must be atleast 6 characters")
	private String password;
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@NotBlank(message = "email is invalid")
	@Column(unique = true, nullable = false)
	@Email(message = "email must be correct formate")
	private String email;
	
	@Min(value = 18, message = "Age must be at least 18")
    @Max(value = 100, message = "Age must not exceed 100")
	private int age;

	

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	@Min(-90)
	@Max(90)
	@Column(nullable = true)
	private Double latitude;
	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}
	@Min(-90)
	@Max(90)
	@Column(nullable = true)
	private Double longitude;
	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	@NotBlank(message = "adress is required")
   private String address;

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
@Column(name="dateofbirth")
	private LocalDate dateofbirth;

public LocalDate getDateofbirth() {
	return dateofbirth;
}

public void setDateofbirth(LocalDate dateofbirth) {
	this.dateofbirth = dateofbirth;
}

@Column(name = "source")
private String source;

public String getSource() {
	return source;
}

public void setSource(String source) {
	this.source = source;
}
	
}
