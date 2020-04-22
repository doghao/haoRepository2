package com.jzyh.service.controller;

import com.jzyh.service.client.UserFeignClient;
import com.jzyh.service.client.UserFeignClientFallback;
import com.jzyh.service.pojo.Users;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("user")
// @DefaultProperties(defaultFallback = "UserByIdFallback") //全局熔断器
public class UserController {

    @Autowired
    public RestTemplate restTemplate;

    @Autowired
    private DiscoveryClient discoveryClient;// Eureka客户端，可以获取到服务实例信息

    @Autowired
    private UserFeignClient userFeignClient;

    /*@GetMapping
    public Users findById(@RequestParam("uid") Integer uid){

        return restTemplate.getForObject("http://localhost:8081/user/"+uid,Users.class);
    }*/
    @GetMapping
    // @HystrixCommand/*(fallbackMethod = "queryUserByIdFallback")*/ //局部熔断器
    public Users findById(@RequestParam("uid") Integer uid){
        /*// 根据服务名称，获取服务实例
        List<ServiceInstance> instances = discoveryClient.getInstances("jzyh-service-provider");
        // 因为只有一个UserService,因此我们直接get(0)获取
        ServiceInstance provider = instances.get(0);
        String host = provider.getHost();
        System.out.println(host);
        // 获取ip和端口信息
        String baseUrl = "http://"+host + ":" + provider.getPort()+"/user/"+uid;
        return restTemplate.getForObject(baseUrl,Users.class);*/


        // return restTemplate.getForObject("http://jzyh-service-provider/user/"+uid,String.class);
        return userFeignClient.findById(uid);
    }

    /*public String queryUserByIdFallback(Integer uid){
        return "用户信息查询出现异常！";
    }*/


   // public String UserByIdFallback(){
   //     return "用户信息查询出现异常！";
    // }
}
