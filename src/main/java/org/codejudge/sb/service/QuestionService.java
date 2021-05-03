package org.codejudge.sb.service;
import org.codejudge.sb.model.Question;
import org.codejudge.sb.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class QuestionService {
    @Autowired
    QuestionRepository questionRepository;

    public Question save(Question question) {
        return questionRepository.save(question);
    }

    public Question get(Integer id) {
        Optional<Question> q= questionRepository.findById(id);
        if(q.isPresent())
            return q.get();
        else
            return null;
    }

    public List<Question> getQuestionByQuiz(Integer id) {
        List<Question> qList=questionRepository.findAllByQuiz(id);
        return qList;
    }
}