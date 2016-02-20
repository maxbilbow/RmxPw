package com.maxbilbow.pw.domain.ballot;

import click.rmx.debug.ObjectInspector;
import com.maxbilbow.pw.domain.campaign.Candidate;
import com.maxbilbow.pw.domain.voters.Electorate;
import org.joda.time.DateTime;

import javax.persistence.*;
import java.util.Map;

/**
 * Created by Max on 19/02/2016.
 */
@Entity
public class ElectionResult
{
  private Map<Candidate, Integer> mVoteShare;

  private DateTime mBallotDay;

  private Candidate mWinner;


  private Electorate mElectoate;

  @OneToOne
  @Column
  public Candidate getWinner()
  {
    return mWinner;
  }

//  @Type("org.joda.time.DateTime")
  @Column
  public DateTime getBallotDay()
  {
    return mBallotDay;
  }

  @Lob
  public Map<Candidate, Integer> getVoteShare()
  {
    return mVoteShare;
  }

  public void setVoteShare(Map<Candidate, Integer> aVoteShare)
  {
    mVoteShare = aVoteShare;
  }

  public void setBallotDay(DateTime aBallotDay)
  {
    mBallotDay = aBallotDay;
  }

  public void setWinner(Candidate aWinner)
  {
    mWinner = aWinner;
  }

  public int getSpointBallots()
  {
    return mSpoiledBallots;
  }

  public void setSpoiledBallots(int aSpoiledBallots)
  {
    mSpoiledBallots = aSpoiledBallots;
  }

  private int mSpoiledBallots =1;

  @Transient
  public String getReport()
  {
//    new DateTimeFormatter("dd/MM/yyy");
    final String[] result = {"Election on " + getBallotDay().toString() + "\n"};
    int[] totalVotes = {mSpoiledBallots};
    getVoteShare().values().forEach(n->totalVotes[0]+=n);
    getVoteShare().forEach((aCandidate, aInteger) ->
      result[0] += aCandidate.getName() + ": " +aInteger + " votes ("+(aInteger*100/totalVotes[0])+"%)\n");
    result[0] += "Winner: " + mWinner.getName() + " for the " + mWinner.getPoliticalParty() +
            " with " + mVoteShare.get(mWinner) + " votes out of " + totalVotes[0] + "\n\n";

    result[0] += new ObjectInspector().stringify("On Issues: "+ mWinner.getIssueImportance().getAll()) + "\n";
    mElectoate.getAllSocialClasses().forEach(e->
            result[0]+="\n -> Vs Issues: " + new ObjectInspector().stringify(e.getIssueImportance().getAll())
    );
    return result[0];
  }

  @Override
  public String toString()
  {
    return getReport();
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

  public Electorate getElectoate()
  {
    return mElectoate;
  }

  public void setElectoate(Electorate aElectorate)
  {
    mElectoate = aElectorate;
  }
}
