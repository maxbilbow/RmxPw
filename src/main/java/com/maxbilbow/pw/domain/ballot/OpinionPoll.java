package com.maxbilbow.pw.domain.ballot;

import com.maxbilbow.pw.domain.GenericDomain;
import org.joda.time.DateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Max on 20/02/2016.
 */
@Entity
public class OpinionPoll extends GenericDomain<Long>
{

  private DateTime mPollDate = DateTime.now();
  private Map<String, Integer> mIssueScores = new HashMap<>();
  private float mMeanAverage, mMedianAverage, mStandardDeviation;


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
}
