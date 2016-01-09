package com.maxbilbow.model.campaign;

import com.maxbilbow.model.voters.ElectionRegion;
import com.maxbilbow.model.voters.Electorate;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Created by Max on 08/01/2016.
 */
@Entity
public class Election {

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
    private ElectionRegion electionRegion;

    private ElectionScope electionScope;

    @OneToOne
    private Electorate electorate;

    @Range(min = 0,max = 5)
    private Integer rating;

    @OneToMany
    private List<Candidate> candidates;



}
