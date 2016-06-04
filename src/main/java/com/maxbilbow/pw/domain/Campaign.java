package com.maxbilbow.pw.domain;

import com.maxbilbow.pwcommon.domain.AbstractDomain;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Max on 08/01/2016.
 */
//@Entity
public class Campaign extends AbstractDomain<Long>
{
  private Election        mElection;
  private Candidate       mCandidate;
  private IssueImportance mIssueImportance;
  private List<Issue>     mCampaignIssues;

  private Float         mCommunicationMultiplier;
  private Float         mStrength = 0f;
  private Map<VoterGroup,ElectionOpinionPoll> mElectionStats;

  /**
   *
   * @return The Election on which this campaign is fought.
   */
  @ManyToOne
  @JoinColumn
  public Election getElection()
  {
    return mElection;
  }

  @OneToOne
  @JoinColumn
  public Candidate getCandidate()
  {
    return mCandidate;
  }

  /**
   * These are specific issues that a campaign is based around.
   * A shorter list may inspire less people but may have a greater effect on one specific group.
   *
   * This is calculated and used as a way of judging communications.
   *
   * If no effort is put into the campaign, these will default to the candidates issues (but poorly communicated).
   */
  @OneToOne
  @JoinColumn
  public IssueImportance getIssueImportance()
  {
    return mIssueImportance;
  }

  @JoinColumn
  @OneToMany
  public List<Issue> getCampaignIssues()
  {
    return mCampaignIssues;
  }

  /**
   *
   * @return Communication multiplier as a percentage.
   */
  @Min(1)
  @Max(2)
  @Column
  public Float getCommunicationMultiplier()
  {
    return mCommunicationMultiplier;
  }

  public void setCommunicationMultiplier(Float aCommunicationMultiplier)
  {
    mCommunicationMultiplier = aCommunicationMultiplier;
  }
  public void setElection(Election aElection)
  {
    mElection = aElection;
  }

  public void setCandidate(Candidate aCandidate)
  {
    mCandidate = aCandidate;
  }


  public void setCampaignIssues(List<Issue> aCampaignIssues)
  {
    mCampaignIssues = aCampaignIssues;
  }


  public static Campaign mock(Candidate aCandidate)
  {
    Campaign camp = new Campaign();
    camp.mIssueImportance = aCandidate.getIssueImportance().copy();
    camp.mCommunicationMultiplier = 0.5f;
    camp.mCandidate = aCandidate;
    return camp;
  }


  public Float getStrength()
  {
    return mStrength;
  }

  public void setStrength(Float aStrength)
  {
    mStrength = aStrength;
  }

  public void addElectionStat(VoterGroup aVoterGroup, ElectionOpinionPoll aOpinionPoll)
  {
    if (mElectionStats == null)
      mElectionStats = new HashMap<>();
    mElectionStats.put(aVoterGroup,aOpinionPoll);
  }

  @Transient
  public Map<VoterGroup, ElectionOpinionPoll> getElectionStats()
  {
    return mElectionStats;
  }

}
