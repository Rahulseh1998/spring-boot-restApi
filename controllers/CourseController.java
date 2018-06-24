package com.demo.springboot.finaltest.controllers;


import com.demo.springboot.finaltest.model.Course;
import com.demo.springboot.finaltest.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CourseController {


    @Autowired
    CourseService courseService;

    @GetMapping("courses")
    public List<Course> getAll(){
        return courseService.getAllCourses();
    }


    @GetMapping("course/{id}")
    public Course getAll(@PathVariable int id){
        return courseService.getCourseByid(id);
    }


    @PostMapping("course")
    public boolean add(@RequestBody Course course){
        return courseService.add(course);
    }

    @PutMapping("course/{id}")
    public boolean update(@PathVariable int id,@RequestBody Course course){
        return courseService.update(course,id);
    }

    @DeleteMapping("course/{id}")
    public boolean delete(@PathVariable int id){
        return courseService.del(id);
    }


















}
