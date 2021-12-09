package com.caracao718.mapper;

import com.caracao718.domain.Mountain;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface MountainMapper {
    @Select("select * from mountain where id = #{id}")
    Mountain selectById (Integer id);

    @Select("select a.*,b.name as location_name " +
            "from mountain a join location b on a.location_id = b.id")
    List<Mountain> list ();

    @Select("select a.*,c.name as location_name " +
            "from mountain a join favorite_mountain b on a.id = b.mountain_id " +
            "join location c on a.location_id = c.id")
    List<Mountain> favoriteList1 ();

    @Select("select a.*,c.name as location_name " +
            "from mountain a join favorite_location b on a.location_id = b.location_id " +
            "join location c on a.location_id = c.id")
    List<Mountain> favoriteList2 ();

    @Update("update mountain set weather = #{weather} where id = #{id}")
    void updateWeather (Integer id, String weather);
}
