package com.aleena.coding.service;

import com.aleena.coding.controller.request.StudentRequest;
import com.aleena.coding.controller.response.StudentResponse;
import com.aleena.coding.exception.StudentNotFoundException;
import com.aleena.coding.repository.StudentRepository;
import com.aleena.coding.repository.entity.Student;
//import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Slf4j
@Service

//@AllArgsConstructor
public class StudentService {

    private StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<StudentResponse> getStudents() {
//        List<Student> students = studentRepository.findAll();
//
//        List<StudentResponse> studentResponses = new ArrayList<>();
//        for (Student student : students) {
//            studentResponses.add(build(student));
//        }

        return studentRepository.findAll().stream().map(this::build).collect(Collectors.toList());
    }

    // getStudentById  ->   getByI
    public StudentResponse getStudentById(final Integer id) {
        //  log.info("Getting student by id [{}]", id);
        return build(getById(id));
    }

    public StudentResponse save(final StudentRequest request) {
        Student student = build(request);
        System.out.println("before -> " + student);
        Student savedStudent = studentRepository.save(student);
        System.out.println("after -> " + savedStudent);
        return build(savedStudent);
    }

    public StudentResponse update(final Integer id, final StudentRequest request) {
        Student student = getById(id);
        student.setName(request.getName());
        student.setAddress(request.getAddress());
//        log.info("Update student ", student);
        return build(studentRepository.save(student));
    }


    public void delete(final Integer id) {
//        final Student student = getById(id);
//        studentRepository.delete(student);
        studentRepository.deleteById(id);
    }

    private StudentResponse build(final Student student) {
        StudentResponse response = new StudentResponse();
        response.setStudentId(student.getId());
        response.setName(student.getName());
        response.setRollNo(student.getRollNo());
        response.setAddress(student.getAddress());
        return response;
    }

    private Student build(final StudentRequest request) {
        Student student = new Student();
        student.setName(request.getName());
        student.setAddress(request.getAddress());
        student.setRollNo(UUID.randomUUID().toString());
        return student;
    }

    private Student getById(final Integer id) {
        Optional<Student> student = studentRepository.findById(id);
        if (student.isEmpty()) {
            throw new StudentNotFoundException("student not found with id: " + id);
        }
        return student.get();
    }
}
