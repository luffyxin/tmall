package com.dx.tmall.controller;

import com.dx.tmall.pojo.Category;
import com.dx.tmall.service.CategoryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class CategoryController {
    @Resource
    CategoryService categoryService;

    @GetMapping("/categories")
    public List<Category> list() throws Exception {
        return categoryService.list();
    }
}
