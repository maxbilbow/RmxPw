package com.maxbilbow.pw.domain.dao.player;

import com.maxbilbow.pw.domain.PlayerReputation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Max on 20/01/2016.
 */
@Repository
public interface ReputationRepository extends JpaRepository<PlayerReputation,Long> {
}
