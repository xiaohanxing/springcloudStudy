package com.myp.service.client;

import com.myp.service.pojo.Department;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "SERVICE-PROVIDER",fallback = UserClientFallback.class)
public interface UserClient {

    @GetMapping("/dept/{id}")
    public Department getDepartment(@PathVariable("id") Integer id);
}
