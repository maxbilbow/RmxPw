package com.maxbilbow.pw.repository.player;

import com.maxbilbow.pw.domain.player.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * Created by Max on 10/01/2016.
 */
@Repository
public interface UserRepository extends JpaRepository<User,String> {


    @Query("select u from User u where u.username = ?1 and u.password = ?2")
    User verifyUser(String username, String password);
}
