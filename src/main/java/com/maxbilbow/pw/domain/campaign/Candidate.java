package com.maxbilbow.pw.domain.campaign;

import com.maxbilbow.pw.domain.GenericDomain;
import com.maxbilbow.pw.domain.issues.IssueImportance;
import com.maxbilbow.pw.domain.player.Campaign;
import com.maxbilbow.pw.domain.politics.PoliticalParty;
import com.maxbilbow.pw.operation.Generator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Max on 08/01/2016.
 */
@Entity
public class Candidate extends GenericDomain<Long>{


    private PoliticalParty mPoliticalParty;

    /**
     * Null if this is a new candidate
     */
    private ElectionScope mElectionScope;

    private IssueImportance mIssueImportance;

    private String mName;
    private Campaign mCampaign;

    @Column(nullable = false)
    public String getName()
    {
        return mName;
    }

    public void setName(String aName)
    {
        mName = aName;
    }

    /**
     * Can be null if independent.
     */
    @ManyToOne
    @Column(nullable = true)
    public PoliticalParty getPoliticalParty()
    {
        return mPoliticalParty;
    }

    public void setPoliticalParty(PoliticalParty aPoliticalParty)
    {
        mPoliticalParty = aPoliticalParty;
    }

    @OneToOne
    @Column
    public ElectionScope getElectionScope()
    {
        return mElectionScope;
    }

    public void setElectionScope(ElectionScope aElectionScope)
    {
        mElectionScope = aElectionScope;
    }

    public static Set<Candidate> mockList(int size)
    {
        PoliticalParty[] parties = PoliticalParty.UK.values();
        Set<Candidate> candidates = new HashSet<>();
        for (int i=0;i<size && i<parties.length ;++i)
        {
            candidates.add(mock(parties[i]));
        }
        return candidates;
    }

    private static Candidate mock(PoliticalParty aParty)
    {
        Candidate candidate = new Candidate();
        candidate.setName(Generator.INSTANCE.getMaleFirstName());
        candidate.setIssueImportance(IssueImportance.mock());
        candidate.mElectionScope = ElectionScope.Local;
        candidate.mPoliticalParty = aParty;
        candidate.mCampaign = Campaign.mock();
        return candidate;
    }

    @OneToOne
    @Column
    public Campaign getCampaign()
    {
        return mCampaign;
    }

    public void setIssueImportance(IssueImportance aIssueImportance)
    {
        mIssueImportance = aIssueImportance;
    }

    public IssueImportance getIssueImportance()
    {
        return mIssueImportance;
    }
}