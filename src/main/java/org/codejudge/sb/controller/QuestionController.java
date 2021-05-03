package org.codejudge.sb.controller;

import lombok.extern.slf4j.Slf4j;
import org.codejudge.sb.model.FailureResponse;
import org.codejudge.sb.model.Question;
import org.codejudge.sb.model.Quiz;
import org.codejudge.sb.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
@Slf4j
public class QuestionController {

    @Autowired
    QuestionService questionService;


    @PostMapping("/api/questions/")
    public ResponseEntity createQuestion(@RequestBody Question question){
        if(!validQuestionInput(question)){
            FailureResponse failureResponse = new FailureResponse("failure", "unable to create object");
            return new ResponseEntity<FailureResponse>(failureResponse,HttpStatus.BAD_REQUEST);
        }

        Question createdQuestion = questionService.save(question);
        return new ResponseEntity<Question>(createdQuestion, HttpStatus.CREATED);
    }

    private boolean validQuestionInput(Question q) {
        if( valid(q.getName()) && valid(q.getOptions()) && validInteger(q.getCorrect_option()) && validInteger(q.getQuiz()) && validInteger(q.getPoints()) ){
            return true;
        }
        return false;
    }

    private boolean validInteger(Integer i) {
        try{
            Integer.valueOf(i);
        }catch (Exception ex){
            return false;
        }
        return true;
    }

    private boolean valid(String string) {
        return string!=null && !string.isEmpty();
    }



    @GetMapping("/api/questions/{question_id}")
    public ResponseEntity getQuestion(@PathVariable("question_id") Object id){
        Integer qId=null;
        try{
            qId = Integer.parseInt(id.toString());
        }catch(Exception ex){
            FailureResponse failureResponse = new FailureResponse("failure", "invalid inputs");
            new ResponseEntity<FailureResponse>(failureResponse, HttpStatus.BAD_REQUEST);
        }

        log.info("Inside Get Question with ID: "+ qId);
        Question ques =  questionService.get(qId);

        if(ques==null){
            return new ResponseEntity("{}", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Question>(ques,HttpStatus.CREATED);
    }


}
