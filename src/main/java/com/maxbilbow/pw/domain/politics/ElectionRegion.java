package com.maxbilbow.pw.domain.politics;

import com.maxbilbow.pw.domain.GenericDomain;
import com.maxbilbow.pw.domain.ballot.ElectionResult;
import com.maxbilbow.pw.domain.voters.Electorate;
import com.maxbilbow.pw.domain.voters.VoterGroup;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Max on 08/01/2016.
 */
@Entity
public class ElectionRegion extends GenericDomain<Long>{


    private String mRegionName;
    private ElectionRegion mParentRegion;
    private List<ElectionRegion> mSubRegions = new ArrayList<>();
    private Electorate mElectorate;
    private List<ElectionResult> mElectionHistory;
    private List<VoterGroup> mAllVoterGroups;

  @Column(nullable = false, unique = true)
    public String getRegionName()
    {
        return mRegionName;
    }

    /**
     * Nullable if this is the smallest region, for example.
     */
    @OneToMany
    @JoinColumn
    public List<ElectionRegion> getSubRegions()
    {
        return mSubRegions;
    }


    /**
     * Local regions contain an electorate that can consist of
     * many divided social groups.
     *
     * If not a local region, then the electorate is either null
     * or updated with the sub-regions.
     */
    @OneToOne
    @JoinColumn
    public Electorate getElectorate()
    {
        return mElectorate;
    }

    @OneToMany
    @JoinColumn
    public List<ElectionResult> getElectionHistory()
    {
        return mElectionHistory;
    }

    /**
     * Nullable if has no parent region
     */
    @ManyToOne
    @JoinColumn
    public ElectionRegion getParentRegion()
    {
        return mParentRegion;
    }


    public void setParentRegion(ElectionRegion aParentRegion)
    {
        mParentRegion = aParentRegion;
    }

    public void setSubRegions(List<ElectionRegion> aSubRegions)
    {
        mSubRegions = aSubRegions;
    }

    public void setElectorate(Electorate aElectorate)
    {
        mElectorate = aElectorate;
    }

    public void setRegionName(String aRegionName)
    {
        mRegionName = aRegionName;
    }

  /**
   *
   * @return All social classes of regions below this one or, if a base level, this electorate's social classes.
   */
  @Transient
  public List<VoterGroup> getVoterGroups()
  {
    if (mSubRegions == null || mSubRegions.isEmpty())
      return mElectorate.getVoterGroups();
    if (mAllVoterGroups == null)
      mAllVoterGroups = new ArrayList<>();
    if (mAllVoterGroups.isEmpty())
    {
      mAllVoterGroups.addAll(mElectorate.getVoterGroups());
      mSubRegions.forEach(aRegion-> mAllVoterGroups.addAll(aRegion.getVoterGroups()));
    }
    return mAllVoterGroups;
  }

    public void setElectionHistory(List<ElectionResult> aElectionHistory)
    {
        mElectionHistory = aElectionHistory;
    }

    public static ElectionRegion UKLocal()
    {
      ElectionRegion region = new ElectionRegion();
      region.mRegionName = "Preston County";
      region.mElectorate = Electorate.mockElectorate(region);
      region.mElectionHistory = new ArrayList<>();
      region.mSubRegions = new ArrayList<>();
      region.mParentRegion = null;
      return region;
    }

}
