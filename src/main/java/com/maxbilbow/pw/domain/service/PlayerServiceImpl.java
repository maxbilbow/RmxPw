package com.maxbilbow.pw.domain.service;

import com.maxbilbow.pw.domain.Player;
import com.maxbilbow.pw.domain.service.interfaces.PlayerService;
import com.maxbilbow.pwcommon.domain.service.AbstractPwService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

/**
 * Created by Max on 19/01/2016.
 */
@Service
public class PlayerServiceImpl extends AbstractPwService<Player, Long> implements PlayerService
{
  private Logger mLogger = Logger.getLogger(getClass());
}
