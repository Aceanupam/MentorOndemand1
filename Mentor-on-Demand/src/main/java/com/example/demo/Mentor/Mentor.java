package com.example.demo.Mentor;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.example.demo.Training.Training;

@Entity
@Table(name="mentor")
public class Mentor {

	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int mentorId;
	@Column
	private String userName;
	@Column
	private String password;
	@Column
	private String Name;
	@Column
	private String email;
	@Column
	private int yearsOfExperience;
	@Column
	private String linkedInUrl;
	@Column
	private String timeZone;
	@Column
	private String ratings;
	@Column
	private String mentorProfile;
	@Column
	private Boolean active;
	
	

	/*
	 * @OneToMany(fetch = FetchType.LAZY, mappedBy="mentor") List<Training>
	 * training;
	 */
	
	
	public int getMentorId() {
		return mentorId;
	}
	public Mentor(Boolean active) {
		super();
		this.active = active;
	}
	public Boolean getActive() {
		return active;
	}
	public void setActive(Boolean active) {
		this.active = active;
	}
	public void setMentorId(int mentorId) {
		this.mentorId = mentorId;
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
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getYearsOfExperience() {
		return yearsOfExperience;
	}
	public void setYearsOfExperience(int yearsOfExperience) {
		this.yearsOfExperience = yearsOfExperience;
	}
	public String getLinkedInUrl() {
		return linkedInUrl;
	}
	public void setLinkedInUrl(String linkedInUrl) {
		this.linkedInUrl = linkedInUrl;
	}
	public String getTimeZone() {
		return timeZone;
	}
	public void setTimeZone(String timeZone) {
		this.timeZone = timeZone;
	}
	public String getRatings() {
		return ratings;
	}
	public void setRatings(String ratings) {
		this.ratings = ratings;
	}
	public String getMentorProfile() {
		return mentorProfile;
	}
	public void setMentorProfile(String mentorProfile) {
		this.mentorProfile = mentorProfile;
	}
	public Mentor() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Mentor(int mentorId, String userName, String name, String email, int yearsOfExperience, String linkedInUrl,
			String timeZone, String ratings, String mentorProfile) {
		super();
		this.mentorId = mentorId;
		this.userName = userName;
		Name = name;
		this.email = email;
		this.yearsOfExperience = yearsOfExperience;
		this.linkedInUrl = linkedInUrl;
		this.timeZone = timeZone;
		this.ratings = ratings;
		this.mentorProfile = mentorProfile;
	}
}
