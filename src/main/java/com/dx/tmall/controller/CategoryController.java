package com.dx.tmall.controller;

import com.dx.tmall.pojo.Category;
import com.dx.tmall.service.CategoryService;
import com.dx.tmall.util.Page4Navigate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class CategoryController {
    @Resource
    CategoryService categoryService;

    @GetMapping("/categories")
    public Page4Navigate<Category> list(@RequestParam(value = "start" ,
            defaultValue = "0") int start,@RequestParam(value = "size",defaultValue = "5") int size)throws Exception{
        start = start<0?0:start;
        Page4Navigate<Category> page=categoryService.list(start,size,5);
        return  page;
    }
}
