package com.lym.mapper.user;

import com.lym.model.user.vo.DepartmentVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface DepartmentMapper {

    List<DepartmentVO> loadAllDept();
}
