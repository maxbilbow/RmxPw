package com.maxbilbow.pw.control;

import com.maxbilbow.pw.domain.Player;
import com.maxbilbow.pw.domain.service.interfaces.PlayerService;
import com.maxbilbow.pwcommon.web.controller.AbstractPwController;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

/**
 * Created by Max on 20/01/2016.
 */
@Controller
@RequestMapping("/player")
@SessionAttributes({"user", "player"})
public class PlayerController extends AbstractPwController

{
  private Player mPlayer;

  @Resource
  private PlayerService mPlayerService;

  private Logger mLogger = Logger.getLogger(getClass());

  public ModelAndView getModelAndView()
  {
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

    return getModelAndView()
            .addObject("player", mPlayer);
  }

  @Override
  public String getViewUrl()
  {
    return "player";
  }


}
