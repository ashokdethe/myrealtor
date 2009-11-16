package com.myrealtor.domain.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;

import org.springframework.validation.Errors;



@Entity
//@Table(name="Users")
@Table(uniqueConstraints = @UniqueConstraint(columnNames = { "username" }))
public class User extends BaseEntity {
	
	public static final String ROLE_USER = "ROLE_USER";
	public static final String ROLE_PROVIDER = "ROLE_PROVIDER";

	private static final long serialVersionUID = 1L;
	
	@Column(nullable = false)
	protected String username;
	protected String firstName, lastName, phone, email, password;
	protected String role = ROLE_USER;
	
	
	protected short enabled = 1;

	
	@ManyToOne
	protected SecurityQuestion question;
	
	protected String securityAnswer;
	
	@ManyToOne
	protected Apartment myHome;

	
	
	@Transient
	protected String confirmPwd;
	
	
//	public Address getAddress() {		
//		return address;
//	}
//
//	public void setAddress(Address address) {
//		this.address = address;
//	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
//		authority.setUsername( username );
	}

		public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

//	public String getAddress1() {
//		return address1;
//	}
//
//	public void setAddress1(String address1) {
//		this.address1 = address1;
//	}
//
//	public String getAddress2() {
//		return address2;
//	}
//
//	public void setAddress2(String address2) {
//		this.address2 = address2;
//	}
//
//	public String getCity() {
//		return city;
//	}
//
//	public void setCity(String city) {
//		this.city = city;
//	}
//
//	public String getState() {
//		return state;
//	}
//
//	public void setState(String state) {
//		this.state = state;
//	}
//
//	public String getZip() {
//		return zip;
//	}
//
//	public void setZip(String zip) {
//		this.zip = zip;
//	}

	/**
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * @param phone
	 *            the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email
	 *            the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}	
	

	public SecurityQuestion getQuestion() {
		return question;
	}

	public void setQuestion(SecurityQuestion question) {
		this.question = question;
	}

	public String getSecurityAnswer() {
		return securityAnswer;
	}

	public void setSecurityAnswer(String securityAnswer) {
		this.securityAnswer = securityAnswer;
	}

	public short getEnabled() {
		return enabled;
	}

	public void setEnabled(short enabled) {
		this.enabled = enabled;
	}

	/**
	 * @return the confirmPwd
	 */
	public String getConfirmPwd() {
		return confirmPwd;
	}	
	


	/**
	 * @param confirmPwd
	 *            the confirmPwd to set
	 */
	public void setConfirmPwd(String confirmPwd) {
		this.confirmPwd = confirmPwd;
	}
	
	
	
	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Apartment getMyHome() {
		return myHome;
	}

	public void setMyHome(Apartment myHome) {
		this.myHome = myHome;
	}

	public void validateUserForm(Errors errors) {		
		validatePassword(errors); 		
		if (lastName.length() < 2) {
			errors.rejectValue("lastName", "", "Last name needs to be greater than 1 character!");			
		}
		boolean isAlpha = true;
		for (int i = 0; i < username.length(); i++) {
			if (! Character.isLetterOrDigit( username.charAt( i ) )  ) {
				isAlpha = false;
				break;
			}
		}
		
		if ( ! isAlpha ) {
			errors.rejectValue("username", "", "Username can only have letter and/or digit!");
		}
		
	}

	public void validatePassword(Errors errors) {
		//test
		if ( password == null || confirmPwd == null ) {
			errors.rejectValue("password", "", "Password or Confirm Password cannot be null!");			
		} else if (! password.equals(confirmPwd)) {			
			errors.rejectValue("password", "", "Password does not match!");			
		}
	}
	
	
	@Transient
	public String[] getRoleArray() {
		return new String[] {ROLE_USER, ROLE_PROVIDER};
	}
	
	
	public static User createUser(String roleStr) {
		User ret = new User();
		if (ROLE_PROVIDER.equalsIgnoreCase( roleStr )) {
			ret = new Provider();
		}
		return ret;
	}

	
	
}
