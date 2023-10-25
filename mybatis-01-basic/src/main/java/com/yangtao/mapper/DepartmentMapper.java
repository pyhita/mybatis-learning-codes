package com.yangtao.mapper;

import com.yangtao.entity.Department;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DepartmentMapper {

    List<Department> findAll();
}
