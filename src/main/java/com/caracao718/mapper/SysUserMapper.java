package com.caracao718.mapper;

import com.caracao718.domain.SysUser;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface SysUserMapper {
    @Select("select * from sys_user where user_name = #{userName} and password = #{password}")
    List<SysUser> selectByPwdAndType(SysUser record);

    @Select("select * from sys_user where id = #{id}")
    SysUser selectById(Integer id);

    @Select("select * from sys_user")
    List<SysUser> list();

    @Insert("insert into sys_user(user_name,password,first_name,last_name,email,snow_tool) " +
            "value(#{userName},#{password},#{firstName},#{lastName},#{email},#{snowTool})")
    @SelectKey(statement = "select last_insert_id()", before = false, keyProperty = "id", resultType = Integer.class, keyColumn = "id")
    int insert(SysUser record);
}
