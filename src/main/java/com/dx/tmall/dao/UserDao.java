package com.dx.tmall.dao;

import com.dx.tmall.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 应用模块名称<p>
 * 代码描述<p>
 * copyright:
 * Company: 上海悟泰信息科技有限公司
 *
 * @author wanghanhong
 * @since 2019/2/25 13:42
 */
public interface UserDao extends JpaRepository<User,Integer>{

}
