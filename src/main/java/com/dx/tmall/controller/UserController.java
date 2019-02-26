package com.dx.tmall.controller;

import com.dx.tmall.pojo.User;
import com.dx.tmall.service.UserService;
import com.dx.tmall.util.Page4Navigate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 应用模块名称<p>
 * 代码描述<p>
 * copyright:
 * Company: 上海悟泰信息科技有限公司
 *
 * @author wanghanhong
 * @since 2019/2/25 13:53
 */
@RestController
public class UserController {

    @Resource
    UserService userService;

    @GetMapping("/users")
    public Page4Navigate<User> list(@RequestParam(value = "start",defaultValue = "0")int start,@RequestParam(value = "size",defaultValue = "5")int size) throws Exception{
        start =start<0?0:start;
        Page4Navigate<User> page=userService.list(start,size,5);
        return page;

    }

}
