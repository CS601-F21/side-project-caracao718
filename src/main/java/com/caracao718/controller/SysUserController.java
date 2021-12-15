package com.caracao718.controller;

import com.caracao718.domain.FavoriteLocation;
import com.caracao718.domain.SysUser;
import com.caracao718.mapper.FavoriteLocationMapper;
import com.caracao718.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class SysUserController {
    @Autowired
    private SysUserService sysUserService;
    @Autowired
    private FavoriteLocationMapper favoriteLocationMapper;

    /**
     * A method to handle which page will show
     * @param view html page
     * @param model springboot model
     * @param session http session
     * @return the page that springboot will forward to
     */
    @RequestMapping("navigate")
    public String navigate (String view,Integer id, Model model, HttpSession session) {
        // check if user has not signed in, the system will return login page
        if(session.getAttribute("loginUser") == null && !"signup".equals(view)){
            return "login";
        }

        model.addAttribute("id", id);
        return view;
    }

    /**
     * when input http://localhost:8080/, login page will display
     */
    @RequestMapping("/")
    public String mainPage () {
        return "login";
    }

    /**
     * Logout method
     * @param session http session
     * @return login page
     */
    @RequestMapping("logout")
    public String logout (HttpSession session) {
        session.removeAttribute("loginUser"); // remove user session
        return "login";
    }

    /**
     * Login method, will check if the username and password correct
     * @param sysUser A javabean
     * @param model springboot model
     * @param session http session
     * @return user number
     */
    @RequestMapping("login")
    @ResponseBody
    public Integer login (SysUser sysUser, Model model, HttpSession session) {
        List<SysUser> list = sysUserService.selectByPwdAndType(sysUser);
        if(list.size() == 1) {
            session.setAttribute("loginUser", list.get(0));
        }
        return list.size();
    }

    /**
     * Query all users in database
     * @return user list
     */
    @ResponseBody
    @RequestMapping("/user/list")
    public List<SysUser> list () {
        return sysUserService.list();
    }

    /**
     * Sign up method
     * @param user user form data
     * @return row number
     */
    @RequestMapping("/user/save")
    public String save (SysUser user, HttpSession session) {
        sysUserService.insert(user);

        // save my favorite location into table
        FavoriteLocation o = new FavoriteLocation();
        o.setUserId(user.getId());
        o.setLocationId(user.getLocationId());
        favoriteLocationMapper.insert(o);

        return "login";
    }


}
