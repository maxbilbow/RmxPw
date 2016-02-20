package com.maxbilbow.pw.domain.player;

import org.hibernate.validator.constraints.Range;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by Max on 08/01/2016.
 */
@Entity
public class Reputation {

    @Id
    @GeneratedValue
    private Long id;

//    @Range(min = 0, max=1)
//    private Float capitalist, socialist, tyrant, libral, anarchist;

    @Range(min = 0, max = 5)
    private Float overallRating;


    public Float getOverallRating()
    {
        return overallRating;
    }

    public void setOverallRating(Float overallRating)
    {
        this.overallRating = overallRating;
    }

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }
}
