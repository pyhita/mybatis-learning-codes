package com.yangtao.mapper;

import com.yangtao.entity.Customer;
import com.yangtao.entity.Order;
import java.util.List;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

/**
 * @Author: kante_yang
 * @Date: 2023/12/15
 */
public interface OrderMapper {

    @Select("""
        <script>
            SELECT * FROM t_order
            WHERE customer_id = #{customerId}
        </script>
    """)
    List<Order> findOrdersById(Integer customerId);


    @Select("""
        <script>
            SELECT * FROM t_order
        </script>
    """)
    @Results(id = "orderMap", value = {
        @Result(property = "orderId", column = "order_id"),
        @Result(property = "orderName", column = "order_name"),
        @Result(
            property = "customer",
            column = "customer_id",
            javaType = Customer.class,
            one = @One(select = "com.yangtao.mapper.CustomerMapper.selectCustomerById")
        )
    })
    List<Order> findOrders();
}
