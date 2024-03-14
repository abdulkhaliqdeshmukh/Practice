package com.prac.Practice.controller;

import com.prac.Practice.entity.Department;
import com.prac.Practice.error.DepartmentNotFoundException;
import com.prac.Practice.service.DepartmentService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;

    private final Logger LOGGER = LoggerFactory.getLogger(DepartmentController.class);

    @PostMapping("/departments")
    public Department saveDepartment(@Valid @RequestBody Department department){
        LOGGER.info("Inside SaveDepartment of Department Controller");
        return departmentService.saveDepartment(department);
    }
    @GetMapping("/departments")
    public List<Department> fetchDepartmentList() {
        LOGGER.info("Inside FetchDepartment of Department Controller");
        return departmentService.fetchDepartmentList();
    }

    @GetMapping("/departments/{id}")
    public Department fetchDepartmentById(@PathVariable("id") Integer depId) throws DepartmentNotFoundException {
        LOGGER.info("Inside FetchDepartmentById of Department Controller");
        return departmentService.fetchDepartmentById(depId);
    }

    @DeleteMapping("/departments/{id}")
    public String deleteDepartmentById(@PathVariable("id") Integer depId){
        departmentService.deleteDepartmentById(depId);
        return "Department deleted successfully";
    }

    @PutMapping("/departments/{id}")
    public Department updateDepartment(@PathVariable("id") Integer depId,
                                       @RequestBody Department department){
        return departmentService.updateDepartment(depId, department);
    }

    @GetMapping("/departments/name/{name}")
    public Department fetchDepartmentByName(@PathVariable("name") String depName){
        return departmentService.fetchDepartmentByName(depName);

    }
}
