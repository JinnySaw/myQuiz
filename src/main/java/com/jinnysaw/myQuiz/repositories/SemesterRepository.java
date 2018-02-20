/**
 * 
 */
package com.jinnysaw.myQuiz.repositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jinnysaw.myQuiz.models.Semester;

/**
 * @author jinnysaw
 * DateTime 2018Feb07 08:43 PM
 */
@Repository
public interface SemesterRepository extends CrudRepository<Semester,Long>{

}
