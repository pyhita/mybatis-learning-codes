package com.linkedbear.mybatis.handler;

import com.linkedbear.mybatis.entity.Department;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DepartmentTypeHandler implements TypeHandler<Department> {

    @Override
    public void setParameter(PreparedStatement preparedStatement, int i, Department department, JdbcType jdbcType) throws SQLException {
        preparedStatement.setString(i, department.getId());
    }

    @Override
    public Department getResult(ResultSet resultSet, String s) throws SQLException {
        Department department = new Department();
        department.setId(resultSet.getString(s));
        return department;
    }

    @Override
    public Department getResult(ResultSet resultSet, int i) throws SQLException {
        Department department = new Department();
        department.setId(resultSet.getString(i));
        return department;
    }

    @Override
    public Department getResult(CallableStatement callableStatement, int i) throws SQLException {
        Department department = new Department();
        department.setId(callableStatement.getString(i));
        return department;
    }
}
