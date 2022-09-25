package org.springRestApp.Controller;

import java.net.URI;
import java.util.List;

import org.springRestApp.Model.Question;
import org.springRestApp.Service.SurveyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class SurveyController {

	@Autowired
	private SurveyService service;
	
	//@RequestMapping(value ="/Surveys/{SurveyId}/Questions", method = RequestMethod.GET)
	@GetMapping("/Surveys/{SurveyId}/Questions")
	public List<Question> retrieveQuestionsForSurvey(@PathVariable("SurveyId") String id)
	{
		return service.retrieveQuestions(id);
	}

	@PostMapping("/Surveys/{SurveyId}/Questions")
	public ResponseEntity<Void> addSurveyQuestion(@PathVariable String SurveyId,@RequestBody Question newQuestion)
	{
		Question quest =  service.addQuestion(SurveyId, newQuestion);
		if(quest == null)
			return ResponseEntity.noContent().build();
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(quest.getId()).toUri();
		return ResponseEntity.created(location).build();
	}

	@GetMapping("/Surveys/{SurveyId}/Questions/{QuestionId}")
	public Question retruiveSurveyQuestion(@PathVariable String SurveyId, @PathVariable String QuestionId)
	{
		return service.retrieveQuestion(SurveyId, QuestionId);
	}

	@PutMapping("/Surveys/{SurveyId}/Questions/{QuestionId}")
	public ResponseEntity<Question> updateSurveyQuestion(@PathVariable String SurveyId,
													 @PathVariable String QuestionId,
													 @RequestBody Question newQuestion)
	{
		Question quest =  service.retrieveQuestion(SurveyId, QuestionId);;
		if(quest == null)
			return ResponseEntity.noContent().build();
		quest.setCorrectAnswer(newQuestion.getCorrectAnswer());
		quest.setId(newQuestion.getId());
		quest.setOptions(newQuestion.getOptions());
		quest.setDescription(newQuestion.getDescription());
		//URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(quest.getId()).toUri();
		return ResponseEntity.ok(quest);
	}
}
