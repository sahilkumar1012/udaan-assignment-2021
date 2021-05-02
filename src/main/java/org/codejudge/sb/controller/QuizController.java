package org.codejudge.sb.controller;

import io.swagger.annotations.ApiOperation;
import org.codejudge.sb.model.Quiz;
import org.codejudge.sb.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping
public class QuizController {

    @Autowired
    QuizService quizService;

    @PostMapping("/api/quiz/")
    public Quiz createQuiz(@RequestBody Quiz quiz){
        quizService.createQuiz(quiz);
        return quiz;
    }

    @GetMapping("/api/quiz/{quiz_id}")
    public Quiz getQuiz(@PathVariable("quiz_id") Integer id){
        return quizService.get(id);
    }


/*
    @PostMapping("/api/questions/")
    public Question createQuestion(@RequestBody Question question){
        questionService.save(question);
        return question;
    }
    @GetMapping("/api/questions/{question_id}")
    public Question getQuestion(@PathVariable("question_id") Integer id){
        log.info("Inside Get Question with ID: "+ id);
        return questionService.get(id);
    }
    @GetMapping("/api/quiz-questions/{quiz_id}")
    public QuizQuestionsResponse getAllQuestions(@PathVariable("quiz_id") Integer id){
        log.info("Inside getAllQuestions with ID"+ id);
        Quiz tempQuiz= quizService.get(id);
        QuizQuestionsResponse quizQuestionsResponse = new QuizQuestionsResponse();
        quizQuestionsResponse.setName(tempQuiz.getName());
        quizQuestionsResponse.setDescription(tempQuiz.getDescription());
        List<Question> questionList = questionService.getQuestionByQuiz(id);
        quizQuestionsResponse.setQuestions(questionList);
        return quizQuestionsResponse;
    }

*/

}
