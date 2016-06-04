package com.maxbilbow.pw.framework;

import com.maxbilbow.pw.domain.ElectionOpinionPoll;
import com.maxbilbow.pw.domain.Candidate;
import com.maxbilbow.pw.domain.VoterGroup;

/**
 * Created by Max on 20/02/2016.
 */
public interface OpinionPoller
{
  ElectionOpinionPoll pollVoters(VoterGroup aVoterGroup, Candidate aCandidate);
}
