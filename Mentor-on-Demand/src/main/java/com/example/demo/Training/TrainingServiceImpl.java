package com.example.demo.Training;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Mentor.MentorService;
import com.example.demo.Payment.Payment;
import com.example.demo.Skills.Skill;
import com.example.demo.Technology.TechnologyService;
@Service
public class TrainingServiceImpl implements TrainingService{

	@Autowired
	private TrainingRepository repository;
	@Autowired
	private MentorService mentorService;
	@Autowired
	private TechnologyService technologyService;
	
	@Override
	public Training create(Training training) {
		// TODO Auto-generated method stub
		return repository.save(training);
	}

	@Override
	public Training delete(int trainingId) {
		// TODO Auto-generated method stub
		List<Skill> skills=new ArrayList<Skill>();		
		List<Payment> payments=new ArrayList<Payment>();
		Training training=findById(trainingId);
		training.setMentor(mentorService.findById(training.getMentor().getMentorId()));
		training.setTechnology(technologyService.findById(training.getTechnology().getTechnologyId()));
		for(Skill skill:training.getSkill())
			{skills.add(skill);}
		training.setSkill(skills);
			
		for(Payment payment:training.getPayment())
			{payments.add(payment);}
		training.setPayment(payments);
		if(training != null) {
			repository.delete(training);
		}
		return training;
	}

	@Override
	public List<Training> findAll() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public Training findById(int trainingId) {
		// TODO Auto-generated method stub
		return repository.findOne(trainingId);
	}

	@Override
	public Training update(Training training) {
		// TODO Auto-generated method stub
		return repository.save(training);
	}

	@Override
	public List<Training> findTrainingByMentormentorId(Integer mentorId) {
		// TODO Auto-generated method stub
		return repository.findTrainingByMentormentorId(mentorId);
	}

	/*
	 * @Override public List<Training> findTrainingByUseruserId(Integer UserId) { //
	 * TODO Auto-generated method stub return
	 * repository.findTrainingByUseruserId(UserId); }
	 */


	@Override
	public List<Training> findByStartDateAndEndDate(Date startDate1, Date endDate1) {
		// TODO Auto-generated method stub
		return repository.findByStartDateAndEndDate(startDate1, endDate1);
	}

	@Override
	public Training findByTrainingIdAndMentorId(Integer trainingId, Integer mentorId) {
		// TODO Auto-generated method stub
		return repository.findByTrainingIdAndMentorId(trainingId, mentorId);
	}

	@Override
	public List<Training> findTrainingByUserUserId(Integer UserId) {
		// TODO Auto-generated method stub
		return repository.findTrainingByUserUserId(UserId);
	}

	/*
	 * @Override public Training findByTrainingIdAndUseruserId(Integer trainingId,
	 * Integer userId) { // TODO Auto-generated method stub return
	 * repository.findByTrainingIdAndUseruserId(trainingId, userId); }
	 */

}
