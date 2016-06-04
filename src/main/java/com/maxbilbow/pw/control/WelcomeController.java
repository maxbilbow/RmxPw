package com.maxbilbow.pw.control;

import com.maxbilbow.pw.domain.User;
import com.maxbilbow.pwcommon.web.controller.AbstractPwController;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Max on 08/01/2016.
 */
@Controller
@RequestMapping("/")
public class WelcomeController extends AbstractPwController
{

  private Logger mLogger = Logger.getLogger(this.getClass());

  private User user;

  @Override
  public String getViewUrl()
  {
    return "welcome";
  }

  @RequestMapping(params = "reqType=register", method = RequestMethod.POST)
  public ModelAndView registerNewUser(@RequestParam("user") User user)
  {
    return new ModelAndView("redirect:player");
  }

  @RequestMapping(params = "reqType=login", method = RequestMethod.POST)
  public ModelAndView logIn(@RequestParam("username") String aUsername,
                      @RequestParam("password") String aPassword)
  {
    return new ModelAndView("redirect:/player");
  }

}
