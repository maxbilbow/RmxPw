package com.maxbilbow.model.voters;

import org.hibernate.validator.constraints.Range;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

/**
 * Created by Max on 08/01/2016.
 */
@Entity
public class SocialClass {

    @Id
    @GeneratedValue
    private Integer id;

    @NotNull
    private String name;

    @Range(min = 0, max = 1)
    private Float left;

    @Range(min = 0, max = 1)
    private Float right;

    @Range(min=0)
    private Integer numberOfVoters;

    /**
     * Can include debt.
     */
    private Float meanAnnualIncome;


}
