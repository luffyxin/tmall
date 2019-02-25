package com.dx.tmall.service;

import com.dx.tmall.dao.ProductDAO;
import com.dx.tmall.pojo.Category;
import com.dx.tmall.pojo.Product;
import com.dx.tmall.util.Page4Navigate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 应用模块名称<p>
 * 代码描述<p>
 * copyright:
 * Company: 上海悟泰信息科技有限公司
 *
 * @author wanghanhong
 * @since 2019/2/13 15:13
 */
@Service
public class ProductService {

    @Resource
    ProductDAO productDAO;

    @Resource
    CategoryService categoryService;

    public void add(Product bean){
        productDAO.save(bean);
    }

    public void delete(int id){
        productDAO.delete(id);
    }

    public Product get(int id){
        return  productDAO.getOne(id);
    }
    public void update(Product bean){
        productDAO.save(bean);
    }

    public Page4Navigate<Product> list(int cid ,int start,int size,int navigatePages){
        Category category =categoryService.get(cid);
        Sort sort=new Sort(Sort.Direction.DESC,"id");
        Pageable pageable=new PageRequest(start,size,sort);
        Page<Product> pageFromJPA=productDAO.findByCategory(category,pageable);
        return new Page4Navigate<>(pageFromJPA,navigatePages);
    }


}
