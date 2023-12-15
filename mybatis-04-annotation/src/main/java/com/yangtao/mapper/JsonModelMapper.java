package com.yangtao.mapper;

import com.yangtao.entity.JsonModel;
import com.yangtao.entity.JsonModel.Person;
import java.util.List;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

/**
 * @Author: kante_yang
 * @Date: 2023/12/15
 */
public interface JsonModelMapper {

    @Select("""
        <script>
            SELECT * FROM json_test
        </script>
    """)
    @Results(value = {
        @Result(property = "id", column = "id"),
        @Result(property = "testField", column = "test_field"),
        @Result(property = "jsonModel", column = "json_model", javaType = Person.class)
    })
    List<JsonModel> getAllModels();
}
