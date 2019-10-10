package com.example.demo.Training;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Mentor.Mentor;
import com.example.demo.Mentor.MentorService;
import com.example.demo.Skills.Skill;
import com.example.demo.Skills.SkillService;
import com.example.demo.Technology.Technology;
import com.example.demo.Technology.TechnologyService;

@RestController
@RequestMapping({ "/training" })
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
public class TrainingController {

	@Autowired
	private TrainingServiceImpl trainingService;

	@Autowired
	private MentorService mentorService;

	@Autowired
	private TechnologyService technologyService;

	@Autowired
	private SkillService skillService;

	@PostMapping
	public Training create(@RequestBody Training training) {
		List<Skill> skillsList = new ArrayList<Skill>();
		Mentor mentor = mentorService.findById(training.getMentor().getMentorId());
		training.setMentor(mentor);
		Technology technology = technologyService.findById(training.getTechnology().getTechnologyId());
		System.out.println(training.getCommissionAmount());
		training.setTechnology(technology);

		for (Skill skill : training.getSkill()) {
			skillsList.add(skillService.findById(skill.getSkillId()));
		}
		training.setSkill(skillsList);

		return trainingService.create(training);
	}

	@GetMapping(path = { "/{trainingId}" })
	public Training findOne(@PathVariable("trainingId") int trainingId) {
		return trainingService.findById(trainingId);
	}

	
	/*@GetMapping(path = { "/{startDate}/{endDate}" })
	 * public List<Training>
	 * findOne(@PathVariable("startDate") @DateTimeFormat(pattern="YYYY-MM-DD") Date
	 * startDate,@PathVariable("endDate")@DateTimeFormat(pattern="YYYY-MM-DD") Date
	 * endDate) {
	 * 
	 * 
	 * SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy:MM:dd"); Date
	 * startDate1; try { startDate1 = simpleDateFormat.parse(startDate); } catch
	 * (ParseException e) { startDate1=new Date(); // TODO Auto-generated catch
	 * block e.printStackTrace(); } Date endDate1; try { endDate1 =
	 * simpleDateFormat.parse(endDate); } catch (ParseException e) { endDate1=new
	 * Date(); // TODO Auto-generated catch block e.printStackTrace(); }
	 * 
	 * 
	 * 
	 * return trainingService.findByStartDateAndEndDate(startDate,endDate); }
	 */

	@PutMapping(path = { "/{trainingId}" })
	public Training update(@PathVariable("trainingId") int trainingId, @RequestBody Training training) {
		training.setTrainingId(trainingId);
		return trainingService.update(training);

	}

	@DeleteMapping(path = { "/{trainingId}" })
	public Training delete(@PathVariable("trainingId") int trainingId) {
		return trainingService.delete(trainingId);
	}

	@GetMapping
	public List<Training> findAll() {
		return trainingService.findAll();
	}

	@GetMapping("/findTrainingByMentorId/{mentorId}")
	public List<Training> getCoursesByMentor(@PathVariable(value = "mentorId") Integer mentorId) {
		return trainingService.findTrainingByMentormentorId(mentorId);
	}

	@GetMapping("/findByTrainingIdAndMentorId/{trainingId}/{mentorId}")
	public Training findByTrainingIdAndMentorId(@PathVariable(value = "trainingId") Integer trainingId,
			@PathVariable(value = "mentorId") Integer mentorId) {
		System.out.println(trainingService.findByTrainingIdAndMentorId(trainingId, mentorId));

		return trainingService.findByTrainingIdAndMentorId(trainingId, mentorId);
	}

	@GetMapping("/findTrainingByUserId/{userId}")
	public List<Training> getTrainingByUsers(@PathVariable(value = "userId") Integer usersId) {
		System.out.println(usersId);
		return trainingService.findTrainingByUserUserId(usersId);

	}

	@GetMapping(path = { "/findByStartDateBetween/{startDate}/{endDate}" })
	public List<Training> findBystartDateBetween(
			@PathVariable(value = "startDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date startDate,
			@PathVariable(value = "endDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date endDate) {
		System.out.println(trainingService.findByStartDateAndEndDate(startDate, endDate));
		return trainingService.findByStartDateAndEndDate(startDate, endDate);
	}

}
