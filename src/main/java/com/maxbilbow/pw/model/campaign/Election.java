package com.maxbilbow.pw.model.campaign;

import com.maxbilbow.pw.model.issues.Issue;
import com.maxbilbow.pw.model.politics.ElectionRegion;
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

    @OneToOne
    private ElectionRegion electionRegion;

    private ElectionScope electionScope;

    @OneToMany
    private List<Candidate> candidates;

    @Transient
    private List<Issue> issues;
}
