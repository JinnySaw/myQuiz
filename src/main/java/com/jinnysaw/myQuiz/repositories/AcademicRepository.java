/**
 * 
 */
package com.jinnysaw.myQuiz.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jinnysaw.myQuiz.models.AcademicYear;

/**
 * @author jinnysaw
 *
 */
@Repository
public interface AcademicRepository extends CrudRepository<AcademicYear,Long>{

}
