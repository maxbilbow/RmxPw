package com.maxbilbow.model.voters;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Max on 08/01/2016.
 */
@Entity
public class Electorate {

    @Id
    @GeneratedValue
    private Long id;

    @OneToOne
    private CampaignRegion region;

    @OneToMany
    private List<SocialClass> socialClasses;

    private Float medianIncome, meanIncome, maxIncome, minIncome;


}
