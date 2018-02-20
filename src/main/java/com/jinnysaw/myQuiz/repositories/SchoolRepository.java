/**
 * 
 */
package com.jinnysaw.myQuiz.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jinnysaw.myQuiz.models.School;

/**
 * @author jinnysaw
 *
 */
@Repository
public interface SchoolRepository extends CrudRepository<School,Long>{
 
}
