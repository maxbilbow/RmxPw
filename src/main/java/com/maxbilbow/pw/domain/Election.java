package com.maxbilbow.pw.domain;

import com.maxbilbow.pwcommon.domain.AbstractDomain;
import org.joda.time.DateTime;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Max on 08/01/2016.
 */
@Entity
public class Election extends AbstractDomain<Long>
{

  private DateTime         mElectionDay;
  private List<Candidate>  mCandidates;
  private ElectionScope    mElectionScope;
  private ElectionRegion   mElectionRegion;
  private List<VoterGroup> mElectorate;


  @OneToOne
  @JoinColumn
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
  @JoinColumn
  public List<Candidate> getCandidates()
  {
    return mCandidates;
  }

  @OneToMany
  @JoinColumn
  public List<VoterGroup>  getElectorate()
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

  public void setElectorate(List<VoterGroup> aElectorate)
  {
    mElectorate = aElectorate;
  }
}
