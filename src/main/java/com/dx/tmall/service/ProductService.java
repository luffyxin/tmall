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
import java.util.ArrayList;
import java.util.List;

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

    @Resource
    ProductImageService productImageService;

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
    public void fill(List<Category> categories){
        for(Category category:categories){
            fill(category);
        }
    }

    public void fill(Category category){
        List<Product> products=listByCategory(category);
        productImageService.setFirstProdutImages(products);
        category.setProducts(products);
    }
    public void fillByRow(List<Category> categories){
        int productNumberEachRow = 8;
        for(Category category:categories){
            List<Product> products=category.getProducts();
            List<List<Product>> productsByRow=new ArrayList<>();
            for(int i=0;i<products.size();i+=productNumberEachRow){
                int size=i+productNumberEachRow;
                size =size>products.size()?products.size():size;
                List<Product> productsOfEachRow = products.subList(i,size);
                productsByRow.add(productsOfEachRow);
            }
            category.setProductsByRow(productsByRow);
        }
    }
    public List<Product> listByCategory(Category category){
        return productDAO.findByCateOrderById(category);
    }


}
