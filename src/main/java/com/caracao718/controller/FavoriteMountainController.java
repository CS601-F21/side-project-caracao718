package com.caracao718.controller;

import com.caracao718.domain.FavoriteMountain;
import com.caracao718.domain.SysUser;
import com.caracao718.service.FavoriteMountainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class FavoriteMountainController {
    @Autowired
    private FavoriteMountainService favoriteMountainService;

    /**
     * query all mountains
     * @return list
     */
    @ResponseBody
    @RequestMapping("/favorite_mountain/list")
    public List<FavoriteMountain> list () {
        return favoriteMountainService.list();
    }

    /**
     * When add a favorite mountain on web page, this method will execute
     * @param record data from web page
     * @param session http session
     */
    @ResponseBody
    @RequestMapping("/favorite_mountain/add")
    public void add (FavoriteMountain record, HttpSession session) {
        SysUser user = (SysUser)session.getAttribute("loginUser");
        record.setUserId(user.getId());
        favoriteMountainService.insert(record);
    }

    /**
     * When delete a favorite mountain on web page, this method will execute
     * @param record data from web page
     */
    @ResponseBody
    @RequestMapping("/favorite_mountain/delete")
    public void delete (FavoriteMountain record) {
        favoriteMountainService.delete(record.getId());
    }
}
