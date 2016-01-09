package com.maxbilbow.model.campaign;

import javax.persistence.*;

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


}
