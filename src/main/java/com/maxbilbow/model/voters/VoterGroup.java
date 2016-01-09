package com.maxbilbow.model.voters;

import com.maxbilbow.model.issues.Issue;
import com.maxbilbow.model.issues.IssueImportance;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * Created by Max on 08/01/2016.
 */
@Entity
public class VoterGroup  {

    @Id
    @GeneratedValue
    private Integer id;

    @NotNull
    private String name;

    @Range(min=0)
    private Integer numberOfVoters;

    /**
     * Information about gender, family, income, education, etc...
     */
    @OneToOne
    private VoterGroupStats voterGroupStats;

    /**
     * Issue importance should initially be influenced by voterGroupStats.
     * But should change due to world events and some randomness on polling day.
     * E.g. Capitalists on low income would be effected less by a stock marked crash than
     * capitalists with lots of savings (initially at least).
     */
    @OneToOne
    private IssueImportance issueImportance;

    /**
     * Specific issues this voter group is worried about.
     * How they feel about said issue will be affected by {@link #voterGroupStats} and {@link #issueImportance}
     */
    @OneToMany
    private List<Issue> issuesOfConcern;

}
