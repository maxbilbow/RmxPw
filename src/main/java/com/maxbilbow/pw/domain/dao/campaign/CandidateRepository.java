package com.maxbilbow.pw.domain.dao.campaign;

import com.maxbilbow.pw.domain.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Max on 19/01/2016.
 */
@Repository
public interface CandidateRepository extends JpaRepository<Candidate, Long> {
}
