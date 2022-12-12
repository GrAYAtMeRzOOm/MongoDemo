package com.gray.mongodemo.controller;

import com.gray.mongodemo.model.Student;
import com.gray.mongodemo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * Created by IntelliJ IDEA Ultimate.
 * User: Pasindu Raveen
 * Date: 13-Dec-22
 * Time: 1:32 AM
 * MongoDemo
 */
@RestController
@RequestMapping("/mongo")
public class StudentController {
    @Autowired
    StudentService studentService;

    @PostMapping("/student")
    public ResponseEntity<Student> insertStudent(@RequestBody Student student) {
        if (!student.getEmail().equals("")) {
            studentService.insertStudent(student);
            return ResponseEntity.ok(student);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/student")
    public ResponseEntity<Student> updateStudent(@RequestBody Student student){
        if(!student.getId().equals("")){
            studentService.saveStudent(student);
            return ResponseEntity.ok(student);
        }else{
            return ResponseEntity.badRequest().build();
        }
    }
    @DeleteMapping("/student/{id}")
    public ResponseEntity deleteStudent(@PathVariable String id){
        if(!id.equals("")){
            studentService.deleteStudentByID(id);
            return ResponseEntity.ok().build();
        }else{
            return ResponseEntity.badRequest().build();
        }
    }
    @GetMapping("/student")
    public ResponseEntity<List<Student>> getAllStudent(){
        Optional<List<Student>> allStudent = studentService.getAllStudent();
        return allStudent.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.badRequest().build());

    }

}
