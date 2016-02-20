package com.maxbilbow.pw.operation.ballot;

import com.maxbilbow.pw.domain.ballot.ElectionResult;
import org.junit.Test;

/**
 * Created by Max on 19/02/2016.
 */
public class ElectionBallotImplTest
{
  
  @Test
  public void ballot() throws Exception
  {

  }

  @Test
  public void mockBallot() throws Exception
  {
    ElectionBallotImpl ballot = ElectionBallotImpl.mockBallot();

    ElectionResult result = ballot.ballot();

    System.out.println(result);
  }
}