package com.maxbilbow.pw.domain.player;

import com.maxbilbow.pw.domain.GenericDomain;
import com.maxbilbow.pw.domain.campaign.Candidate;
import com.maxbilbow.pw.domain.campaign.Election;
import com.maxbilbow.pw.domain.issues.IssueImportance;
import org.hibernate.validator.constraints.Range;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

/**
 * Created by Max on 08/01/2016.
 */
@Entity
public class Campaign extends GenericDomain<Long>
{

    @ManyToOne
    private Election election;

    @OneToOne
    private Candidate candidate;

    /**
     * These are specific issues that a campaign is based around.
     * A shorter list may inspire less people but may have a greater effect on one specific group.
     */
    @OneToOne
    private IssueImportance mCampaignIssues;



    /**
     * How well is or did this campaign go.
     */
    @Range(min = 0,max = 5)
    private Integer rating;

    public Election getElection()
    {
        return election;
    }

    public void setElection(Election election)
    {
        this.election = election;
    }

    public Candidate getCandidate()
    {
        return candidate;
    }

    public void setCandidate(Candidate candidate)
    {
        this.candidate = candidate;
    }

    public IssueImportance getCampaignIssues()
    {
        return mCampaignIssues;
    }

    public void setCampaignIssues(IssueImportance aCmpaignIssues)
    {
        mCampaignIssues = aCmpaignIssues;
    }

    public Integer getRating()
    {
        return rating;
    }

    public void setRating(Integer rating)
    {
        this.rating = rating;
    }

    public static Campaign mock()
    {
        Campaign camp = new Campaign();
        camp.mCampaignIssues = IssueImportance.mock();
        return camp;
    }


}
