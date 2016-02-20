package com.maxbilbow.pw.operation.ballot;

import com.maxbilbow.pw.domain.campaign.Candidate;
import com.maxbilbow.pw.domain.issues.IssueImportance;
import com.maxbilbow.pw.domain.type.PoliticalLeaning;
import com.maxbilbow.pw.domain.voters.VoterGroup;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Max on 19/02/2016.
 */
public class Voter implements Comparable<Voter>
{
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

  @Override
  public int compareTo(Voter o)
  {
    if (this.getScore() < o.getScore())
      return 1;
    if (this.getScore() > o.getScore())
      return -1;
    return Math.random() > 0.5 ? 1 : -1;
  }


  class PLCounter
  {
    PoliticalLeaning mIssue;
    int mScore;
  }
  private final IssueImportance mCampaignIssue;
  private final IssueImportance mCandidateIssues;
  private final Candidate mCandidate;
  private final VoterGroup mVoterGroup;
  private final IssueImportance mVoterIssues;
  private final Map<PoliticalLeaning,PLCounter> mIssueCounter;

  public Voter(Candidate aCandidate, VoterGroup aVoterGroup)
  {
    mCandidate = aCandidate; mVoterGroup = aVoterGroup;
    mVoterIssues = aVoterGroup.getIssueImportance();
    mCampaignIssue = aCandidate.getIssueImportance();
    mCandidateIssues = aCandidate.getCampaign().getCampaignIssues();
    mIssueCounter = new HashMap<>();

  }

  int mScore = 0;
  public void scoreIssue(PoliticalLeaning aPoliticalLeaning, int aScore)
  {
//    mIssueCounter.get(aPoliticalLeaning).mScore += aScore;
    mScore += aScore;
  }

  public int getScore()
  {
    return mScore;
  }

  public void setScore(int aScore)
  {
    mScore = aScore;
  }
}
