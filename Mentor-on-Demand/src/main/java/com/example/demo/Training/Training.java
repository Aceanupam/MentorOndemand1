package com.example.demo.Training;



import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.example.demo.Mentor.Mentor;
import com.example.demo.Payment.Payment;
import com.example.demo.Skills.Skill;
import com.example.demo.Technology.Technology;
import com.example.demo.User.User;
import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="training")
public class Training {

	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int trainingId;
	@Column
	private int progress;
	@Column
	private int CommissionAmount;
	@Column
	private int rating;
	@Column
	private int avgrating;
	@JsonFormat(pattern="yyyy-MM-dd")
	@Column
	private Date startDate;
	@JsonFormat(pattern="yyyy-MM-dd")
	@Column
	private Date endDate;
	
	@JsonFormat(pattern="HH:mm:ss")
	@Column
	private String startTime;
	@JsonFormat(pattern="HH:mm:ss")
	@Column
	private String endTime;
	@Column
	private String amtReceived;
	
	

	
	
	
	
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="mentor_Id")
	private Mentor mentor;
	

	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "training_skill", joinColumns = { 
			@JoinColumn(name = "training_Id", nullable = false, updatable = false) }, 
			inverseJoinColumns = { @JoinColumn(name = "skill_Id", 
					nullable = false, updatable = false) })
	private List<Skill> skill;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="technology_Id")
	private Technology technology;

	
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "training_payment", joinColumns = { 
			@JoinColumn(name = "training_Id", nullable = false, updatable = false) }, 
			inverseJoinColumns = { @JoinColumn(name = "payment_Id", 
					nullable = false, updatable = false) })
	private List<Payment> payment=new ArrayList<Payment>();
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "training_user", joinColumns = { 
			@JoinColumn(name = "training_Id", nullable = false, updatable = false) }, 
			inverseJoinColumns = { @JoinColumn(name = "user_Id", 
					nullable = false, updatable = false) })
	private List<User> user=new ArrayList<User>();
	

	
	public Mentor getMentor() {
		return mentor;
	}
	public void setMentor(Mentor mentor) {
		this.mentor = mentor;
	}
	public List<Skill> getSkill() {
		return skill;
	}
	public void setSkill(List<Skill> skill) {
		this.skill = skill;
	}
	public Technology getTechnology() {
		return technology;
	}
	public void setTechnology(Technology technology) {
		this.technology = technology;
	}
	public List<Payment> getPayment() {
		return payment;
	}
	public void setPayment(List<Payment> payment) {
		this.payment = payment;
	}
	public List<User> getUser() {
		return user;
	}
	public void setUser(List<User> user) {
		this.user = user;
	}
	public int getTrainingId() {
		return trainingId;
	}
	public void setTrainingId(int trainingId) {
		this.trainingId = trainingId;
	}
	public int getProgress() {
		return progress;
	}
	public void setProgress(int progress) {
		this.progress = progress;
	}
	public int getCommissionAmount() {
		return CommissionAmount;
	}
	public void setCommissionAmount(int commissionAmount) {
		this.CommissionAmount = commissionAmount;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public int getAvgrating() {
		return avgrating;
	}
	public void setAvgrating(int avgrating) {
		this.avgrating = avgrating;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	public String getAmtReceived() {
		return amtReceived;
	}
	public void setAmtReceived(String amtReceived) {
		this.amtReceived = amtReceived;
	}
	
	public Training() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Training(int trainingId, int progress, int commissionAmount, int rating, int avgrating, Date startDate,
			Date endDate, String startTime, String endTime, String amtReceived, int mentorId) {
		super();
		this.trainingId = trainingId;
		this.progress = progress;
		this.CommissionAmount = commissionAmount;
		this.rating = rating;
		this.avgrating = avgrating;
		this.startDate = startDate;
		this.endDate = endDate;
		this.startTime = startTime;
		this.endTime = endTime;
		this.amtReceived = amtReceived;
		
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	
	@Override
	public String toString() {
		return "Training [trainingId=" + trainingId + ", progress=" + progress + ", CommissionAmount="
				+ CommissionAmount + ", rating=" + rating + ", avgrating=" + avgrating + ", startDate=" + startDate
				+ ", endDate=" + endDate + ", startTime=" + startTime + ", endTime=" + endTime + ", amtReceived="
				+ amtReceived + "]";
	}
}
