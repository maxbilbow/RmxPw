package com.maxbilbow.pw.domain.voters;

import com.maxbilbow.pw.domain.GenericDomain;
import com.maxbilbow.pw.domain.politics.ElectionRegion;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.util.List;

/**
 * Created by Max on 08/01/2016.
 */
@Entity
public class Electorate extends GenericDomain<Long>
{

    private List<VoterGroup> mVoterGroups;


    @OneToMany
    @JoinColumn
    public List<VoterGroup> getVoterGroups()
    {
        return mVoterGroups;
    }


    public void setVoterGroups(List<VoterGroup> aVoterGroups)
    {
        mVoterGroups = aVoterGroups;
    }

    public static Electorate mockElectorate(ElectionRegion mRegion)
    {
        Electorate electorate = new Electorate();
        electorate.mVoterGroups = VoterGroup.mockVoterGroupList(6);
        return electorate;
    }



}
