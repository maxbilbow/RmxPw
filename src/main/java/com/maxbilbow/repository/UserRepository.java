package com.maxbilbow.repository;

import com.maxbilbow.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Max on 08/01/2016.
 */
@Repository
public interface UserRepository extends JpaRepository<User,Long> {
}
