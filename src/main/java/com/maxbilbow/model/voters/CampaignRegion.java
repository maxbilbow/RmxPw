package com.maxbilbow.model.voters;

import javax.persistence.*;

/**
 * Created by Max on 08/01/2016.
 */
@Entity
public class CampaignRegion {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    /**
     * Nullable if has no parent region
     */
    @ManyToOne
    private CampaignRegion parentRegion;
}
