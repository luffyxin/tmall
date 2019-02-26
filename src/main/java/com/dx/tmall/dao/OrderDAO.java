package com.dx.tmall.dao;

import com.dx.tmall.pojo.Order;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 应用模块名称<p>
 * 代码描述<p>
 * copyright:
 * Company: 上海悟泰信息科技有限公司
 *
 * @author wanghanhong
 * @since 2019/2/26 13:48
 */
public interface OrderDAO extends JpaRepository<Order,Integer>{
}
