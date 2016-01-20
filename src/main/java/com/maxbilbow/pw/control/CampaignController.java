package com.maxbilbow.pw.control;

import com.maxbilbow.pw.dao.CampaignService;
import com.maxbilbow.pw.model.player.Player;
import com.maxbilbow.pw.model.player.User;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Max on 19/01/2016.
 */
@Controller
@RequestMapping("/campaign")
@SessionAttributes({"user", "player"})
public class CampaignController {


    Player player;

    @Autowired
    private CampaignService service;

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
        modelAndView.setViewName("campaign");
        return modelAndView;
    }
}
