package com.caracao718.mapper;

import com.caracao718.domain.Flight;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface FlightMapper {

    @Select("SELECT *,DATE_FORMAT(start_time,'%Y-%m-%d %H:%i:%s') AS 'startTimeStr',DATE_FORMAT(end_time,'%Y-%m-%d %H:%i:%s') AS 'endTimeStr' " +
            "FROM flight where origin_location = #{originLocation}")
    List<Flight> list(Flight record);

    @Select("SELECT *,DATE_FORMAT(start_time,'%Y-%m-%d %H:%i:%s') AS 'startTimeStr',DATE_FORMAT(end_time,'%Y-%m-%d %H:%i:%s') AS 'endTimeStr' FROM flight")
    List<Flight> listAll();
}
