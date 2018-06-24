package com.demo.springboot.finaltest.repo;

import com.demo.springboot.finaltest.model.Course;
import com.demo.springboot.finaltest.model.Student;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepo extends CrudRepository<Student,Integer> {

     List<Course> findCoursesById(int sid);

     @Query("courses where cid=?1 and sid =?2")
    Course findCourseByCourseIdUsingStudentId(int cid, int sid);



}
