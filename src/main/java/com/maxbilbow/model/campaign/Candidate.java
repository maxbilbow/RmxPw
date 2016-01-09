package com.maxbilbow.model.campaign;

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

    @ManyToOne
    private PoliticalParty politicalParty;

    /**
     * Null if this is a new candidate
     */
    private ElectionScope currentPosition;

    @ManyToOne
    private Election campaign;

    @Range(min = 0, max = 1)
    private Float left;

    @Range(min = 0, max = 1)
    private Float right;
}
