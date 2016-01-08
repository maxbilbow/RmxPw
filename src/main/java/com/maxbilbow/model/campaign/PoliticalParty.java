package com.maxbilbow.model.campaign;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

/**
 * Created by Max on 08/01/2016.
 */
@Entity
public class PoliticalParty {

    @Id
    @GeneratedValue
    private Long id;

    @OneToMany
    private List<Candidate> candidates;
}
