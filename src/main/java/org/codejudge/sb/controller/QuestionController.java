package org.codejudge.sb.controller;

import lombok.extern.slf4j.Slf4j;
import org.codejudge.sb.model.Question;
import org.codejudge.sb.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
@Slf4j
public class QuestionController {

    @Autowired
    QuestionService questionService;


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
}
