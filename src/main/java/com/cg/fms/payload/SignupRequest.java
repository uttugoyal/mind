package com.cg.fms.payload;

import java.util.Set;

import javax.validation.constraints.*;
 
public class SignupRequest {
    @NotBlank
    @Size(min = 3, max = 20)
    private String username;
 
    @NotBlank
    @Size(max = 50)
    @Email
    private String email;
    
    @NotBlank
    @Size(max = 50)
    private String fullName;
    
    @NotBlank
    @Size(max = 10)
    private String gender;
    
    @NotBlank
    @Size(max = 10)
    private String mobile;
    
    private Set<String> role;
    
    @NotBlank
    @Size(min = 6, max = 40)
    private String password;
    
    
  
    public SignupRequest() {
		super();
	}

	public SignupRequest(@NotBlank @Size(min = 3, max = 20) String username,
			@NotBlank @Size(max = 50) @Email String email, @NotBlank @Size(max = 50) String fullName,
			@NotBlank @Size(max = 10) String gender, @NotBlank @Size(max = 10) String mobile, Set<String> role,
			@NotBlank @Size(min = 6, max = 40) String password) {
		super();
		this.username = username;
		this.email = email;
		this.fullName = fullName;
		this.gender = gender;
		this.mobile = mobile;
		this.role = role;
		this.password = password;
	}

	public String getUsername() {
        return username;
    }
 
    public void setUsername(String username) {
        this.username = username;
    }
 
    public String getEmail() {
        return email;
    }
 
    public void setEmail(String email) {
        this.email = email;
    }
 
    public String getPassword() {
        return password;
    }
 
    public void setPassword(String password) {
        this.password = password;
    }
    
    public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public Set<String> getRole() {
      return this.role;
    }
    
    public void setRole(Set<String> role) {
      this.role = role;
    }
}
