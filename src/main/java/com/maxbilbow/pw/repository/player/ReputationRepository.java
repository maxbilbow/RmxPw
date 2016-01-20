package com.maxbilbow.pw.repository.player;

import com.maxbilbow.pw.model.player.Reputation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Max on 20/01/2016.
 */
@Repository
public interface ReputationRepository extends JpaRepository<Reputation,Long> {
}
