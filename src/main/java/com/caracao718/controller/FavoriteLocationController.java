package com.caracao718.controller;

import com.caracao718.domain.FavoriteLocation;
import com.caracao718.domain.SysUser;
import com.caracao718.service.FavoriteLocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class FavoriteLocationController {
    @Autowired
    private FavoriteLocationService favoriteLocationService;

    /**
     * query all locations
     * @return list
     */
    @ResponseBody
    @RequestMapping("/favorite_location/list")
    public List<FavoriteLocation> list () {
        return favoriteLocationService.list();
    }

    /**
     * When add a favorite location on web page, this method will execute
     * @param record data from web page
     * @param session http session
     */
    @ResponseBody
    @RequestMapping("/favorite_location/add")
    public void add (FavoriteLocation record, HttpSession session) {
        SysUser user = (SysUser)session.getAttribute("loginUser");
        record.setUserId(user.getId());
        favoriteLocationService.insert(record);
    }

    /**
     * When delete a favorite location on web page, this method will execute
     * @param record data from web page
     */
    @ResponseBody
    @RequestMapping("/favorite_location/delete")
    public void delete (FavoriteLocation record) {
        favoriteLocationService.delete(record.getId());
    }
}
