package org.codejudge.sb.controller;

import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.codejudge.sb.model.Question;
import org.codejudge.sb.model.Quiz;
import org.codejudge.sb.model.QuizQuestionsResponse;
import org.codejudge.sb.service.QuestionService;
import org.codejudge.sb.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping
@Slf4j
public class AppController {

    @Autowired
    QuizService quizService;
    @Autowired
    QuestionService questionService;


    @ApiOperation("This is the hello world api")
    @GetMapping("/")
    public String hello() {
        return "Hello World!!";
    }

    @GetMapping("/api/quiz-questions/{quiz_id}")
    public QuizQuestionsResponse getAllQuestions(@PathVariable("quiz_id") Integer id){

        log.info("Inside getAllQuestions with ID"+ id);
        QuizQuestionsResponse quizQuestionsResponse = new QuizQuestionsResponse();
        Quiz tempQuiz= quizService.get(id);

        quizQuestionsResponse.setName(tempQuiz.getName());
        quizQuestionsResponse.setDescription(tempQuiz.getDescription());

        List<Question> questionList = questionService.getQuestionByQuiz(id);
        quizQuestionsResponse.setQuestions(questionList);
        return quizQuestionsResponse;
    }

}
