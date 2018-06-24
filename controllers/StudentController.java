package com.demo.springboot.finaltest.controllers;


import com.demo.springboot.finaltest.model.Course;
import com.demo.springboot.finaltest.model.Student;
import com.demo.springboot.finaltest.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    StudentService studentService;


    @GetMapping("students")
    public List<Student> getAll(){
       return studentService.getAllStudent();
    }


    @GetMapping("student/{id}")
    public Student getbyId(@PathVariable int id){
        return studentService.getStudentbyID(id);
    }


    @PostMapping("student")
    public boolean add(@RequestBody Student s){
        return studentService.addStud(s);
    }

    @PutMapping("student/{id}")
    public boolean update(@PathVariable int id,@RequestBody Student s){
        return studentService.updateStud(s,id);
    }

    @DeleteMapping("student/{id}")
    public boolean delete(@PathVariable int id){
        return studentService.deleteStud(id);
    }


    //**********************************************************************************************************
    //    FOR COURSE RELATED MAPPING START HERE


    @GetMapping("student/{sid}/courses")
    public List<Course> getAllCourseofStudent(@PathVariable int sid){
       return studentService.getAllCoursesOfStudent(sid);
    }


    @GetMapping("student/{sid}/course/{cid}")
    public Course getCourseOfStudent(@PathVariable int cid ,@PathVariable int sid){
        return studentService.getCourseOfStudent(cid,sid);
    }

    @PostMapping("student/{sid}/course")
    public boolean addCourseToStud(@PathVariable int sid,@RequestBody Course c){
        return studentService.addCourseToStud(sid,c);
    }

    @PutMapping("student/{sid}/course/{cid}")
    public boolean addCourseToStud(@PathVariable int cid,@PathVariable int sid,@RequestBody Course c){
        return studentService.updateCourseofStud(sid,c,cid);
    }

    @DeleteMapping("student/{id}/course/{cid}")
    public boolean deleteCourseFromStudent(@PathVariable int id,@PathVariable int cid)
    {
        return studentService.deleteCourseFromStudent(id,cid);
    }






}
