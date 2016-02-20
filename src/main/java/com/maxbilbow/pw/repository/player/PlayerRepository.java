package com.maxbilbow.pw.repository.player;

import com.maxbilbow.pw.domain.player.Player;
import com.maxbilbow.pw.domain.player.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by Max on 19/01/2016.
 */
public interface PlayerRepository extends JpaRepository<Player, Long> {


    @Query("select p from Player p where p.user = ?1")
    List<Player> getPlayers(User user);

//    @Query("select count(p) from Player p where p.user.username = ?1")
//    int getNumberOfPlayers(String username);

    @Query("select count(p) from Player p where p.user = ?1")
    int getNumberOfPlayers(User user);

//    @Query("select p from Player p where p.user = ?1")
//    Player getOne(User user);
//}
}
