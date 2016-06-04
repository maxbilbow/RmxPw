package com.maxbilbow.pw.control;

import com.maxbilbow.pw.domain.Player;
import com.maxbilbow.pw.domain.User;
import com.maxbilbow.pw.domain.service.interfaces.PlayerService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

/**
 * Created by Max on 20/01/2016.
 */
@Controller
@RequestMapping("/player")
@SessionAttributes({"user", "player"})
public class PlayerController
{

  private Player mPlayer;

  @Resource
  private PlayerService mPlayerService;

  private Logger logger = Logger.getLogger(getClass());

  @RequestMapping(method = RequestMethod.GET)
  public ModelAndView start(ModelAndView modelAndView,
                            @ModelAttribute User user)
  {
    if (user == null)
    {
      logger.warn("User was NULL");
      modelAndView.setViewName("welcome");
      return modelAndView;
    }

    logger.info(user + " is logged in");
//        modelAndView.addObject("user",user);

    if (mPlayer == null)
    {
      if (mPlayerService.isEmpty())
      {
        mPlayer = mPlayerService.createNew();
        mPlayer.setName("Generic User");
        mPlayerService.save(mPlayer);
      }
      else {
        mPlayer = mPlayerService.findMostRecent();
      }
    }

    modelAndView.addObject("player", mPlayer);
    modelAndView.setViewName("player");
    return modelAndView;
  }
}
