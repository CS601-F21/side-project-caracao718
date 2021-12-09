package com.caracao718.service;

import com.caracao718.domain.Mountain;
import com.caracao718.mapper.MountainMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MountainService {

    @Autowired
    private MountainMapper mountainMapper;

    public Mountain selectById (Integer id) {
        return mountainMapper.selectById(id);
    }

    public List<Mountain> list () {
        return mountainMapper.list();
    }

    /**
     * Query my favorite mountain list
     * @return list
     */
    public List<Mountain> favoriteList1 () {
        return mountainMapper.favoriteList1();
    }

    /**
     * Query all the mountains in my favorite location
     * @return list
     */
    public List<Mountain> favoriteList2 () {
        return mountainMapper.favoriteList2();
    }

}
