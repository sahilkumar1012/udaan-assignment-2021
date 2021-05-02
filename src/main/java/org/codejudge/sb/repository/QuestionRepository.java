package org.codejudge.sb.repository;
import org.codejudge.sb.model.Question;
import org.springframework.data.repository.CrudRepository;
import java.util.List;


public interface QuestionRepository extends CrudRepository<Question,Integer> {
    List<Question> findAllByQuiz(Integer id);
}
