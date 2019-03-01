package com.dx.tmall.controller;

import com.dx.tmall.pojo.Category;
import com.dx.tmall.service.CategoryService;
import com.dx.tmall.service.ProductService;
import jdk.nashorn.internal.objects.annotations.Getter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * 应用模块名称<p>
 * 代码描述<p>
 * copyright:
 * Company: 上海悟泰信息科技有限公司
 *
 * @author wanghanhong
 * @since 2019/2/27 11:00
 */
@RestController
public class ForeRESTController {
    @Resource
    CategoryService categoryService;

    @Resource
    ProductService productService;

    @GetMapping("/forehome")
    public Object home(){
        List<Category> cs=categoryService.list();
        productService.fill(cs);
        productService.fillByRow(cs);
        categoryService.removeCategoryFromProduct(cs);
        return cs;
    }
}
