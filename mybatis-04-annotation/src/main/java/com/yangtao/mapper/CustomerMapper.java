package com.yangtao.mapper;

import com.yangtao.entity.Customer;
import java.util.List;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

/**
 * @Author: kante_yang
 * @Date: 2023/12/15
 */
public interface CustomerMapper {

    @Select("""
        <script>
            SELECT * FROM t_customer
        </script>
    """)
    @Results(id = "customerMap", value = {
        @Result(property = "customerId", column = "customer_id"),
        @Result(property = "customerName", column = "customer_name"),
        @Result(
            property = "orders",
            column = "customer_id",
            javaType = List.class,
            many = @Many(select = "com.yangtao.mapper.OrderMapper.findOrdersById"))
    })
    List<Customer> selectAllCustomers();


    @Select("SELECT * FROM t_customer WHERE customer_id = #{customerId}")
    Customer selectCustomerById(Integer customerId);
}
