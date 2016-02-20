package com.maxbilbow.pw.operation.ballot;

import com.maxbilbow.pw.domain.ballot.OpinionPoll;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertTrue;

/**
 * Created by Max on 20/02/2016.
 */
public class OpinionPollerImplTest
{

  private OpinionPoll mPoll;
  private OpinionPollerImpl mPoller = new OpinionPollerImpl();

  @Before
  public void setUp()
  {
    mPoll = new OpinionPoll();
    Map<String, Integer> scores = new HashMap<>();
    scores.put("A",100);
    scores.put("B",200);
    scores.put("C",300);
    scores.put("D",400);
    scores.put("E",500);
    mPoller.normalise(scores);
    mPoll.setIssueScores(scores);

  }

  @Test
  public void pollVoters() throws Exception
  {

  }

  @Test
  public void calculateStats() throws Exception
  {
    mPoller.calculateStats(mPoll);
  }

  @Test
  public void normalise() throws Exception
  {
    mPoll.getIssueScores().forEach((k,v)-> {
      System.out.print(k+"="+v+",");
      assertTrue(v <= 100);
    });
  }



  @Test
  public void pickOneGivenVoterIntention() throws Exception
  {

  }

  @Test
  public void agreeByMargin() throws Exception
  {

  }
}