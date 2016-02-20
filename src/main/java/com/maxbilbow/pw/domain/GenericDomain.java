package com.maxbilbow.pw.domain;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by Max on 19/02/2016.
 */
public abstract class GenericDomain<T>
{
  T mId;

  @Id
  @GeneratedValue
  @Column
  public final T getId()
  {
    return mId;
  }

  public final void setId(T aId)
  {
    mId = aId;
  }


}
