package com.maxbilbow.pw.domain.campaign;

import com.maxbilbow.pw.domain.GenericDomain;
import com.maxbilbow.pw.domain.issues.Issue;
import com.maxbilbow.pw.domain.politics.ElectionRegion;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Max on 08/01/2016.
 */
@Entity
public class Election extends GenericDomain<Long>
{

    private boolean active;

    private Date electionDay;

    @Range(min = 0, max = 1)
    private Float percentageOfVote;

    @OneToOne
    private ElectionRegion electionRegion;

    private ElectionScope electionScope;

    @OneToMany
    private List<Candidate> candidates = new ArrayList<>();

    @Transient
    private List<Issue> issues = new ArrayList<>();


    public boolean isActive()
    {
        return active;
    }

    public void setActive(boolean active)
    {
        this.active = active;
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

    public ElectionRegion getElectionRegion()
    {
        return electionRegion;
    }

    public void setElectionRegion(ElectionRegion electionRegion)
    {
        this.electionRegion = electionRegion;
    }

    public ElectionScope getElectionScope()
    {
        return electionScope;
    }

    public void setElectionScope(ElectionScope electionScope)
    {
        this.electionScope = electionScope;
    }

    public List<Candidate> getCandidates()
    {
        return candidates;
    }

    public void setCandidates(List<Candidate> candidates)
    {
        this.candidates = candidates;
    }

    public List<Issue> getIssues()
    {
        return issues;
    }

    public void setIssues(List<Issue> issues)
    {
        this.issues = issues;
    }
}
