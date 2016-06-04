package com.maxbilbow.pw.config;

import java.util.HashMap;

/**
 * Created by Max on 19/01/2016.
 */

public class AppProperties extends HashMap<String,Object>
{

  public <T>T getAs(String aKey, Class<?extends T> aClass)
  {
    return (T) get(aKey);
  }

  public Number getNumber(String aKey)
  {
    return getAs(aKey,Number.class);
  }
}
