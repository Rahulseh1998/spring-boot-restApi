package com.demo.springboot.finaltest.repo;

import com.demo.springboot.finaltest.model.Course;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CourseRepo extends CrudRepository<Course,Integer> {

}
