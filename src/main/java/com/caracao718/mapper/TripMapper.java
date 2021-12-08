package com.caracao718.mapper;

import com.caracao718.domain.Trip;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface TripMapper {
    @Select("select count(*) from trip where user_id = #{userId} and flight_id = #{flightId}")
    Integer checkExists(Trip record);

    @Select("select * from trip where user_id = #{userId}")
    List<Trip> list(Integer userId);

    @Insert("insert into trip(user_id,flight_id) value(#{userId},#{flightId})")
    int insert(Trip record);
}
