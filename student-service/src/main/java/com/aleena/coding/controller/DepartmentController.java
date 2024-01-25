package com.aleena.coding.controller;

import com.aleena.coding.controller.request.DepartmentRequest;
import com.aleena.coding.controller.response.DepartmentResponse;
import com.aleena.coding.service.DepartmentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/department")
public class DepartmentController {

    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping
    public ResponseEntity<List<DepartmentResponse>> getAllDepartment(){
        return ResponseEntity.ok(departmentService.getDepartments());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DepartmentResponse> getDepartmentById(@PathVariable("id") final Integer id) {
        return ResponseEntity.ok(departmentService.getDeptById(id));
    }

    @PostMapping
    public ResponseEntity<DepartmentResponse> saveDepartment(@RequestBody final DepartmentRequest request){
        return new ResponseEntity<>(departmentService.save(request), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDepartment(@PathVariable("id") final Integer id){
        departmentService.delete(id);
        return ResponseEntity.noContent().build();

    }

    @PutMapping("/{id}")
    public ResponseEntity<DepartmentResponse> updateDepartment(@PathVariable("id") final Integer id, @RequestBody DepartmentRequest request){
      return ResponseEntity.ok(departmentService.update(id,request));
    }

}
