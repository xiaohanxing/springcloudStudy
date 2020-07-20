package com.myp.service.controller;

import com.myp.service.client.UserClient;
import com.myp.service.pojo.Department;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@DefaultProperties(defaultFallback = "fallbackMethod")
public class DeptController {

//    @Autowired
//    private RestTemplate restTemplate;
//    @Autowired
//    private DiscoveryClient discoveryClient;
      @Autowired
      private UserClient userClient;

    @GetMapping("/dept/{id}")
    @HystrixCommand
    public String getdeptbycustomer(@PathVariable("id") Integer id ){
//        List<ServiceInstance> instances = discoveryClient.getInstances("SERVICE-PROVIDER");
//        ServiceInstance serviceInstance = instances.get(0);
//        if(id==1){
//            throw new RuntimeException();
//        }
     //   return this.restTemplate.getForObject("http://SERVICE-PROVIDER/dept/"+id,String.class);
        return userClient.getDepartment(id).toString();
    }
//    @GetMapping("/dtt")
//    public Department getdept(){
//        return this.restTemplate.getForObject("http://localhost:8081/dept/1",Department.class);
//    }

    public String fallbackMethod(){
        return "服务器忙，请稍后再试!!";
    }
}
