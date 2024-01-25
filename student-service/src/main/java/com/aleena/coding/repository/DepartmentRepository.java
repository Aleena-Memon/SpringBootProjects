package com.aleena.coding.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.aleena.coding.repository.entity.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Integer> {

}
