package com.dx.tmall.controller;

import com.dx.tmall.pojo.Product;
import com.dx.tmall.service.CategoryService;
import com.dx.tmall.service.ProductImageService;
import com.dx.tmall.service.ProductService;
import com.dx.tmall.util.Page4Navigate;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * 应用模块名称<p>
 * 代码描述<p>
 * copyright:
 * Company: 上海悟泰信息科技有限公司
 *
 * @author wanghanhong
 * @since 2019/2/13 15:48
 */
@RestController
public class ProductController {

    @Resource
    ProductService productService;

    @Resource
    CategoryService categoryService;

    @Resource
    ProductImageService productImageService;

    @GetMapping("/categories/{cid}/products")
    public Page4Navigate<Product> list(@PathVariable("cid")int cid, @RequestParam
            (value = "start",defaultValue = "0")int start,@RequestParam(value =
            "size",defaultValue = "5")int size)throws Exception{
        start=start<0?0:start;
        Page4Navigate<Product> page=productService.list(cid,start,size,5);
        productImageService.setFirstProdutImages(page.getContent());
        return page;
    }

    @GetMapping("/products/{id}")
    public Product get(@PathVariable("id") int id)throws Exception{
        Product bean=productService.get(id);
        return bean;
    }

    @PostMapping("/products")
    public Object add(@RequestBody Product bean)throws Exception{
        bean.setCreateDate(new Date());
        productService.add(bean);
        return bean;
    }

    @DeleteMapping("/product/{id}")
    public String delete(@PathVariable("id")int id, HttpServletRequest request)throws Exception{
        productService.delete(id);
        return null;
    }

    @PutMapping("/products")
    public Object update(@RequestBody Product bean) throws Exception{
        productService.update(bean);
        return bean;
    }


}
