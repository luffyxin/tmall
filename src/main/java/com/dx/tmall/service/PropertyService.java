package com.dx.tmall.service;

import com.dx.tmall.dao.CategoryDAO;
import com.dx.tmall.dao.PropertyDAO;
import com.dx.tmall.pojo.Category;
import com.dx.tmall.pojo.Property;
import com.dx.tmall.util.Page4Navigate;
import org.hibernate.annotations.Source;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 应用模块名称<p>
 * 代码描述<p>
 * copyright:
 * Company: 上海悟泰信息科技有限公司
 *
 * @author wanghanhong
 * @since 2019/1/30 16:03
 */
@Service
public class PropertyService {

    @Resource
    PropertyDAO propertyDAO;


    @Resource
    CategoryService categoryService;

    public void add(Property bean){
        propertyDAO.save(bean);
    }

    public void delete(int id){
        propertyDAO.delete(id);
    }

    public Property get(int id){
        return propertyDAO.findOne(id);
    }

    public void  update(Property bean){
        propertyDAO.save(bean);
    }

    public Page4Navigate<Property> list(int cid,int start ,int size,int navigatePages){
        Category category=categoryService.get(cid);
        Sort sort=new Sort(Sort.Direction.ASC,"id");
        Pageable page=new PageRequest(start,size,sort);
        Page pageFormJpa=propertyDAO.findByCategory(category,page);
        return new Page4Navigate<>(pageFormJpa,navigatePages);
    }

    public List<Property> listByCategory(Category category){
        return propertyDAO.findByCategory(category);
    }


}
