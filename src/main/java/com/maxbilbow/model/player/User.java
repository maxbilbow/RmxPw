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

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
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

    public Reputation getReputation()
    {
        return reputation;
    }

    public void setReputation(Reputation reputation)
    {
        this.reputation = reputation;
    }
}
