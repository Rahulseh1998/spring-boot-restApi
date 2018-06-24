package com.demo.springboot.finaltest.service;

import com.demo.springboot.finaltest.model.Course;
import com.demo.springboot.finaltest.repo.CourseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CourseService {

    @Autowired
    CourseRepo courseRepo;

    public CourseService() {
//        courses = new ArrayList<>();
//        courses.add(new Course(1,"Computer","Some electronics stuff will be studied by you which u will never gonna use in life",6));
//        courses.add(new Course(2,"sanskirit","some sanskirit sloka",12));
//        courses.add(new Course(3,"IT","It description here...",2));
    }


    public List<Course> getAllCourses() {
        List<Course> courses = new ArrayList<>();
        courseRepo.findAll().forEach(courses::add);
        return courses;
    }

    public Course getCourseByid(int id) {
        Optional<Course> byId = courseRepo.findById(id);
        return byId.orElse(null);
    }


    public boolean add(Course course) {
         courseRepo.save(course);
         return true;
    }

    public boolean update(Course course, int id) {

       courseRepo.save(course);
       return true;
    }

    public boolean del(int id) {
        courseRepo.deleteById(id);
        return true;
    }
}
