package com.gray.mongodemo.service.impl;

import com.gray.mongodemo.model.Student;
import com.gray.mongodemo.repository.StudentRepository;
import com.gray.mongodemo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Created by IntelliJ IDEA Ultimate.
 * User: Pasindu Raveen
 * Date: 13-Dec-22
 * Time: 1:40 AM
 * MongoDemo
 */
@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentRepository studentRepository;

    @Override
    public Optional<Student> getStudentByEmail(String email) {
        return studentRepository.findStudentByEmail(email);
    }

    @Override
    public void saveStudent(Student student) {
        studentRepository.save(student);
    }

    @Override
    public void insertStudent(Student student) {
        studentRepository.insert(student);
    }

    @Override
    public void deleteStudent(Student student) {
        studentRepository.delete(student);
    }

    @Override
    public void deleteStudentByID(String id) {
        studentRepository.deleteById(id);
    }

    @Override
    public Optional<List<Student>> getAllStudent() {
        List<Student> students = studentRepository.findAll();
        return  Optional.of(students);
    }
}
