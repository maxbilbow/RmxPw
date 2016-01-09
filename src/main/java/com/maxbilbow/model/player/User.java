package com.maxbilbow.model.player;

import com.maxbilbow.model.campaign.Campaign;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * Created by Max on 08/01/2016.
 *
 * This will be the basic login info
 */
@Entity
public class User {


    @Id
    @GeneratedValue
    private Long id;
    /**
     * Could be an email address
     */
    @NotNull
    @Column(unique = true, nullable = false, updatable = true)
    private String username;

    /**
     * Not so important right now.
     * TODO encrypt
     */
    @NotNull
    private String password;

    /**
     * Whatever for now. This may link the user to their gameplay?
     */
    @Transient
    private Object profile;

    @OneToOne
    private Reputation reputation;

    /**
     * A user can only manage one campaign at a time (perhaps). This is the campaign history
     */
    @OneToMany
    private List<Campaign> campaignHistory;

    @OneToOne
    private Campaign activeCampaign;


}
