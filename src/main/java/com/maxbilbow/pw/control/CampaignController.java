package com.maxbilbow.pw.control;

import com.maxbilbow.pwcommon.web.controller.AbstractPwController;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Max on 19/01/2016.
 */
@Controller
@RequestMapping("/campaign")
public class CampaignController extends AbstractPwController
{

  private Logger logger = Logger.getLogger(getClass());


  @Override
  public String getViewUrl()
  {
    return "campaign";
  }
}
