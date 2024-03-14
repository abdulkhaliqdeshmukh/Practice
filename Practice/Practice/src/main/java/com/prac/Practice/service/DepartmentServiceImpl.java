package com.prac.Practice.service;

import com.prac.Practice.entity.Department;
import com.prac.Practice.error.DepartmentNotFoundException;
import com.prac.Practice.repository.DepartmentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    private DepartmentRepo departmentRepo;
    @Override
    public Department saveDepartment(Department department) {

        return departmentRepo.save(department);
    }

    @Override
    public List<Department> fetchDepartmentList() {

        return departmentRepo.findAll();
    }

    @Override
    public Department fetchDepartmentById(Integer depId) throws DepartmentNotFoundException {

        Optional<Department> department = departmentRepo.findById(depId);
        if (!department.isPresent()){
            throw new DepartmentNotFoundException("No entries found");
        }
        return department.get();
    }

    @Override
    public void deleteDepartmentById(Integer depId) {

            departmentRepo.deleteById(depId);

    }

    @Override
    public Department updateDepartment(Integer depId, Department department) {
        Department depDb = departmentRepo.findById(depId).get();

        if (Objects.nonNull(department.getDepName()) &&
                !"".equalsIgnoreCase(department.getDepName())) {
            depDb.setDepName(department.getDepName());
        }

        if (Objects.nonNull(department.getDepAddress()) &&
                !"".equalsIgnoreCase(department.getDepAddress())) {
            depDb.setDepAddress(department.getDepAddress());
        }

        if (Objects.nonNull(department.getDepCode()) &&
                !"".equalsIgnoreCase(department.getDepCode())) {
            depDb.setDepCode(department.getDepCode());
        }
     return departmentRepo.save(depDb);
    }

    @Override
    public Department fetchDepartmentByName(String depName) {

        return departmentRepo.findByDepName(depName);
    }
}
