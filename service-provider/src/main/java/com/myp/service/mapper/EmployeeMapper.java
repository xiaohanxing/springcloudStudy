package com.myp.service.mapper;

import com.myp.service.pojo.Employee;

public interface EmployeeMapper {

    public Employee getEmpById(Integer id);

    public void insertEmp(Employee employee);
}
