package com.dx.tmall.controller;

import com.dx.tmall.pojo.Property;
import com.dx.tmall.service.PropertyService;
import com.dx.tmall.util.Page4Navigate;
import org.hibernate.annotations.Source;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 应用模块名称<p>
 * 代码描述<p>
 * copyright:
 * Company: 上海悟泰信息科技有限公司
 *
 * @author wanghanhong
 * @since 2019/1/30 16:45
 */
@RestController
public class PropertyController {
    @Resource
    PropertyService propertyService;

    @GetMapping("/categories/{cid}/properties")
    public Page4Navigate<Property> list(@PathVariable("cid") int cid,
                                        @RequestParam(value = "start", defaultValue = "0") int start,
                                        @RequestParam(value = "size", defaultValue = "5") int size)
            throws Exception {
        start = start<0?0:start;
        Page4Navigate<Property> page=propertyService.list(cid,start,size,5);
        return page;
    }
    @GetMapping("/properties/{id}")
    public Property get(@PathVariable("id")int id)throws Exception{
        Property bean=  propertyService.get(id);
        return bean;
    }

    @PostMapping("/properties")
    public Object add(@RequestBody Property bean)throws Exception{
        propertyService.add(bean);
        return bean;
    }

    @DeleteMapping("/properties/{id}")
    public String delete(@PathVariable("id") int id)throws Exception{
        propertyService.delete(id);
        return  null;
    }
    @PutMapping("/properties")
    public Object update(@RequestBody Property bean)throws Exception{
        propertyService.update(bean);
        return bean;
    }

}
