package com.project.Learning.Management.System.Repository;

import com.project.Learning.Management.System.Entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question, Long> {

}
