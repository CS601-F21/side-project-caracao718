package com.caracao718.mapper;

import com.caracao718.domain.Location;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface LocationMapper {
    @Select("select * from location where id = #{id}")
    Location selectById(Integer id);

    @Select("select * from location")
    List<Location> list();
}
