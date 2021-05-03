package org.codejudge.sb.controller;

import io.swagger.annotations.ApiOperation;
import org.codejudge.sb.model.FailureResponse;
import org.codejudge.sb.model.Quiz;
import org.codejudge.sb.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.xml.ws.Response;


@RestController
@RequestMapping
public class QuizController {

    @Autowired
    QuizService quizService;

    @PostMapping("/api/quiz/")
    public ResponseEntity createQuiz(@RequestBody Quiz quiz){
        Quiz createdQuiz = quizService.createQuiz(quiz);
        if(createdQuiz!=null){
            return new ResponseEntity<Quiz>(createdQuiz, HttpStatus.CREATED);
        }
        FailureResponse failureResponse = new FailureResponse("failure", "unable to create object");
        return new ResponseEntity<FailureResponse>(failureResponse,HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/api/quiz/{quiz_id}")
    public ResponseEntity getQuiz(@PathVariable("quiz_id") Integer id){
        try {
            Quiz requestedQuiz = quizService.get(id);
            if (requestedQuiz != null) {
                return new ResponseEntity<Quiz>(requestedQuiz, HttpStatus.OK);
            } else {
                return new ResponseEntity<String>("{}",HttpStatus.NOT_FOUND);
            }
        }catch (Exception e){
            e.printStackTrace();
            FailureResponse failureResponse = new FailureResponse("failure", "unable to create object");
            return new ResponseEntity<FailureResponse>(failureResponse, HttpStatus.BAD_REQUEST);
        }
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
