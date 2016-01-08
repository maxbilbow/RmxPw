package com.maxbilbow.control;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Max on 08/01/2016.
 */
@Controller
@RequestMapping("/")
public class WelcomeController {

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView get(ModelAndView modelAndView)
    {
        modelAndView.setViewName("test");
        return modelAndView;
    }

}
