package com.dx.tmall.dao;

import com.dx.tmall.pojo.Category;
import com.dx.tmall.pojo.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * 应用模块名称<p>
 * 代码描述<p>
 * copyright:
 * Company: 上海悟泰信息科技有限公司
 *
 * @author wanghanhong
 * @since 2019/2/13 15:05
 */
public interface ProductDAO extends JpaRepository<Product,Integer> {
    Page<Product> findByCategory(Category category,Pageable pageable);
    List<Product> findByCategoryOrderById(Category category);
}
