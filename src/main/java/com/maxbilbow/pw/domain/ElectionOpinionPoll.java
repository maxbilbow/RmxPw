package com.maxbilbow.pw.domain;

import com.maxbilbow.pw.framework.Generator;
import com.maxbilbow.pwcommon.domain.AbstractDomain;
import org.joda.time.DateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Transient;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Max on 20/02/2016.
 */
@Entity
public class ElectionOpinionPoll extends AbstractDomain<Long>
{

  private DateTime mPollDate = DateTime.now();
  private Map<String, Integer> mIssueScores = new HashMap<>();
  private float mMeanAverage, mMedianAverage, mStandardDeviation;
  private Integer mStrength = null;
  private VoterGroup mVoterGroup;

  @Column
  public DateTime getPollDate()
  {
    return mPollDate;
  }

  @Column
  public Map<String, Integer> getIssueScores()
  {
    return mIssueScores;
  }

  public void setPollDate(DateTime aPollDate)
  {
    mPollDate = aPollDate;
  }

  public void setIssueScores(Map<String, Integer> aIssueScores)
  {
    mIssueScores = aIssueScores;
  }

  @Column
  public Float getStandardDeviation()
  {
    return mStandardDeviation;
  }

  @Column
  public Float getMedianAverage()
  {
    return mMedianAverage;
  }

  @Column
  public Float getMeanAverage()
  {
    return mMeanAverage;
  }

  public void setMeanAverage(Float aMeanAverage)
  {
    mMeanAverage = aMeanAverage;
  }

  public void setMedianAverage(Float aMedianAverage)
  {
    mMedianAverage = aMedianAverage;
  }

  public void setStandardDeviation(Float aStandardDeviation)
  {
    mStandardDeviation = aStandardDeviation;
  }

  @Transient
  public Integer getStrength(boolean useStandardDeviation)
  {
    if (mStrength != null)
      return mStrength;

    float mean = getMeanAverage();
    if (!useStandardDeviation)
      return mStrength = (int)mean;

//    float median = getMedianAverage();
    float sd = getStandardDeviation();
    int max = (int) (mean + sd / 2);
    int min = (int) (mean - sd / 2);

    return mStrength = Generator.randInt(min, max);
  }

  public VoterGroup getVoterGroup()
  {
    return mVoterGroup;
  }
}
