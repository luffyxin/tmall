package com.dx.tmall.service;

import com.dx.tmall.dao.OrderItemDAO;
import com.dx.tmall.pojo.Order;
import com.dx.tmall.pojo.OrderItem;
import com.dx.tmall.pojo.ProductImage;
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
 * @since 2019/2/26 14:01
 */
@Service
public class OrderItemService {
    @Resource
    OrderItemDAO orderItemDAO;
    @Resource
    ProductImageService productImageService;

    public void fill(List<Order> orders){
        for(Order order:orders){
            fill(order);
        }
    }

    public void fill(Order order) {
        List<OrderItem> orderItems = listByOrder(order);
        float total = 0;
        int totalNumber = 0;
        for (OrderItem oi :orderItems) {
            total+=oi.getNumber()*oi.getProduct().getPromotePrice();
            totalNumber+=oi.getNumber();
            productImageService.setFirstProdutImage(oi.getProduct());
        }
        order.setTotal(total);
        order.setOrderItems(orderItems);
        order.setTotalNumber(totalNumber);
    }

    public List<OrderItem> listByOrder(Order order) {
        return orderItemDAO.findByOrderOrderByIdDesc(order);
    }
}
