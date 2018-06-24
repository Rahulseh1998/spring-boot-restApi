package com.demo.springboot.finaltest.service;


import com.demo.springboot.finaltest.model.Course;
import com.demo.springboot.finaltest.model.Location;
import com.demo.springboot.finaltest.model.Student;
import com.demo.springboot.finaltest.repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    StudentRepo studentRepo;
//    List<Student> students;

    public StudentService() {


//        studentRepo.save(new Student(100,"Aditi",20,new Location("Delhi","100","China")));

//        students.add(new Student(101,"Rahul",21,new Location("New York","98746","USA")));

    }


    public List<Student> getAllStudent() {
        List<Student> ans = new ArrayList<>();
        studentRepo.findAll().forEach(ans::add);
        return ans;
    }

    public Student getStudentbyID(int id) {

        Optional<Student> byId = studentRepo.findById(id);

        return byId.orElse(null);

    }

    public boolean addStud(Student s) {
        studentRepo.save(s);
        return true;
    }

    public boolean updateStud(Student s, int id) {

        studentRepo.deleteById(id);
       return addStud(s);

    }

    public boolean deleteStud(int id) {
        studentRepo.deleteById(id);
        return true;
    }

    //**************************************************************************************************
    // COURSE FUNCTION START HERE

    public List<Course> getAllCoursesOfStudent(int sid) {


        return studentRepo.findCoursesBysid);

    }

    public Course getCourseOfStudent(int cid, int sid) {
       return studentRepo.findCourseByCourseIdUsingStudentId(cid,sid);
    }


    public boolean addCourseToStud(int sid, Course c) {
        List<Course> st_course = getAllCoursesOfStudent(sid);
        if (st_course!=null)
            return st_course.add(c);
        return false;
    }


    public boolean updateCourseofStud(int sid, Course c, int cid) {
        List<Course> st_course = getAllCoursesOfStudent(sid);
        if (st_course==null) return false;
        for (Course ci:st_course){
            if (ci.getId()==cid) {
                st_course.add(c);
                st_course.remove(ci);
                return true;
            }
        }
        return false;
    }

    public boolean deleteCourseFromStudent(int id, int cid) {
        List<Course> st_course = getAllCoursesOfStudent(id);
        if (st_course==null) return false;
        for (Course c:st_course){
            if (c.getId()==cid) {
                st_course.remove(c);
                return true;
            }
        }
        return false;
    }
}
