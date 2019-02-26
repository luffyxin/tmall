package com.dx.tmall.service;

import com.dx.tmall.dao.UserDao;
import com.dx.tmall.pojo.User;
import com.dx.tmall.util.Page4Navigate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 应用模块名称<p>
 * 代码描述<p>
 * copyright:
 * Company: 上海悟泰信息科技有限公司
 *
 * @author wanghanhong
 * @since 2019/2/25 13:43
 */
@Service
public class UserService {
    @Resource
    UserDao userDao;
    public Page4Navigate<User> list(int start,int size,int navigatePages){
        Sort sort=new Sort(Sort.Direction.DESC,"id");
        Pageable pageable=new PageRequest(start,size,sort);
        Page pageFormJPA=userDao.findAll(pageable);
        return new Page4Navigate<>(pageFormJPA,navigatePages);
    }
}
