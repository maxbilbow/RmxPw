package com.maxbilbow.pw.control;

import com.maxbilbow.pw.service.PlayerService;
import com.maxbilbow.pw.domain.player.Player;
import com.maxbilbow.pw.domain.player.User;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Max on 20/01/2016.
 */
@Controller
@RequestMapping("/player")
@SessionAttributes({"user", "player"})
public class PlayerController {

    Player player;

    @Autowired
    private PlayerService service;

    private Logger logger = Logger.getLogger(getClass());

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView start(ModelAndView modelAndView,
                              @ModelAttribute User user)
    {
        if (user == null) {
            logger.warn("User was NULL");
            modelAndView.setViewName("welcome");
            return modelAndView;
        }

        logger.info(user + " is logged in");
//        modelAndView.addObject("user",user);

        if (player == null)
            player = service.getPlayer(user);

        modelAndView.addObject("player", player);
        modelAndView.setViewName("player");
        return modelAndView;
    }
}
