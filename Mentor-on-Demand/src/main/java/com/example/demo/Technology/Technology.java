package com.example.demo.Technology;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.example.demo.Training.Training;

@Entity
@Table(name="technology")
public class Technology {

	@Override
	public String toString() {
		return "Technology [technologyId=" + technologyId + ", techName=" + techName + ", description=" + description
				+ "]";
	}
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int technologyId;
	@Column
	private String techName;
	@Column
	private String description;
	

	/*
	 * @OneToMany(fetch = FetchType.LAZY, mappedBy="technology") List<Training>
	 * training;
	 */
	
	public Technology(int technologyId, String techName, String description) {
		super();
		this.technologyId = technologyId;
		this.techName = techName;
		this.description = description;
	}
	public Technology() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getTechnologyId() {
		return technologyId;
	}
	public void setTechnologyId(int technologyId) {
		this.technologyId = technologyId;
	}
	public String getTechName() {
		return techName;
	}
	public void setTechName(String techName) {
		this.techName = techName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
}
