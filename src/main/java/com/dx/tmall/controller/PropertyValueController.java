package com.dx.tmall.controller;

import com.dx.tmall.pojo.Product;
import com.dx.tmall.pojo.PropertyValue;
import com.dx.tmall.service.ProductService;
import com.dx.tmall.service.PropertyValueService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 应用模块名称<p>
 * 代码描述<p>
 * copyright:
 * Company: 上海悟泰信息科技有限公司
 *
 * @author wanghanhong
 * @since 2019/2/18 16:13
 */
@RestController
public class PropertyValueController {
    @Resource
    PropertyValueService propertyValueService;
    @Resource
    ProductService productService;

    @GetMapping("/products/{pid}/propertyValues")
    public List<PropertyValue> list(@PathVariable("pid") int pid)throws Exception{
        Product product=productService.get(pid);
        propertyValueService.init(product);
        List<PropertyValue> propertyValues=propertyValueService.list(product);
        return propertyValues;
    }

    @PutMapping("/propertyValues")
    public Object update(@RequestBody PropertyValue bean) throws Exception{
        propertyValueService.update(bean);
        return bean;
    }



}
