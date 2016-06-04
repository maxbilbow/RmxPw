package com.maxbilbow.pw.framework;


import com.maxbilbow.pw.domain.Election;
import com.maxbilbow.pw.domain.ElectionResult;

/**
 * Created by Max on 19/02/2016.
 */
public interface ElectionBallot
{
  ElectionResult ballot(Election aElection);
}
