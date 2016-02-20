package com.maxbilbow.pw.operation;

import com.maxbilbow.pw.domain.ballot.OpinionPoll;
import com.maxbilbow.pw.domain.campaign.Candidate;
import com.maxbilbow.pw.domain.voters.VoterGroup;

/**
 * Created by Max on 20/02/2016.
 */
public interface OpinionPoller
{

  OpinionPoll pollVoters(VoterGroup aVoterGroup, Candidate aCandidate);
}
