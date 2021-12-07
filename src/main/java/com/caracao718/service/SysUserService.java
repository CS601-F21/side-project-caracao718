package com.caracao718.service;

import com.caracao718.domain.SysUser;
import com.caracao718.mapper.SysUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysUserService {

    @Autowired
    private SysUserMapper sysUserMapper;

    public List<SysUser> selectByPwdAndType(SysUser record){
        return sysUserMapper.selectByPwdAndType(record);
    }

    public SysUser selectById (Integer id) {
        return sysUserMapper.selectById(id);
    }

    public List<SysUser> list () {
        return sysUserMapper.list();
    }

    public int insert (SysUser record) {
        return sysUserMapper.insert(record);
    }

}
