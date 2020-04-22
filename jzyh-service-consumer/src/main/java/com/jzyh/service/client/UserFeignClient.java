package com.jzyh.service.client;

import com.jzyh.service.pojo.Users;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "jzyh-service-provider", fallback=UserFeignClientFallback.class) //标注要调用的服务名
public interface UserFeignClient {


    @GetMapping("user/{uid}")
    public Users findById(@PathVariable("uid") Integer uid);


}
