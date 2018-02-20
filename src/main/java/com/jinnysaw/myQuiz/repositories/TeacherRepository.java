/**
 * 
 */
package com.jinnysaw.myQuiz.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jinnysaw.myQuiz.models.Teacher;

/**
 * @author jinnysaw
 *
 */
@Repository
public interface TeacherRepository extends CrudRepository<Teacher, Long>{ 
}
