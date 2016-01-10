package com.maxbilbow.pw.control;

import com.maxbilbow.pw.model.player.User;
import com.maxbilbow.pw.repository.UserRepository;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.Arrays;

/**
 * Created by Max on 08/01/2016.
 */
@Controller
@RequestMapping("/")
@SessionAttributes("user")
public class WelcomeController {

    private Logger logger = Logger.getLogger(this.getClass());

    private User user;

    @Resource
    private UserRepository repository;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView get(ModelAndView modelAndView)
    {
        modelAndView.setViewName("welcome");
        return modelAndView;
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ModelAndView registerNewUser(ModelAndView modelAndView,
                                        User user,
                                        BindingResult result)
    {
        modelAndView.setViewName("reg");
        if (result.hasErrors()) {
            logger.warn(result);
            modelAndView.addObject("errors",result.getAllErrors());
            return modelAndView;
        }

        if (user == null) {
            modelAndView.addObject("errors", Arrays.asList("playerCredentials was null"));
            return modelAndView;
        }

        if (repository.findOne(user.getUsername()) == null)
            repository.save(this.user = user);
        else
            modelAndView.addObject("errors",Arrays.asList("Username " + user.getUsername() + " already exists."));




        return modelAndView;
    }

    @RequestMapping(value = "/log-in",method = RequestMethod.POST)
    public ModelAndView logIn(ModelAndView modelAndView,
                                        User user,
                                        BindingResult result)
    {
        modelAndView.setViewName("log-in");
        if (result.hasErrors()) {
            logger.warn(result);
            modelAndView.addObject("errors",result.getAllErrors());
            return modelAndView;
        }

        if (user == null) {
            modelAndView.addObject("errors", Arrays.asList("user was null"));
            return modelAndView;
        }


        user = repository.verifyUser(user.getUsername(), user.getPassword());
        if (user != null)
            modelAndView.addObject("loggedIn",true);
        else
            modelAndView.addObject("loggedIn",false);

        repository.save(user);

        return modelAndView;
    }

}
