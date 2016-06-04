package com.maxbilbow.pw.control;

import com.maxbilbow.pw.domain.Campaign;
import com.maxbilbow.pw.domain.Player;
import com.maxbilbow.pw.domain.service.PlayerServiceImpl;
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
//@SessionAttributes({"user", "player"})
public class CampaignController {


    Campaign campaign;

    @Autowired
    private PlayerServiceImpl service;

    private Logger logger = Logger.getLogger(getClass());

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView start(ModelAndView modelAndView,
                              @ModelAttribute Player player)
    {
        if (player == null) {
            logger.warn("player was NULL");
            modelAndView.setViewName("welcome");
            return modelAndView;
        }

        logger.info(player + " is logged in");
//        modelAndView.addObject("user",user);

        if (campaign == null)
            campaign = player.getActiveCampaign();

        modelAndView.addObject("campaign", campaign);
        modelAndView.setViewName("campaign");
        return modelAndView;
    }
}
