package com.caracao718.mapper;

import com.caracao718.domain.Mountain;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface MountainMapper {
    @Select("select * from mountain where id = #{id}")
    Mountain selectById (Integer id);

    @Select("select a.*,b.name as location_name from mountain a join location b on a.location_id = b.id")
    List<Mountain> list ();
}
