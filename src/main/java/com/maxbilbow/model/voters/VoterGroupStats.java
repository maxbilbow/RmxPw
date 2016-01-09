package com.maxbilbow.model.voters;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by Max on 09/01/2016.
 * This takes the place of actual analysed voter data
 */
@Entity
public class VoterGroupStats {

    @Id
    @GeneratedValue
    private Integer id;

    /**
     * Will be compared to national or regional levels. Can be useful for decision making
     */
    private Integer meanAnnualIncome;

    private Integer medianAnnualIncome;

    private Integer averagePersonalDebt;
}
