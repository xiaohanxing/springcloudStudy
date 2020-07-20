package com.myp.service.controller;

import com.myp.service.mapper.DepartmentMapper;
import com.myp.service.pojo.Department;
import com.myp.service.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeptController {

    @Autowired
    DepartmentMapper departmentMapper;

    @GetMapping("/dept/{id}")
    public Department getDepartment(@PathVariable("id") Integer id ){
//        try{
//            Thread.sleep(20000);
//        }catch (Exception e){
//            e.printStackTrace();
//        }
        return departmentMapper.getDeptById(id);
    }
    @GetMapping("/dept")
    public Department insertDepartment(Department department){
        departmentMapper.insertDept(department);
        return department;
    }

}
