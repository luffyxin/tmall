package com.dx.tmall.service;
import java.util.List;

import com.dx.tmall.dao.CategoryDAO;
import com.dx.tmall.pojo.Category;
import com.dx.tmall.util.Page4Navigate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
    public Page4Navigate<Category>  list(int start,int size,int navigatePages){
       Sort sort=new Sort(Sort.Direction.DESC,"id");
       Pageable pageable=new PageRequest(start,size,sort);
       Page pageFromJPA=categoryDAO.findAll(pageable);

       return new Page4Navigate<>(pageFromJPA,navigatePages);
    }
    public void add(Category bean){
        categoryDAO.save(bean);
    }
    public void delete(int id){
        categoryDAO.delete(id);
    }
}
