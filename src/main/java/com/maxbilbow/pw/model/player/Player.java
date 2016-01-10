package com.maxbilbow.pw.model.player;

import com.maxbilbow.pw.model.campaign.Campaign;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * Created by Max on 08/01/2016.
 *
 * This will be the basic login info
 *
 * AKA Campaign Manager
 */
@Entity
public class Player {


    @Id
    @GeneratedValue
    private Long id;

    /**
     * This links the campaign manager to the player logged in.
     * A player could possibly create many campaign manager profiles... but probably best not at first.
     *
     * This is essentially for login information.
     */
    @OneToOne
    private User user;

    /**
     * Can come from gamecenter etc... but must be unique for game center tables.
     */
    @NotNull
    @Column(unique = true, nullable = false)
    private String campaingManagerName;

    /**
     * Whatever for now. This may link the user to their gameplay?
     * This could be a descriptive bio as seen on nationstates.
     * It should be progmatically determined using the campaign manager's reputation.
     */
    @Transient
    private String profile;

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
