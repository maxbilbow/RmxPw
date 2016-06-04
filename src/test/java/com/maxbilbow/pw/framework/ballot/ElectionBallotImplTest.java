package com.maxbilbow.pw.framework.ballot;

import com.maxbilbow.pw.domain.Election;
import com.maxbilbow.pw.domain.ElectionResult;
import com.maxbilbow.pw.domain.Candidate;
import com.maxbilbow.pw.domain.ElectionRegion;
import com.maxbilbow.pw.domain.PoliticalParty;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Max on 19/02/2016.
 */
public class ElectionBallotImplTest
{
  ElectionBallotImpl mElectionBallot = new ElectionBallotImpl();

  Election mElection;
  @Before
  public void setUp()
  {
    mElection = new Election();
    mElection.setElectionRegion(ElectionRegion.UKLocal(10));
    mElection.setCandidates(Candidate.mockList(PoliticalParty.UK.values().length));
  }

  @Test
  public void ballot() throws Exception
  {

  }

  @Test
  public void mockBallot() throws Exception
  {

    ElectionResult result = mElectionBallot.ballot(mElection);

    System.out.println(result);

    mElection.getElectionRegion().getElectionHistory().add(result);

  }
}