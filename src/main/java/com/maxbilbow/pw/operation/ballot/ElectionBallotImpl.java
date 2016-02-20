package com.maxbilbow.pw.operation.ballot;

import com.maxbilbow.pw.domain.ballot.ElectionResult;
import com.maxbilbow.pw.domain.campaign.Candidate;
import com.maxbilbow.pw.domain.issues.IssueImportance;
import com.maxbilbow.pw.domain.type.PoliticalLeaning;
import com.maxbilbow.pw.domain.voters.Electorate;
import com.maxbilbow.pw.domain.voters.VoterGroup;
import com.maxbilbow.pw.domain.voters.VoterGroupStats;
import com.maxbilbow.pw.operation.ElectionBallot;
import com.maxbilbow.pw.operation.Generator;
import org.joda.time.DateTime;

import java.util.*;

/**
 * Created by Max on 19/02/2016.
 */
public class ElectionBallotImpl extends Generator implements ElectionBallot
{

  Stack<ElectionResult> mElectionResults = new Stack<>();

  Set<Candidate> mCandidates = new HashSet<>();

  Electorate mElectorate;

  public ElectionBallotImpl()
  {

  }

  int mTotalVotesCast;

  @Override
  public ElectionResult ballot()
  {
    mTotalVotesCast = 0;
    ElectionResult result = new ElectionResult();

    Map<Candidate,Integer> candidates = new HashMap<>();
    mCandidates.forEach(c->candidates.put(c,0));

    mElectorate.getAllSocialClasses().forEach(aVoterGroup ->
            mTotalVotesCast += vote(candidates,aVoterGroup,result));
    result.setBallotDay(DateTime.now());
    result.setSpoiledBallots(0);
    result.setVoteShare(candidates);
    result.setWinner(candidates);
    return result;
  }





  public int vote(Map<Candidate, Integer> aCandidates, VoterGroup aVoterGroup, ElectionResult aResult)
  {
    int totalPopulation = aVoterGroup.getPopulationCount();
    int total = 0;
    final List<Voter> voters = new ArrayList();
    aCandidates.keySet().forEach(c->voters.add(new Voter(c,aVoterGroup)));

    for (int i=0;i<totalPopulation;++i)
    {
      Candidate choice = pickOneGivenVoterIntention(voters);
      if (choice == null)
      {
        aResult.setSpoiledBallots(aResult.getSpointBallots()+1);
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

    aVoters.forEach(aVoter -> {
      Map<PoliticalLeaning,Integer> campaignIssues = aVoter.getCampaignIssue().getAll();
      Map<PoliticalLeaning,Integer> candidateIssues = aVoter.getCandidateIssues().getAll();
      final IssueImportance issues = aVoter.getVoterIssues();

      issues.getAll().forEach((issue,importance) -> {
        int score = scoreIssue(aVoter.getVoterGroup().getVoterGroupStats(),
                importance,
                campaignIssues.getOrDefault(issue,null),
                candidateIssues.getOrDefault(issue,null));
        aVoter.scoreIssue(issue,score);
      });
    });
    aVoters.sort(Voter::compareTo);

    return aVoters.get(0).getCandidate();
  }

  private int scoreIssue(VoterGroupStats stats,
                         Integer aVoterImportance,
                         Integer aCampaingImportance,
                         Integer aCandidateImportance)
  {
    int score = 0;
    score += compare(aVoterImportance,aCampaingImportance);
    score += compare(aVoterImportance,aCandidateImportance);

    return score;
  }

  private int compare(Integer aVoterImportance, Integer aCommunication)
  {
    if (aVoterImportance == 0)
      return 0;

    if (aVoterImportance * aCommunication <= 0)
      return desagreeByDiff(aVoterImportance + aCommunication);

    return agreeByMargin(aVoterImportance, aCommunication);
  }

  public int agreeByMargin(int aVoterScore, int aCommsScore)
  {
    if (aVoterScore < 0 )
      aVoterScore *= -1;
    if(aCommsScore < 0)
       aCommsScore *=-1;

    if (aCommsScore > aVoterScore)
      return aVoterScore;

    return aVoterScore - aCommsScore;
  }

  private int desagreeByDiff(int difference)
  {
    return -difference;
  }

  public static ElectionBallotImpl mockBallot()
  {
    ElectionBallotImpl ballot = new ElectionBallotImpl();
    ballot.mElectorate = Electorate.mockElectorate();

    ballot.mElectionResults = new Stack<>();

    ballot.mCandidates = Candidate.mockList(6);
    return ballot;

  }
}
