package com.maxbilbow.pw.model.campaign;

import com.maxbilbow.pw.model.issues.Issue;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Max on 08/01/2016.
 */
@Entity
public class Campaign {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private Election election;

    @OneToOne
    private Candidate candidate;

    /**
     * These are specific issues that a campaign is based around.
     * A shorter list may inspire less people but may have a greater effect on one specific group.
     */
    @OneToMany
    private List<Issue> campaignIssues = new ArrayList<>();

    /**
     * How well is or did this campaign go.
     */
    @Range(min = 0,max = 5)
    private Integer rating;

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

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

    public List<Issue> getCampaignIssues()
    {
        return campaignIssues;
    }

    public void setCampaignIssues(List<Issue> campaignIssues)
    {
        this.campaignIssues = campaignIssues;
    }

    public Integer getRating()
    {
        return rating;
    }

    public void setRating(Integer rating)
    {
        this.rating = rating;
    }
}
