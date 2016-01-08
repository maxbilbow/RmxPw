package com.maxbilbow.model.campaign;

import com.maxbilbow.model.voters.CampaignRegion;
import com.maxbilbow.model.voters.Electorate;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Created by Max on 08/01/2016.
 */
@Entity
public class Campaign {

    @Id
    @GeneratedValue
    private Long id;

    private boolean active;

    private Date electionDay;

    @Range(min = 0, max = 1)
    private Float percentageOfVote;

    @OneToMany
    private List<Issue> issues;

    @OneToOne
    private CampaignRegion campaignRegion;

    private CampaignScope campaignScope;

    @OneToOne
    private Electorate electorate;

    @Range(min = 0,max = 5)
    private Integer rating;

    @OneToOne
    private Candidate candidate;

    public boolean isActive()
    {
        return active;
    }

    public void setActive(boolean active)
    {
        this.active = active;
    }

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public Integer getRating()
    {
        return rating;
    }

    public void setRating(Integer rating)
    {
        this.rating = rating;
    }

    public Date getElectionDay()
    {
        return electionDay;
    }

    public void setElectionDay(Date electionDay)
    {
        this.electionDay = electionDay;
    }

    public Float getPercentageOfVote()
    {
        return percentageOfVote;
    }

    public void setPercentageOfVote(Float percentageOfVote)
    {
        this.percentageOfVote = percentageOfVote;
    }



    public List<Issue> getIssues()
    {
        return issues;
    }

    public void setIssues(List<Issue> issues)
    {
        this.issues = issues;
    }

    public Candidate getCandidate()
    {
        return candidate;
    }

    public void setCandidate(Candidate candidate)
    {
        this.candidate = candidate;
    }
}
