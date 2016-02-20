package com.maxbilbow.pw.operation.ballot;

import com.maxbilbow.pw.domain.ballot.Election;
import com.maxbilbow.pw.domain.ballot.ElectionResult;
import com.maxbilbow.pw.domain.campaign.Candidate;
import com.maxbilbow.pw.domain.voters.VoterGroup;
import com.maxbilbow.pw.operation.ElectionBallot;
import org.joda.time.DateTime;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Max on 19/02/2016.
 */
@Component
public class ElectionBallotImpl extends OpinionPollerImpl implements ElectionBallot
{



  @Override
  public ElectionResult ballot(Election aElection)
  {
    int[] totalVotesCast = {0};
    ElectionResult result = new ElectionResult();

    Map<Candidate,Integer> candidates = new HashMap<>();
    aElection.getCandidates().forEach(c->candidates.put(c,0));

    aElection.getElectionRegion().getVoterGroups().forEach(aVoterGroup ->
            totalVotesCast[0] += vote(candidates,aVoterGroup,result));
    result.setBallotDay(DateTime.now());
    result.setSpoiledBallots(0);
    result.setTotalVotesCast(totalVotesCast[0]);
    result.setVoteShare(candidates);
    result.setWinner(candidates);
    result.setElectionRegion(aElection.getElectionRegion());
    aElection.getCandidates().forEach(aCandidate ->
      aCandidate.getCampaign().setStrength(
              mStatsService.calculateMeanPollStrength(aCandidate.getCampaign().getElectionStats().values())
      )
    );
    return result;
  }


  public int vote(Map<Candidate, Integer> aCandidates, VoterGroup aVoterGroup, ElectionResult aResult)
  {
    int totalPopulation = aVoterGroup.getPopulationCount();
    int total = 0;
    final List<Voter> voters = new ArrayList();
    aCandidates.keySet().forEach(c->voters.add(new Voter(c,aVoterGroup)));
    voters.forEach(aVoter -> {
      aVoter.setOpinionPoll(pollVoters(aVoter.getVoterGroup(),aVoter.getCandidate()));
    });
    for (int i=0;i<totalPopulation;++i)
    {
      Candidate choice = pickOneGivenVoterIntention(voters);
      if (choice == null)
      {
        aResult.setSpoiledBallots(aResult.getSpoiledBallots()+1);
      } else
      {
        int currentTotal = aCandidates.get(choice);
        aCandidates.put(choice,currentTotal+1);
      }
      total++;
    }
    return total;
  }


  public Candidate pickOneGivenVoterIntention(List<Voter> aVoters)
  {


    aVoters.sort(Voter::compareTo);

    return aVoters.get(0).getCandidate();
  }




}
