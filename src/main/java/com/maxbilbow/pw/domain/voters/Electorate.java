package com.maxbilbow.pw.domain.voters;

import com.maxbilbow.pw.domain.GenericDomain;
import com.maxbilbow.pw.domain.politics.ElectionRegion;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Max on 08/01/2016.
 */
@Entity
public class Electorate extends GenericDomain<Long>
{


    @Transient
    private List<VoterGroup> mAllSocialClasses;


    private List<VoterGroup> mSocialClasses;

    private ElectionRegion mElectoralRegion;

    /**
     *
     * @return All social classes of regions below this one or, if a base level, this electorate's social classes.
     */
    @Transient
    public List<VoterGroup> getAllSocialClasses()
    {
        if (mAllSocialClasses == null)
            mAllSocialClasses = new ArrayList<>();
        if (mAllSocialClasses.isEmpty()) {
            mAllSocialClasses.addAll(mSocialClasses);
            mElectoralRegion.getSubRegions().forEach(r->
                    mAllSocialClasses.addAll(r.getElectorate().getAllSocialClasses())
            );
        }
        return mAllSocialClasses;
    }

    @OneToMany
    @Column
    public List<VoterGroup> getSocialClasses()
    {
        return mSocialClasses;
    }


    public static Electorate mockElectorate()
    {
        Electorate electorate = new Electorate();
        electorate.mSocialClasses = VoterGroup.mockVoterGroupList(6);
        electorate.mElectoralRegion = ElectionRegion.UKLocal();
        return electorate;
    }

    @OneToOne
    @Column
    public ElectionRegion getElectoralRegion()
    {
        return mElectoralRegion;
    }

    public void setElectoralRegion(ElectionRegion aElectoralRegion)
    {
        mElectoralRegion = aElectoralRegion;
    }
}
