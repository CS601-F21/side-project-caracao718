package com.caracao718.service;

import com.caracao718.domain.FavoriteMountain;
import com.caracao718.mapper.FavoriteMountainMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FavoriteMountainService {

    @Autowired
    private FavoriteMountainMapper favoriteMountainMapper;

    public FavoriteMountain selectById (Integer id) {
        return favoriteMountainMapper.selectById(id);
    }

    public List<FavoriteMountain> list () {
        return favoriteMountainMapper.list();
    }

    public int insert (FavoriteMountain record) {
        return favoriteMountainMapper.insert(record);
    }

    public int delete (Integer id) {
        return favoriteMountainMapper.delete(id);
    }
}
