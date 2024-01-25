package com.aleena.coding.controller;

import com.aleena.coding.controller.request.StudentRequest;
import com.aleena.coding.controller.response.StudentResponse;
import com.aleena.coding.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
//@AllArgsConstructor
@RequestMapping("/v1/student")
public class StudentController {

    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public ResponseEntity<List<StudentResponse>> getAllStudent() {
        return ResponseEntity.ok(studentService.getStudents());
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentResponse> getStudentByID(@PathVariable("id") final Integer id) {
        return ResponseEntity.ok(studentService.getStudentById(id));
    }

    @PostMapping
    public ResponseEntity<StudentResponse> saveStudent(@RequestBody final StudentRequest request) {
        return new ResponseEntity<>(studentService.save(request), HttpStatus.CREATED);
    }

//    @DeleteMapping

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable("id") final Integer id) {
        studentService.delete(id);
        return ResponseEntity.noContent().build();
    }

    // @PutMapping

    @PutMapping("/{id}")
    public ResponseEntity<StudentResponse> getStudentById(@PathVariable("id") final Integer id, @RequestBody final StudentRequest request) {
        return ResponseEntity.ok(studentService.update(id, request));

    }
}
