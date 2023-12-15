package com.yangtao.hander2;

/**
 * @Author: kante_yang
 * @Date: 2023/12/15
 */

import com.alibaba.fastjson.JSON;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedTypes;
import org.apache.ibatis.type.TypeHandler;

/**
 * @Author: kante_yang
 * @Date: 2023/12/14
 */
@MappedTypes(String.class)
public class JsonTypeHandler implements TypeHandler<Object> {

    private Class<?> type;

    public JsonTypeHandler(Class type) {
        if (type == null) {
            throw new RuntimeException("type cannot be null");
        }

        this.type = type;
    }

    @Override
    public void setParameter(PreparedStatement ps, int i, Object parameter, JdbcType jdbcType)
        throws SQLException {
        ps.setString(i, JSON.toJSONString(parameter));
    }

    @Override
    public Object getResult(ResultSet rs, String columnName) throws SQLException {
        return parse(rs.getString(columnName));
    }

    @Override
    public Object getResult(ResultSet rs, int columnIndex) throws SQLException {
        return parse(rs.getString(columnIndex));
    }

    @Override
    public Object getResult(CallableStatement cs, int columnIndex) throws SQLException {
        return parse(cs.getString(columnIndex));
    }

//    private Object parse(String json) {
//        return JSON.parseObject(json, type);
//    }

    private Object parse(String json) {
        return JSON.parseObject(json, String.class);
    }
}
