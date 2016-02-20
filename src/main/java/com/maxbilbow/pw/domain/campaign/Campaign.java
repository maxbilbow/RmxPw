package com.maxbilbow.pw.domain.campaign;

import com.maxbilbow.pw.domain.GenericDomain;
import com.maxbilbow.pw.domain.ballot.Election;
import com.maxbilbow.pw.domain.issues.Issue;
import com.maxbilbow.pw.domain.issues.IssueImportance;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.List;

/**
 * Created by Max on 08/01/2016.
 */
@Entity
public class Campaign extends GenericDomain<Long>
{


  private Election        mElection;
  private Candidate       mCandidate;
  private IssueImportance mIssueImportance;
  private List<Issue>     mCampaignIssues;

  private Float         mCommunicationMultiplier;

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


}
