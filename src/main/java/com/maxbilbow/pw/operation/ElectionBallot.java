package com.maxbilbow.pw.operation;


import com.maxbilbow.pw.domain.ballot.Election;
import com.maxbilbow.pw.domain.ballot.ElectionResult;

/**
 * Created by Max on 19/02/2016.
 */
public interface ElectionBallot
{
  ElectionResult ballot(Election aElection);
}
