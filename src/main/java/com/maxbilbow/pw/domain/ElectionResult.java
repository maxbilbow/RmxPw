package com.maxbilbow.pw.domain;

import click.rmx.util.ObjectInspector;
import com.maxbilbow.pwcommon.domain.AbstractDomain;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Map;

//import com.maxbilbow.pw.domain.voters.Electorate;

/**
 * Created by Max on 19/02/2016.
 */
//@Entity
public class ElectionResult extends AbstractDomain<Long>
{
  private Map<Candidate, Integer> mVoteShare;

  private Date mBallotDay;

  private Candidate mWinner;

  private Integer mSpoiledBallots = 0;
  private ElectionRegion mElectionRegion;
  private Integer mTotalVotesCast = 0;

  @ManyToOne
  @Column
  public Candidate getWinner()
  {
    return mWinner;
  }

//  @Type("org.joda.time.DateTime")
  @Column
  public Date getBallotDay()
  {
    return mBallotDay;
  }

  @Lob
  public Map<Candidate, Integer> getVoteShare()
  {
    return mVoteShare;
  }

  @ManyToOne
  @JoinColumn
  public ElectionRegion getElectionRegion()
  {
    return mElectionRegion;
  }

  public void setVoteShare(Map<Candidate, Integer> aVoteShare)
  {
    mVoteShare = aVoteShare;
  }

  public void setBallotDay(Date aBallotDay)
  {
    mBallotDay = aBallotDay;
  }

  public void setWinner(Candidate aWinner)
  {
    mWinner = aWinner;
  }

  @Column
  public Integer getSpoiledBallots()
  {
    return mSpoiledBallots;
  }

  public void setSpoiledBallots(int aSpoiledBallots)
  {
    mSpoiledBallots = aSpoiledBallots;
  }



  @Transient
  public String getReport()
  {
    if (mWinner == null)
    {
      return "Election to be held on: " + getBallotDay();
    }
    final ObjectInspector oi = new ObjectInspector();
//    new DateTimeFormatter("dd/MM/yyy");
    final String[] result = {"Election on " + getBallotDay().toString() + "\n"};
    int[] totalVotes = {mSpoiledBallots};
    getVoteShare().values().forEach(n->totalVotes[0]+=n);
    getVoteShare().forEach((aCandidate, aInteger) -> {
      Float strength = aCandidate.getCampaign().getStrength();
      result[0] += aCandidate.getName() + ": " +  +aInteger + " votes ("+(aInteger*100/totalVotes[0])+"%) " +
                   "Strength: "+strength+", on "+
                   oi.stringify(aCandidate.getIssueImportance().getAll())+"\n";
    });
    result[0] += "Winner: " + mWinner.getName() + " for the " + mWinner.getPoliticalParty().getScreenName() +
            " party with " + mVoteShare.get(mWinner) + " votes out of " + totalVotes[0] + "\n\n";

    result[0] += oi.stringify("On Issues: "+ mWinner.getIssueImportance().getAll()) + "\n";
    mElectionRegion.getVoterGroups().forEach(e->
            result[0]+="\n -> Vs Issues: " + oi.stringify(e.getIssueImportance().getAll())
    );
    return result[0];
  }

  public void setWinner(Map<Candidate, Integer> aVoteShare)
  {
    Candidate winner = null; int votes=0;
    for (Candidate candidate: aVoteShare.keySet())
    {
      if(aVoteShare.get(candidate)>votes){
        winner = candidate;
        votes = aVoteShare.get(candidate);
      }
    }
    mWinner = winner;
  }

  @Transient
  public List<VoterGroup> getElectorate()
  {
    return mElectionRegion.getElectorate();
  }

  public void setTotalVotesCast(Integer aTotalVotesCast)
  {
    mTotalVotesCast = aTotalVotesCast;
  }

  public void setElectionRegion(ElectionRegion aElectionRegion)
  {
    mElectionRegion = aElectionRegion;
  }

  public Integer getTotalVotesCast()
  {
    return mTotalVotesCast;
  }

  @Override
  public String toString()
  {
    return getReport();
  }

  public void addToTotalVotesCast(int aVote)
  {
    mTotalVotesCast += aVote;
  }
}
