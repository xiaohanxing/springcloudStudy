package com.myp.service.client;

import com.myp.service.pojo.Department;
import org.springframework.stereotype.Component;

@Component
public class UserClientFallback implements UserClient {
    @Override
    public Department getDepartment(Integer id) {
        Department department = new Department();
        department.setDepartmentName("不好意思o(￣┰￣*)ゞ");
        return department;
    }
}
