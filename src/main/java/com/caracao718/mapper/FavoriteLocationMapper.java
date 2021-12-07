package com.caracao718.mapper;

import com.caracao718.domain.FavoriteLocation;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface FavoriteLocationMapper {
    @Select("select * from favorite_location where id = #{id}")
    FavoriteLocation selectById (Integer id);

    @Select("SELECT c.id AS locationId,c.name AS locationName,a.id " +
            "FROM location c LEFT JOIN favorite_location a ON a.location_id = c.id  ")
    List<FavoriteLocation> list ();

    @Insert("insert into favorite_location(user_id,location_id) " +
            "value(#{userId},#{locationId})")
    int insert (FavoriteLocation record);

    @Delete("delete from favorite_location where id = #{id}")
    int delete (Integer id);
}
