package com.maxbilbow.pw.framework.math;

import com.maxbilbow.pw.domain.ElectionOpinionPoll;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by Max on 20/02/2016.
 */
public class StatsService
{
  public float calculateMeanAverage(Collection<Integer> aValues)
  {
    int total = 0;
    for(Integer score : aValues)
    {
      total += score;
    }

    return (float)total / aValues.size();
  }

  public Float calculateMedianAverage(List<Integer> aValues)
  {
    if (aValues.isEmpty())
      return 0f;
    if (aValues.size() == 1)
      return Float.valueOf(aValues.get(0));
    List<Integer> values = new ArrayList<>(aValues);
    values.sort(Integer::compare);
    if (aValues.size() %2 != 0)
    {
      return Float.valueOf(values.get(aValues.size() / 2 - 1));
    }
    else
    {
      float m1 = values.get(aValues.size() / 2);
      float m2 = values.get(aValues.size() / 2 - 1);
      return (m1 + m2) / 2;
    }
  }

  public double calculateStandardDeviation(double aMean, List<Integer> aValues)
  {
    double total = 0;
    for(int val : aValues)
    {
      total += Math.pow(((double)val-aMean),2);
    }
    return Math.sqrt(total);
  }

  public Float calculateMeanPollStrength(Collection<ElectionOpinionPoll> aPolls)
  {
    float total = 0;
    for (ElectionOpinionPoll poll : aPolls)
    {
      total += poll.getStrength(false);
    }
    return total / aPolls.size();
  }
}
