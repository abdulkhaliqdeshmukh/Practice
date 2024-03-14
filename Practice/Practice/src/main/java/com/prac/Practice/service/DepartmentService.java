package com.prac.Practice.service;

import com.prac.Practice.entity.Department;
import com.prac.Practice.error.DepartmentNotFoundException;

import java.util.List;

public interface DepartmentService {
    Department saveDepartment(Department department);

    List<Department> fetchDepartmentList();

    Department fetchDepartmentById(Integer depId) throws DepartmentNotFoundException;

    void deleteDepartmentById(Integer depId);

    Department updateDepartment(Integer depId, Department department);

    Department fetchDepartmentByName(String depName);
}
