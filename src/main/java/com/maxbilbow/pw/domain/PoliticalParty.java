package com.maxbilbow.pw.domain;

/**
 * Created by Max on 08/01/2016.
 */
//@Entity
public interface PoliticalParty
{

//  /**
//   * The highest level region in which this party operates
//   * Usually national (but see SNP)
//   */
//  @OneToOne
//  ElectionRegion region();

  String getScreenName();


  enum UK implements PoliticalParty
  {
    Labour, Conservative, LiberalDemocrat("Lib Dem"), Green;

    private String mScreenName;

    UK()
    {
      mScreenName = name();
    }

    UK(String aScreenName)
    {
      mScreenName = aScreenName;
    }



    @Override
    public String getScreenName()
    {
      return mScreenName;
    }
  }
}
