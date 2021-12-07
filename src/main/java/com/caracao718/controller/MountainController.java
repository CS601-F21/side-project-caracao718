package com.caracao718.controller;

import com.caracao718.domain.Mountain;
import com.caracao718.service.MountainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class MountainController {
    @Autowired
    private MountainService mountainService;

    /**
     * Query mountains
     * @return mountain list
     */
    @ResponseBody
    @RequestMapping("/mountain/list")
    public List<Mountain> list () {
        return mountainService.list();
    }

}
