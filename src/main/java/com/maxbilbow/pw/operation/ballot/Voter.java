package com.maxbilbow.pw.operation.ballot;

import com.maxbilbow.pw.domain.ballot.OpinionPoll;
import com.maxbilbow.pw.domain.campaign.Candidate;
import com.maxbilbow.pw.domain.issues.IssueImportance;
import com.maxbilbow.pw.domain.voters.VoterGroup;
import com.maxbilbow.pw.operation.Generator;

/**
 * Created by Max on 19/02/2016.
 */
public class Voter implements Comparable<Voter>
{
  private Float mScore;

  public IssueImportance getCampaignIssue()
  {
    return mCampaignIssue;
  }

  public IssueImportance getCandidateIssues()
  {
    return mCandidateIssues;
  }

  public Candidate getCandidate()
  {
    return mCandidate;
  }

  public VoterGroup getVoterGroup()
  {
    return mVoterGroup;
  }

  public IssueImportance getVoterIssues()
  {
    return mVoterIssues;
  }

//  private int mVotes = 0;

  @Override
  public int compareTo(Voter o)
  {
//    mVotes++;
    float score = getScore();
    float oScore = o.getScore();
//    updateCampaignStrength(score);
    if (score < oScore)
      return 1;
    if (score > oScore)
      return -1;
    return 0;//Math.random() > 0.5 ? 1 : -1;
  }

//  private int mCompares = 0;
//  private void updateCampaignStrength(int aScore)
//  {
//    mCompares++;
//    float strength = (mCandidate.getCampaign().getStrength() + aScore) / mCompares;
//    mCandidate.getCampaign().setStrength(strength);
//  }

  public OpinionPoll getOpinionPoll()
  {
    return mOpinionPoll;
  }

  public void setOpinionPoll(OpinionPoll aOpinionPoll)
  {
    mOpinionPoll = aOpinionPoll;
    mCandidate.getCampaign().addElectionStat(aOpinionPoll.getVoterGroup(),mOpinionPoll);
    mScore = mOpinionPoll.getMeanAverage();
  }




//  class PLCounter
//  {
//    PoliticalLeaning mIssue;
//    int mScore;
//  }
  private final IssueImportance mCampaignIssue;
  private final IssueImportance mCandidateIssues;
  private final Candidate mCandidate;
  private final VoterGroup mVoterGroup;
  private final IssueImportance mVoterIssues;
//  private final Map<PoliticalLeaning,PLCounter> mIssueCounter;

  private OpinionPoll mOpinionPoll;

  public Voter(Candidate aCandidate, VoterGroup aVoterGroup)
  {
    mCandidate = aCandidate; mVoterGroup = aVoterGroup;
    mVoterIssues = aVoterGroup.getIssueImportance();
    mCampaignIssue = aCandidate.getIssueImportance();
    mCandidateIssues = aCandidate.getCampaign().getIssueImportance();
//    mIssueCounter = new HashMap<>();
  }

  public Float getScore()
  {
    if (false)
      return mScore;

    float mean = mOpinionPoll.getMeanAverage();
    float median = mOpinionPoll.getMedianAverage();
    float sd = mOpinionPoll.getStandardDeviation();
    int max = (int) (mean + sd / 2);
    int min = (int) (mean - sd / 2);
    return Generator.randInt(min,max) * mCandidate.getCampaign().getCommunicationMultiplier();
  }

}
