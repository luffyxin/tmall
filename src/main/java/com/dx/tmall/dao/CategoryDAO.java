package com.dx.tmall.dao;

import com.dx.tmall.pojo.Category;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by ${DX} on 2018/12/16.
 */
public interface CategoryDAO extends JpaRepository<Category,Integer> {
}
