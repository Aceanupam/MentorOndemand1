package com.example.demo.Training;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

public interface TrainingRepository extends Repository<Training,Integer>{
	
	@Query("select training from Training training where training.mentor.mentorId=?")
	List<Training> findTrainingByMentormentorId(Integer mentorId);
	
	
	List<Training> findTrainingByUserUserId(Integer userId);
	 
	
	
	/*
	 * Training findByTrainingIdAndUseruserId(Integer trainingId,Integer userId);
	 */	
	void delete(Training training);
	
	List<Training> findAll();
	
	Training findOne(int trainingId);
	
	Training save(Training training);

	@Query("select training from Training training where training.mentor.mentorId=?")
	List<Training> findTrainingByMentorId(Integer mentorId);
	
	@Query("select training from Training training where training.trainingId=? and training.mentor.mentorId=?")
	Training findByTrainingIdAndMentorId(Integer trainingId, Integer mentorId);
	
	@Query("select training from Training training where training.startDate between ? and ?")
	List<Training> findByStartDateAndEndDate(Date startDate1,Date endDate1);
}
