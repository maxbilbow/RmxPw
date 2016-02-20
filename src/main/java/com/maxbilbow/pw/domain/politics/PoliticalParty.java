package com.maxbilbow.pw.domain.politics;

import javax.persistence.OneToOne;

/**
 * Created by Max on 08/01/2016.
 */
//@Entity
public interface PoliticalParty  {

    /**
     * The highest level region in which this party operates
     * Usually national (but see SNP)
     */
    @OneToOne
    ElectionRegion region();

    String screenName();


    enum UK implements PoliticalParty
    {
        Labour, Conservative, LiberalDemocrat, Green;

        @Override
        public ElectionRegion region()
        {
            return ElectionRegion.UKLocal();
        }

        @Override
        public String screenName()
        {
            return null;
        }
    }
}
