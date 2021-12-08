package com.caracao718.mapper;

import com.caracao718.domain.Flight;
import com.caracao718.domain.Trip;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface TripMapper {
    @Select("select count(*) from trip where user_id = #{userId} and flight_id = #{flightId}")
    Integer checkExists(Trip record);

    @Select("select b.*,DATE_FORMAT(start_time,'%Y-%m-%d %H:%i:%s') AS 'startTimeStr',DATE_FORMAT(end_time,'%Y-%m-%d %H:%i:%s') AS 'endTimeStr' " +
            "from trip a join flight b on a.flight_id = b.id " +
            "where a.user_id = #{userId}")
    List<Flight> list(Integer userId);

    @Insert("insert into trip(user_id,flight_id) value(#{userId},#{flightId})")
    int insert(Trip record);
}
