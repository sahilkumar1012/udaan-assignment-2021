package org.codejudge.sb.service;

import lombok.extern.slf4j.Slf4j;
import org.codejudge.sb.model.Quiz;
import org.codejudge.sb.repository.QuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class QuizService {

    @Autowired
    QuizRepository quizRepository;


    public Quiz createQuiz(Quiz quiz) {
        log.info("create Quiz" + quiz);
        return quizRepository.save(quiz);
    }

    public Quiz get(Integer id) {
        Optional<Quiz> optional = quizRepository.findById(id);
        if(optional.isPresent())
            return optional.get();
        return null;
    }

}
