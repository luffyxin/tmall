package com.dx.tmall.controller;

import com.dx.tmall.pojo.Order;
import com.dx.tmall.service.OrderItemService;
import com.dx.tmall.service.OrderService;
import com.dx.tmall.util.Page4Navigate;
import com.dx.tmall.util.Result;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.Date;

/**
 * 应用模块名称<p>
 * 代码描述<p>
 * copyright:
 * Company: 上海悟泰信息科技有限公司
 *
 * @author wanghanhong
 * @since 2019/2/26 15:06
 */
@RestController
public class OrderController {
    @Resource
    OrderService orderService;
    @Resource
    OrderItemService orderItemService;

    @GetMapping("/orders")
    public Page4Navigate<Order> list(@RequestParam(value = "start", defaultValue = "0") int start, @RequestParam(value = "size", defaultValue = "5") int size) throws Exception {
        start = start<0?0:start;
        Page4Navigate<Order> page=orderService.list(start,size,5);
        orderItemService.fill(page.getContent());
        orderService.removeOrderFromOrderItem(page.getContent());
        return page;
    }
    @PutMapping("deliveryOrder/{oid}")
    public Object delliveryOrder(@PathVariable int oid)throws IOException{
        Order o=orderService.get(oid);
        o.setDeliveryDate(new Date());
        o.setStatus(OrderService.waitConfirm);
        orderService.update(o);
        return Result.success();
    }

}
