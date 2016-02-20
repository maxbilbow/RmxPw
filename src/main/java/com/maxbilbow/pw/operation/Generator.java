package com.maxbilbow.pw.operation;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;

/**
 * Created by Max on 19/02/2016.
 */
@Component
public class Generator
{
  public static Generator INSTANCE;
  static {
    INSTANCE = new Generator();
  }

  final String[] mMaleFirstNames = {
          "Barry", "John", "Mike", "Charles"
  };

  public String getMaleFirstName() {
    return pickOneAtRandom(mMaleFirstNames);
  }

  public <T> T pickOneAtRandom(T[] aObjects)
  {
    int max = aObjects.length;
    int choice = (int) (Math.random() * max);

    return aObjects[choice];
  }

  public <T> T pickOneAtRandom(List<T> aObjects)
  {
    int max = aObjects.size();
    int choice = (int) (Math.random() * max);
//    T[] array = (T[]) aObjects.toArray();
    return aObjects.get(choice);
  }

  public <T> T pickOneAtRandom(Set<T> aObjects)
  {
    int max = aObjects.size();
    int choice = (int) (Math.random() * max);
    int i = 0;
    for (T t:aObjects)
    {
      if (i++ == choice)
        return t;
    }
    return aObjects.stream().findFirst().get();
  }


  public static int randomOpinion()
  {
    return (int) (Math.random() * 200 - 100);
  }
}
