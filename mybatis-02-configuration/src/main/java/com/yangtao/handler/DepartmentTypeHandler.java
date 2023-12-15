package com.yangtao.handler;

import com.yangtao.entity.Department;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

/**
 * @Author: kante_yang
 * @Date: 2023/12/14
 */
public class DepartmentTypeHandler implements TypeHandler<Department> {

    @Override
    public void setParameter(PreparedStatement ps, int i, Department parameter, JdbcType jdbcType)
        throws SQLException {
        ps.setString(i, parameter.getId());
    }

    @Override
    public Department getResult(ResultSet rs, String columnName) throws SQLException {
        Department department = new Department();
        department.setId(rs.getString(columnName));
        return department;
    }

    @Override
    public Department getResult(ResultSet rs, int columnIndex) throws SQLException {
        Department department = new Department();
        department.setId(rs.getString(columnIndex));
        return department;
    }

    @Override
    public Department getResult(CallableStatement cs, int columnIndex) throws SQLException {
        Department department = new Department();
        department.setId(cs.getString(columnIndex));
        return department;
    }
}
