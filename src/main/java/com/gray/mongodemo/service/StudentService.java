package com.gray.mongodemo.service;

import com.gray.mongodemo.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Created by IntelliJ IDEA Ultimate.
 * User: Pasindu Raveen
 * Date: 13-Dec-22
 * Time: 1:33 AM
 * MongoDemo
 */
@Service
public interface StudentService {
    Optional<Student> getStudentByEmail(String email);
    void saveStudent(Student student);
    void insertStudent(Student student);
    void deleteStudent(Student student);
    void deleteStudentByID(String id);
    Optional<List<Student>> getAllStudent();
}
