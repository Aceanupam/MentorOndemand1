package com.example.demo.Skills;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.example.demo.Training.Training;

@Entity
@Table(name="skill")
public class Skill {

	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int skillId;
	@Column
	private String skillName;
	@Column
	private String toc;
	@Column
	private String prerequisites;
	
	/*
	 * @ManyToMany(fetch = FetchType.LAZY, mappedBy="skill") List<Training>
	 * training;
	 */
	
	
	public Skill(int skillId, String skillName, String toc, String prerequisites) {
		super();
		this.skillId = skillId;
		this.skillName = skillName;
		this.toc = toc;
		this.prerequisites = prerequisites;
	}
	public Skill() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getSkillId() {
		return skillId;
	}
	public void setSkillId(int skillId) {
		this.skillId = skillId;
	}
	public String getSkillName() {
		return skillName;
	}
	public void setSkillName(String skillName) {
		this.skillName = skillName;
	}
	public String getToc() {
		return toc;
	}
	public void setToc(String toc) {
		this.toc = toc;
	}
	public String getPrerequisites() {
		return prerequisites;
	}
	public void setPrerequisites(String prerequisites) {
		this.prerequisites = prerequisites;
	}
	
}
