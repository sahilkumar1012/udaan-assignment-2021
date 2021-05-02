package org.codejudge.sb.model;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.util.List;
@Data
@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;
    String name;
    String options;
    Integer correct_option;
    //    @OneToOne
//    @JoinColumn(name = "quiz_id")
//    Quiz quiz;
    Integer quiz;
    Integer points;
}