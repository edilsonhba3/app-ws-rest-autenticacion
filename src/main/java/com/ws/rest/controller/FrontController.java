package com.ws.rest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FrontController
{
    @GetMapping({"/","/home"})
    public ModelAndView index()
    {
        ModelAndView mav = new ModelAndView();        
        mav.setViewName("home");
        return mav;
    }

    @GetMapping({"/403","/error"})
    public String error403()
    {
        return "error";
    }

}
