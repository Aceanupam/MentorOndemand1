package com.example.demo.Payment;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.example.demo.Mentor.Mentor;
import com.example.demo.Training.Training;
import com.example.demo.User.User;

@Entity
@Table(name="payment")
public class Payment {

	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int paymentId;
	@Column
	private String txtType;
	@Column
	private String Amount;
	@Column
	private String remarks;
	@Column
	private int mentorID;
	
	@Column
	private String mentorName;
	@Column
	private int trainingId;
	@Column
	private String skillName;
	@Column
	private int totalAmountToMentor;
	
	@Column
	private int userId;
	
	public Payment() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public Payment(int paymentId, String txtType, String amount, String remarks, int mentorID, String mentorName,
			int trainingId, String skillName, int totalAmountToMentor) {
		super();
		this.paymentId = paymentId;
		this.txtType = txtType;
		Amount = amount;
		this.remarks = remarks;
		this.mentorID = mentorID;
		this.mentorName = mentorName;
		this.trainingId = trainingId;
		this.skillName = skillName;
		this.totalAmountToMentor = totalAmountToMentor;
	}
	
	public int getUserId() {
		return userId;
	}


	public void setUserId(int userId) {
		this.userId = userId;
	}


	public Payment(int userId) {
		super();
		this.userId = userId;
	}


	public int getPaymentId() {
		return paymentId;
	}
	public void setPaymentId(int paymentId) {
		this.paymentId = paymentId;
	}
	public String getTxtType() {
		return txtType;
	}
	public void setTxtType(String txtType) {
		this.txtType = txtType;
	}
	public String getAmount() {
		return Amount;
	}
	public void setAmount(String amount) {
		Amount = amount;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public int getMentorID() {
		return mentorID;
	}
	public void setMentorID(int mentorID) {
		this.mentorID = mentorID;
	}
	public String getMentorName() {
		return mentorName;
	}
	public void setMentorName(String mentorName) {
		this.mentorName = mentorName;
	}
	public int getTrainingId() {
		return trainingId;
	}
	public void setTrainingId(int trainingId) {
		this.trainingId = trainingId;
	}
	public String getSkillName() {
		return skillName;
	}
	public void setSkillName(String skillName) {
		this.skillName = skillName;
	}
	public int getTotalAmountToMentor() {
		return totalAmountToMentor;
	}
	public void setTotalAmountToMentor(int totalAmountToMentor) {
		this.totalAmountToMentor = totalAmountToMentor;
	}
	
}
