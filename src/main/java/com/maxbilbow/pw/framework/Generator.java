package com.maxbilbow.pw.framework;

import com.maxbilbow.pw.framework.math.StatsService;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by Max on 19/02/2016.
 */
@Component
public class Generator
{

  protected StatsService mStatsService = new StatsService();

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

  /**
   * Returns a pseudo-random number between min and max, inclusive.
   * The difference between min and max can be at most
   * <code>Integer.MAX_VALUE - 1</code>.
   *
   * @param min Minimum value
   * @param max Maximum value.  Must be greater than min.
   * @return Integer between min and max, inclusive.
   * @see java.util.Random#nextInt(int)
   */
  public static int randInt(int min, int max) {

    // NOTE: This will (intentionally) not run as written so that folks
    // copy-pasting have to think about how to initialize their
    // Random instance.  Initialization of the Random instance is outside
    // the main scope of the question, but some decent options are to have
    // a field that is initialized once and then re-used as needed or to
    // use ThreadLocalRandom (if using at least Java 1.7).
    Random rand = ThreadLocalRandom.current();

    // nextInt is normally exclusive of the top value,
    // so add 1 to make it inclusive
    int randomNum = rand.nextInt((max - min) + 1) + min;

    return randomNum;
  }
}
