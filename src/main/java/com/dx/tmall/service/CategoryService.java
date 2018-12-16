package com.dx.tmall.service;
import java.util.List;

import com.dx.tmall.dao.CategoryDAO;
import com.dx.tmall.pojo.Category;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


/**
 * Created by ${DX} on 2018/12/16.
 */
@Service
public class CategoryService {
    @Resource
    CategoryDAO categoryDAO;

    public List<Category> list() {
        Sort sort = new Sort(Sort.Direction.DESC, "id");
        return categoryDAO.findAll(sort);
    }
}
