package com.maxbilbow.pw.domain.service;

import com.maxbilbow.pw.domain.Campaign;
import com.maxbilbow.pw.domain.service.interfaces.CampaignService;
import com.maxbilbow.pwcommon.domain.service.AbstractPwService;

/**
 * Created by Max on 04/06/2016.
 */
//@Service
public class CampaingServiceImpl extends AbstractPwService<Campaign,Long> implements CampaignService
{

  @Override
  public Campaign createNew()
  {
    return new Campaign();
  }
}
