package com.jzyh.service.client;

import com.jzyh.service.pojo.Users;
import org.springframework.stereotype.Component;

@Component
public class UserFeignClientFallback implements UserFeignClient {
    @Override
    public Users findById(Integer uid) {
        Users user = new Users();
        user.setUid(uid);
        user.setName("用户查询出现异常！");
        return user;
    }
}
