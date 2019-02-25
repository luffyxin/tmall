package com.dx.tmall.dao;

import com.dx.tmall.pojo.Product;
import com.dx.tmall.pojo.Property;
import com.dx.tmall.pojo.PropertyValue;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * 应用模块名称<p>
 * 代码描述<p>
 * copyright:
 * Company: 上海悟泰信息科技有限公司
 *
 * @author wanghanhong
 * @since 2019/2/18 11:07
 */
public interface PropertyValueDAO extends JpaRepository<PropertyValue,Integer>{
    List<PropertyValue> findByProductOrderByIdDesc(Product product);

    PropertyValue getByPropertyAndProduct(Property property,Product product);
}
