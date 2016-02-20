package com.maxbilbow.pw.repository.campaign;

import com.maxbilbow.pw.domain.campaign.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Max on 19/01/2016.
 */
@Repository
public interface CandidateRepository extends JpaRepository<Candidate, Long> {
}
