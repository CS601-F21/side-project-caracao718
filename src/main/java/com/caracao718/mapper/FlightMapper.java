package com.caracao718.mapper;

import com.caracao718.domain.Flight;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface FlightMapper {

    @Select("select * from flight where origin_location_id = #{originLocationId}")
    List<Flight> list(Flight record);
}
