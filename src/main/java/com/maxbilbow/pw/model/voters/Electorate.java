package com.maxbilbow.pw.model.voters;

import com.maxbilbow.pw.model.politics.ElectionRegion;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Max on 08/01/2016.
 */
@Entity
public class Electorate {

    @Id
    @GeneratedValue
    private Long id;

    @Transient
    private List<VoterGroup> allSocialClasses;

    @OneToMany
    private List<VoterGroup> socialClasses;

    @OneToOne
    private ElectionRegion electionRegion;

    /**
     *
     * @return All social classes of regions below this one or, if a base level, this electorate's social classes.
     */
    public List<VoterGroup> getAllSocialClasses()
    {
        if (allSocialClasses == null)
            allSocialClasses = new ArrayList<>();
        if (allSocialClasses.isEmpty()) {
            allSocialClasses.addAll(socialClasses);
            electionRegion.getSubRegions().forEach(r->
                allSocialClasses.addAll(r.getElectorate().getAllSocialClasses())
            );
        }
        return allSocialClasses;
    }
}
