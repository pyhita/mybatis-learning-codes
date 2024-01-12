package com.yangtao.handler;

import com.yangtao.contanst.Gender;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;

/**
 * @Author: kante_yang
 * @Date: 2024/1/12
 */
@MappedJdbcTypes(JdbcType.INTEGER)
public class GenderTypeHandler extends BaseTypeHandler<Gender> {

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, Gender parameter,
        JdbcType jdbcType) throws SQLException {
        int value = parameter == Gender.MALE ? 0 : 1;
        ps.setInt(i, value);
    }

    @Override
    public Gender getNullableResult(ResultSet rs, String columnName) throws SQLException {
        int value = rs.getInt(columnName);

        return value == 0 ? Gender.MALE : Gender.FEMALE;
    }

    @Override
    public Gender getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        int value = rs.getInt(columnIndex);
        return value == 0 ? Gender.MALE : Gender.FEMALE;
    }

    @Override
    public Gender getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        int value = cs.getInt(columnIndex);
        return value == 0 ? Gender.MALE : Gender.FEMALE;
    }
}
