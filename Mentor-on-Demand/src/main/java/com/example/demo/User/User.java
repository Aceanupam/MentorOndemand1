package com.example.demo.User;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.example.demo.Training.Training;
import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="user")
public class User {

	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userId;
	
	@Column
	private String firstName;
	@Column
	private String lastName;
	@Column
	private String userName;
	@Column
	private String password;
	@Column
	private String contactNumber;
	@Column
	private String email;
	@Column
	private String regCode;
	@Column
	private String role;
	@Column
	private String linkedInUrl;
	@Column
	private int yearsOfExperience;
	@Column
	private Boolean active;
	@Column
	private String confirmedSignUp;
	@Column
	private String resetPassword;
	@JsonFormat(pattern="YYYY:mm:dd")
	@Column
	private Date resetPasswordDate;
	
	/*
	 * @ManyToMany(fetch=FetchType.LAZY, mappedBy="user") List<Training> training;
	 */

	/*
	 * public int getPaymentId() { return paymentId; }
	 * 
	 * public void setPaymentId(int paymentId) { this.paymentId = paymentId; }
	 * 
	 * public User(int paymentId) { super(); this.paymentId = paymentId; }
	 */

	/*
	 * @OneToMany(fetch=FetchType.LAZY, cascade= CascadeType.ALL)
	 * 
	 * @JoinTable(name="user_payment" ,joinColumns= {
	 * 
	 * @JoinColumn(name="user_id" ,nullable=false,updatable=false)},
	 * inverseJoinCloumns=
	 * {@JoinColumn(name="payment_id",nullable=false,updatable=false)} )
	 */
	public User(int userId, String firstName, String lastName, String userName, String password, String contactNumber,
			String email, String regCode, String role, String linkedInUrl, int yearsOfExperience, Boolean active,
			String confirmedSignUp, String resetPassword, Date resetPasswordDate) {
		super();
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
		this.password = password;
		this.contactNumber = contactNumber;
		this.email = email;
		this.regCode = regCode;
		this.role = role;
		this.linkedInUrl = linkedInUrl;
		this.yearsOfExperience = yearsOfExperience;
		this.active = active;
		this.confirmedSignUp = confirmedSignUp;
		this.resetPassword = resetPassword;
		this.resetPasswordDate = resetPasswordDate;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}


	

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
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

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRegCode() {
		return regCode;
	}

	public void setRegCode(String regCode) {
		this.regCode = regCode;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getLinkedInUrl() {
		return linkedInUrl;
	}

	public void setLinkedInUrl(String linkedInUrl) {
		this.linkedInUrl = linkedInUrl;
	}

	public int getYearsOfExperience() {
		return yearsOfExperience;
	}

	public void setYearsOfExperience(int yearsOfExperience) {
		this.yearsOfExperience = yearsOfExperience;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public String getConfirmedSignUp() {
		return confirmedSignUp;
	}

	public void setConfirmedSignUp(String confirmedSignUp) {
		this.confirmedSignUp = confirmedSignUp;
	}

	public String getResetPassword() {
		return resetPassword;
	}

	public void setResetPassword(String resetPassword) {
		this.resetPassword = resetPassword;
	}

	public Date getResetPasswordDate() {
		return resetPasswordDate;
	}

	public void setResetPasswordDate(Date resetPasswordDate) {
		this.resetPasswordDate = resetPasswordDate;
	}
	
}
