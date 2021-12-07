package com.caracao718.mapper;

import com.caracao718.domain.FavoriteMountain;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface FavoriteMountainMapper {
    @Select("select * from favorite_mountain where id = #{id}")
    FavoriteMountain selectById(Integer id);

    @Select("SELECT l.name AS locationName,c.id AS mountainId,c.name AS mountainName,a.id  " +
            "FROM mountain c LEFT JOIN favorite_mountain a ON a.mountain_id = c.id LEFT JOIN location l ON c.location_id=l.id ")
    List<FavoriteMountain> list();

    @Insert("insert into favorite_mountain(user_id,mountain_id) " +
            "value(#{userId},#{mountainId})")
    int insert(FavoriteMountain record);

    @Delete("delete from favorite_mountain where id = #{id}")
    int delete(Integer id);
}
