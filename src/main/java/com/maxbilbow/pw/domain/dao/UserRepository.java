package com.maxbilbow.pw.domain.dao;

import com.maxbilbow.pw.domain.User;
import com.maxbilbow.pwcommon.domain.dao.GenericPwRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * Created by Max on 10/01/2016.
 */
//@Repository
public interface UserRepository extends GenericPwRepository<User, Long>
{
  @Query("select u from User u where u.username = ?1 and u.password = ?2")
  User verifyUser(String username, String password);
}
