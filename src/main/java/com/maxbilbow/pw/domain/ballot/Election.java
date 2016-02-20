package com.maxbilbow.pw.domain.ballot;

import com.maxbilbow.pw.domain.GenericDomain;
import com.maxbilbow.pw.domain.campaign.Candidate;
import com.maxbilbow.pw.domain.campaign.ElectionScope;
import com.maxbilbow.pw.domain.politics.ElectionRegion;
import com.maxbilbow.pw.domain.voters.Electorate;
import org.joda.time.DateTime;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Max on 08/01/2016.
 */
@Entity
public class Election extends GenericDomain<Long>
{

  private DateTime        mElectionDay;
  private List<Candidate> mCandidates;
  private ElectionScope mElectionScope;
  private ElectionRegion mElectionRegion;
  private Electorate mElectorate;


  @OneToOne
  public ElectionRegion getElectionRegion()
  {
    return mElectionRegion;
  }

  @Enumerated(value = EnumType.STRING)
  @Column
  public ElectionScope getElectionScope()
  {
    return mElectionScope;
  }

  @OneToMany
  public List<Candidate> getCandidates()
  {
    return mCandidates;
  }

  @ManyToOne
  public Electorate getElectorate()
  {
    return mElectorate;
  }

  @Column
  public DateTime getElectionDay()
  {
    return mElectionDay;
  }

  public void setElectionDay(DateTime aElectionDay)
  {
    mElectionDay = aElectionDay;
  }

  public void setCandidates(List<Candidate> aCandidates)
  {
    mCandidates = aCandidates;
  }

  public void setElectionScope(ElectionScope aElectionScope)
  {
    mElectionScope = aElectionScope;
  }

  public void setElectionRegion(ElectionRegion aElectionRegion)
  {
    mElectionRegion = aElectionRegion;
  }

  public void setElectorate(Electorate aElectorate)
  {
    mElectorate = aElectorate;
  }
}
