package com.maxbilbow.pw.domain.politics;

import com.maxbilbow.pw.domain.GenericDomain;
import com.maxbilbow.pw.domain.voters.Electorate;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Max on 08/01/2016.
 */
@Entity
public class ElectionRegion extends GenericDomain<Long>{


    private String mScreenName;



    private ElectionRegion mParentRegion;


    private List<ElectionRegion> mSubRegions = new ArrayList<>();

    /**
     * Local regions contain an electorate that can consist of
     * many divided social groups.
     *
     * If not a local region, then the electorate is either null
     * or updated with the sub-regions.
     */
    @OneToOne
    private Electorate mElectorate;

    @Column
    public String getScreenName()
    {
        return mScreenName;
    }



    /**
     * Nullable if this is the smallest region, for example.
     */
    @OneToMany
    public List<ElectionRegion> getSubRegions()
    {
        return mSubRegions;
    }

    public Electorate getElectorate()
    {
        return mElectorate;
    }

    public static ElectionRegion UKLocal()
    {
        ElectionRegion region = new ElectionRegion();
        region.mScreenName = "Preston County";
        region.mElectorate = null;//Electorate.mockElectorate();
        region.mSubRegions = new ArrayList<>();
        region.mParentRegion = null;
        return region;

    }


    /**
     * Nullable if has no parent region
     */
    @ManyToOne
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
}
