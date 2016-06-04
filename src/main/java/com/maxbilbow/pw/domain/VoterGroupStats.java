package com.maxbilbow.pw.domain;

import com.maxbilbow.pwcommon.domain.AbstractDomain;

/**
 * Created by Max on 09/01/2016.
 * This takes the place of actual analysed voter data
 */
//@Entity
public class VoterGroupStats extends AbstractDomain<Long>
{

    /**
     * Will be compared to national or regional levels. Can be useful for decision making
     */
    private Integer mMeanAnnualIncome;

    private Integer mMedianAnnualIncome;

    private Integer mAveragePersonalDebt;

  private Integer mPopulation;

  public static VoterGroupStats mock(int size)
  {
    VoterGroupStats vgs = new VoterGroupStats();
    vgs.mAveragePersonalDebt = 100;
    vgs.mMeanAnnualIncome = 60000;
    vgs.mMedianAnnualIncome = 24000;
    vgs.setPopulation(size);
    return vgs;
  }

  public Integer getPopulation()
  {
    return mPopulation;
  }

  public void setPopulation(Integer aPopulation)
  {
    mPopulation = aPopulation;
  }

  public Integer getAveragePersonalDebt()
  {
    return mAveragePersonalDebt;
  }

  public void setAveragePersonalDebt(Integer aAveragePersonalDebt)
  {
    mAveragePersonalDebt = aAveragePersonalDebt;
  }

  public Integer getMedianAnnualIncome()
  {
    return mMedianAnnualIncome;
  }

  public void setMedianAnnualIncome(Integer aMedianAnnualIncome)
  {
    mMedianAnnualIncome = aMedianAnnualIncome;
  }

  public Integer getMeanAnnualIncome()
  {
    return mMeanAnnualIncome;
  }

  public void setMeanAnnualIncome(Integer aMeanAnnualIncome)
  {
    mMeanAnnualIncome = aMeanAnnualIncome;
  }
}
