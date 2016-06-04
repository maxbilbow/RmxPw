package com.maxbilbow.pw.domain.dao;

import com.maxbilbow.pw.domain.Player;
import com.maxbilbow.pw.domain.User;
import com.maxbilbow.pwcommon.domain.dao.GenericPwRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Max on 19/01/2016.
 */
@Repository
public interface PlayerRepository extends GenericPwRepository<Player,Long> {

    @Query("select p from Player p where p.user = ?1")
    List<Player> findPlayersForUser(User user);

    @Query("select count(p) from Player p where p.user = ?1")
    int getPlayerCountForUser(User user);

}
