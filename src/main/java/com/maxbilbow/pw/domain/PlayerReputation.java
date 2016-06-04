package com.maxbilbow.pw.domain;

import com.maxbilbow.pwcommon.domain.AbstractDomain;
import org.hibernate.validator.constraints.Range;

/**
 * Created by Max on 08/01/2016.
 */
//@Entity
public class PlayerReputation extends AbstractDomain<Long>
{
  private Integer mOverallRating;

  @Range(min = -100, max = 100)
  public Integer getOverallRating()
  {
    return mOverallRating;
  }
}
