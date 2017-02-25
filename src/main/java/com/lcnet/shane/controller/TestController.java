package com.lcnet.shane.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by xushaoyin on 2017/2/25.
 */
@Controller
@RequestMapping("/userss")
public class TestController {

    @RequestMapping("/agree")
    public ModelAndView modelAndView(){
        return new ModelAndView("/user_agreement.hmtl");
    }
}
