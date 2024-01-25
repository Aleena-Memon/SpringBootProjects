package com.aleena.coding.service;

import com.aleena.coding.controller.request.DepartmentRequest;
import com.aleena.coding.controller.response.DepartmentResponse;
import com.aleena.coding.exception.DeptNotFoundException;
import com.aleena.coding.repository.DepartmentRepository;
import com.aleena.coding.repository.entity.Department;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@Service

public class DepartmentService {

    private DepartmentRepository departmentRepository;
    public DepartmentService(DepartmentRepository departmentRepository ) {
        this.departmentRepository = departmentRepository;
    }

    // get all the departments
    public List<DepartmentResponse> getDepartments(){
        return departmentRepository.findAll().stream().map(this::build).collect(Collectors.toList());
    }

    public DepartmentResponse build(final Department department){
        DepartmentResponse response = new DepartmentResponse();
        response.setId(department.getId());
        response.setName(department.getName());
        response.setLocation(department.getDeptLocation());
        response.setDepthead(department.getDeptHead());
        response.setEmpno(department.getEmployeeNo());
        return response;

    }

    // getById department

    public DepartmentResponse getDeptById(Integer id){
        return build(getById(id));
    }

    private Department getById(final Integer id){
        Optional<Department> department = departmentRepository.findById(id);
        if(department.isEmpty()){
            throw new DeptNotFoundException("Department is not found with id: "+id);
        }
        return department.get();
    }

    // save method

    public DepartmentResponse save(final DepartmentRequest request){
        Department department= build(request);
        System.out.println("before -> "+ department);
        Department savedDept = departmentRepository.save(department);
        System.out.println("after -> "+ savedDept);
         return build(savedDept);

    }

    public Department build(DepartmentRequest request){
        Department dept = new Department();
        dept.setName(request.getName());
        dept.setDeptLocation(request.getLocation());
        dept.setDeptHead(request.getDepthead());
        dept.setEmployeeNo(request.getEmpno());
        return dept;
    }

    // Update Method
    public DepartmentResponse update(final Integer id, DepartmentRequest request){
        Department dept = getById(id);
        dept.setName(request.getName());
        dept.setDeptLocation(request.getLocation());
        dept.setDeptHead(request.getDepthead());
        dept.setEmployeeNo(request.getEmpno());
        return build(departmentRepository.save(dept));
    }

    // Delete Method
    public void delete(final Integer id){
        departmentRepository.deleteById(id);
    }
}
