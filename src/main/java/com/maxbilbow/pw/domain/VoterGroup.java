package com.maxbilbow.pw.domain;

import com.maxbilbow.pw.framework.Generator;
import com.maxbilbow.pwcommon.domain.AbstractDomain;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Max on 08/01/2016.
 */
@Entity
public class VoterGroup extends AbstractDomain<Long>
{


    private String mName;
    private List<Issue> mIssues;
    @Range(min=0)
    private Integer numberOfVoters;
    private VoterGroupStats mVoterGroupStats;
    private IssueImportance mIssueImportance;

    /**
     * Information about gender, family, income, education, etc...
     */
    @OneToOne
    public VoterGroupStats getVoterGroupStats()
    {
        return mVoterGroupStats;
    }


    /**
     * Issue importance should initially be influenced by voterGroupStats.
     * But should change due to world events and some randomness on polling day.
     * E.g. Capitalists on low income would be effected less by a stock marked crash than
     * capitalists with lots of savings (initially at least).
     */
    @OneToOne
    public IssueImportance getIssueImportance()
    {
        return mIssueImportance;
    }


    /**
     * Specific issues this voter group is worried about.
     * How they feel about said issue will be affected by {@link #voterGroupStats} and {@link #issueImportance}
     */
    @OneToMany
    public List<Issue> getIssues()
    {
        return mIssues;
    }

    public static List<VoterGroup> mockVoterGroupList(int size)
    {
        List<VoterGroup>voterGroups = new ArrayList<>();
        int min = 1000/size, max = 1000000/size;
        for (int i=0;i<size;++i)
        {
            voterGroups.add(mock(Generator.randInt(min,max)));
        }
        return voterGroups;
    }


    public static VoterGroup mock(int size)
    {
        VoterGroup voterGroup = new VoterGroup();
        voterGroup.mIssueImportance = IssueImportance.mock();

        voterGroup.mIssues = Issue.mockList();
        voterGroup.mName = "Preston Central";
        voterGroup.mVoterGroupStats = VoterGroupStats.mock(size);

        return voterGroup;
    }
    @NotNull
    public String getName()
    {
        return mName;
    }

    @Transient
    public Integer getPopulationCount()
    {
        return mVoterGroupStats.getPopulation();
    }


    public Integer getNumberOfVoters()
    {
        return numberOfVoters;
    }

    public void setNumberOfVoters(Integer aNumberOfVoters)
    {
        numberOfVoters = aNumberOfVoters;
    }
}
