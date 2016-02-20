package com.maxbilbow.pw.service;

import com.maxbilbow.pw.domain.player.Player;
import com.maxbilbow.pw.domain.player.User;

import com.maxbilbow.pw.repository.player.CampaignRepository;
import com.maxbilbow.pw.repository.player.PlayerRepository;
import com.maxbilbow.pw.repository.player.ReputationRepository;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Max on 19/01/2016.
 */
@Service
public class PlayerService {

    private Logger logger = Logger.getLogger(getClass());

    @Resource
    private CampaignRepository campaingRepository;

    @Resource
    private PlayerRepository playerRepository;

    @Resource
    private ReputationRepository reputationRepository;

    public List<Player> getPlayers(User user)
    {
        return playerRepository.getPlayers(user);
    }

    public boolean hasPlayer(User user)
    {
        int games = playerRepository.getNumberOfPlayers(user);
        logger.info(user + " has " + games + " games");
        return games > 0;
    }

    @Transactional
    public Player getPlayer(User user)
    {
        final Player player;
        if (!this.hasPlayer(user)) {
            player = new Player();
            player.setUser(user);
            save(player);
            logger.info("Created new game for " + user);
        } else {
            logger.info(user + " has Games: " + hasPlayer(user));
            player = playerRepository.getPlayers(user).get(0);
            logger.info("Retrieved game for "+user);
        }
        return player;
    }

    @Transactional
    public void save(Player player)
    {
        campaingRepository.save(player.getActiveCampaign());
        reputationRepository.save(player.getReputation());
        playerRepository.save(player);
    }
}