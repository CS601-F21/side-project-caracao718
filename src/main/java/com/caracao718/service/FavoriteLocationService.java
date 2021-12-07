package com.caracao718.service;

import com.caracao718.domain.FavoriteLocation;
import com.caracao718.mapper.FavoriteLocationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FavoriteLocationService {

    @Autowired
    private FavoriteLocationMapper favoriteLocationMapper;

    public FavoriteLocation selectById (Integer id) {
        return favoriteLocationMapper.selectById(id);
    }

    public List<FavoriteLocation> list () {
        return favoriteLocationMapper.list();
    }

    public int insert (FavoriteLocation record) {
        return favoriteLocationMapper.insert(record);
    }

    public int delete (Integer id) {
        return favoriteLocationMapper.delete(id);
    }
}
