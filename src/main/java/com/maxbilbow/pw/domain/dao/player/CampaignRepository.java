package com.maxbilbow.pw.domain.dao.player;

import com.maxbilbow.pw.domain.Campaign;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Max on 19/01/2016.
 */
@Repository
public interface CampaignRepository extends JpaRepository<Campaign,Long> {

}
