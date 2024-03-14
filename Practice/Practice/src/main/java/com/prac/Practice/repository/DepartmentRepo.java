package com.prac.Practice.repository;

import com.prac.Practice.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepo extends JpaRepository<Department, Integer> {
    public Department findByDepName(String depName);

}
