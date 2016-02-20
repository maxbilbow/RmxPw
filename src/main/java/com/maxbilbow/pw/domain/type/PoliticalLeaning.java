package com.maxbilbow.pw.domain.type;

/**
 * Created by Max on 19/02/2016.
 */
public interface PoliticalLeaning
{
  String getKey();

  String getScreenName();

  enum PLEnum implements PoliticalLeaning
  {
    Left("Left Leaning"),
    Right("Right Leaning"),
    Nationalism("Nationalism"),
    Economy("Economic Performance"),
    Liberty("Freedom and Liberty"),
    Future("Futurism"),
    Children("Child Focused");

    private String mScreenName;


    PLEnum(String aScreenName)
    {
      mScreenName = aScreenName;
    }

    @Override
    public String getKey()
    {
      return name();
    }

    @Override
    public String getScreenName()
    {
      return mScreenName;
    }
  }
}
