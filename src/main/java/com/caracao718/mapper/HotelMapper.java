package com.caracao718.mapper;

import com.caracao718.domain.Hotel;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface HotelMapper {

    @Select("select * from hotel where mountain_id = #{mountainId}")
    List<Hotel> list(Hotel record);
}
