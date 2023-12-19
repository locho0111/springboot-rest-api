package com.rick.springbootrestapi.controller;

import org.springframework.web.bind.annotation.RestController;

import com.rick.springbootrestapi.bean.Student;

import jakarta.websocket.server.PathParam;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/students")
public class StudentController {

    @GetMapping("/student")
    public Student getStudent() {
        Student student = new Student("Rick", "Ho", 1);

        return student;
    }

    @GetMapping()
    public List<Student> getStudents() {
        List<Student> students = new ArrayList<>();
        students.add(new Student("Rick", "Ho", 1));
        students.add(new Student("Rick", "Ho", 2));
        students.add(new Student("Rick", "Ho", 3));

        return students;
    }

    @GetMapping("/{id}/{first-name}/{last-name}")
    // public Student studentPathVariable(@PathVariable("id") int studentId) {
    public Student studentPathVariable(@PathVariable int id, @PathVariable("first-name") String firstName,
            @PathVariable("last-name") String lastName) {
        return new Student(firstName, lastName, id);
    }

    // REST API with request parameter
    // localhost:8080/students/query?id=1
    @GetMapping("/query")
    public Student studentRequestVriable(@RequestParam("id") int studentId, @RequestParam String firstName,
            @RequestParam String lastName) {
        return new Student(firstName, lastName, studentId);

    }

    // handle HTTP POST request
    // @PostMapping and @RequestBody

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public Student createStudent(@RequestBody Student student) {
        System.out.println(student);
        return student;
    }

    @PutMapping("/{id}")
    public Student updateStudent(@PathVariable int id, @RequestBody Student student) {
        System.out.println(student.getFirstName());
        System.out.println(student.getLastName());
        return student;
    }

    @DeleteMapping("/{id}")
    public Student deleteStudent(@PathVariable int id) {
        return new Student(null, null, id);
    }
}
