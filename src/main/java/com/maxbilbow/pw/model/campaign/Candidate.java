package com.maxbilbow.pw.model.campaign;

import com.maxbilbow.pw.model.politics.PoliticalParty;
import org.hibernate.validator.constraints.Range;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

/**
 * Created by Max on 08/01/2016.
 */
@Entity
public class Candidate {

    @Id
    @GeneratedValue
    private Long id;

    /**
     * This will have to be auto generated
     */
    @NotNull
    private String name;

    /**
     * Can be null if independent.
     */
    @ManyToOne
    private PoliticalParty politicalParty;

    /**
     * Null if this is a new candidate
     */
    private ElectionScope currentPosition;

    /**
     * Current current election that this candidate is involved in
     */
    @ManyToOne
    private Election election;

    @Range(min = 0, max = 1)
    private Float left;

    @Range(min = 0, max = 1)
    private Float right;
}
