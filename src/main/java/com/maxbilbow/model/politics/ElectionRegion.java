package com.maxbilbow.model.politics;

import com.maxbilbow.model.voters.Electorate;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Max on 08/01/2016.
 */
@Entity
public class ElectionRegion {

    @Id
    @GeneratedValue
    private Long id;

    private String regionName;

    /**
     * Nullable if has no parent region
     */
    @ManyToOne
    private ElectionRegion parentRegion;

    /**
     * Nullable if this is the smallest region, for example.
     */
    @OneToMany
    private List<ElectionRegion> subRegions;


    /**
     * Local regions contain an electorate that can consist of
     * many divided social groups.
     *
     * If not a local region, then the electorate is either null
     * or updated with the sub-regions.
     */
    @OneToOne
    private Electorate electorate;

    public List<ElectionRegion> getSubRegions()
    {
        return subRegions;
    }

    public Electorate getElectorate()
    {
        return electorate;
    }
}
