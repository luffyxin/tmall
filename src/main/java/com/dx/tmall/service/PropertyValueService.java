package com.dx.tmall.service;

import com.dx.tmall.dao.PropertyDAO;
import com.dx.tmall.dao.PropertyValueDAO;
import com.dx.tmall.pojo.Product;
import com.dx.tmall.pojo.Property;
import com.dx.tmall.pojo.PropertyValue;
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
 * @since 2019/2/18 15:46
 */
@Service
public class PropertyValueService {

    @Resource
    PropertyValueDAO propertyValueDAO;
    @Resource
    PropertyService propertyService;

    public void update(PropertyValue bean){
        propertyValueDAO.save(bean);
    }

    public void init(Product product){
        List<Property> properties=propertyService.listByCategory(product.getCategory());

        for(Property property:properties){
            PropertyValue propertyValue=getByPropertyAndProduct(product,property);
            if(null==propertyValue){
                propertyValue=new PropertyValue();
                propertyValue.setProduct(product);
                propertyValue.setProperty(property);
                propertyValueDAO.save(propertyValue);
            }
        }

    }

    public PropertyValue getByPropertyAndProduct(Product product,Property property){
        return propertyValueDAO.getByPropertyAndProduct(property,product);
    }

    public List<PropertyValue> list(Product product){
        return propertyValueDAO.findByProductOrderByIdDesc(product);

    }


}
