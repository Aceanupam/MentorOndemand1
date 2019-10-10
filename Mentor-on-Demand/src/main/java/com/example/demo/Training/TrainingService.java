package com.example.demo.Training;

import java.util.Date;
import java.util.List;

public interface TrainingService {

	List<Training> findTrainingByMentormentorId(Integer mentorId);

	
	List<Training> findTrainingByUserUserId(Integer UserId);
	 
	/*
	 * Training findByTrainingIdAndUseruserId(Integer trainingId,Integer userId);
	 */	
	Training create(Training training);
	Training delete(int trainingId);
	List<Training> findAll();
	Training findById(int trainingId);
	Training update(Training training);


	Training findByTrainingIdAndMentorId(Integer trainingId, Integer mentorId);


	List<Training> findByStartDateAndEndDate(Date startDate1, Date endDate1);
}
