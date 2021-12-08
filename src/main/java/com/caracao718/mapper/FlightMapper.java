package com.caracao718.mapper;

import com.caracao718.domain.Flight;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface FlightMapper {

    @Select("SELECT a.*,b.name AS 'originLocation',c.name AS 'destinationLocation'," +
            "DATE_FORMAT(a.start_time,'%Y-%m-%d %H:%i:%s') AS 'startTimeStr',DATE_FORMAT(a.end_time,'%Y-%m-%d %H:%i:%s') AS 'endTimeStr' " +
            "FROM flight a JOIN location b ON a.origin_location_id = b.id " +
            "JOIN location c ON a.destination_location_id = c.id " +
            "where a.origin_location_id = #{originLocationId}")
    List<Flight> list(Flight record);
}
