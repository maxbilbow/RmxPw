package com.maxbilbow.pw.domain.player;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
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

    public Player()
    {
        this.campaingManagerName = "Bob Mills";
    }
    public Player(User user)
    {
        this.campaingManagerName = user.getUsername();
    }

    /**
     * Whatever for now. This may link the user to their gameplay?
     * This could be a descriptive bio as seen on nationstates.
     * It should be progmatically determined using the campaign manager's reputation.
     */
    @Transient
    private String profile;

    @OneToOne
    private Reputation reputation = new Reputation();

    /**
     * A user can only manage one campaign at a time (perhaps). This is the campaign history
     */
    @OneToMany
    private List<Campaign> campaignHistory = new ArrayList<>();

    @OneToOne
    private Campaign activeCampaign = new Campaign();


    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public User getUser()
    {
        return user;
    }

    public void setUser(User user)
    {
        this.user = user;
    }

    public String getCampaingManagerName()
    {
        return campaingManagerName;
    }

    public void setCampaingManagerName(String campaingManagerName)
    {
        this.campaingManagerName = campaingManagerName;
    }

    public String getProfile()
    {
        return profile;
    }

    public void setProfile(String profile)
    {
        this.profile = profile;
    }

    public Reputation getReputation()
    {
        return reputation;
    }

    public void setReputation(Reputation reputation)
    {
        this.reputation = reputation;
    }

    public List<Campaign> getCampaignHistory()
    {
        return campaignHistory;
    }

    public void setCampaignHistory(List<Campaign> campaignHistory)
    {
        this.campaignHistory = campaignHistory;
    }

    public Campaign getActiveCampaign()
    {
        return activeCampaign;
    }

    public void setActiveCampaign(Campaign activeCampaign)
    {
        this.activeCampaign = activeCampaign;
    }
}
