package com.maxbilbow.model.politics;

import com.maxbilbow.model.campaign.Candidate;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Max on 08/01/2016.
 */
@Entity
public class PoliticalParty {

    @Id
    @GeneratedValue
    private Long id;

    /**
     * The highest level region in which this party operates
     * Usually national (but see SNP)
     */
    @OneToOne
    private ElectionRegion region;

    @OneToMany
    private List<Candidate> candidates;
}
