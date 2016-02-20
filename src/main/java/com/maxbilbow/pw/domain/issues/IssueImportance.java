package com.maxbilbow.pw.domain.issues;

import com.maxbilbow.pw.domain.GenericDomain;
import com.maxbilbow.pw.domain.type.PoliticalLeaning;
import com.maxbilbow.pw.operation.Generator;
import org.hibernate.validator.constraints.Range;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Transient;
import java.util.HashMap;
import java.util.Map;

import static com.maxbilbow.pw.domain.type.PoliticalLeaning.PLEnum;
import static com.maxbilbow.pw.domain.type.PoliticalLeaning.PLEnum.Left;
import static com.maxbilbow.pw.domain.type.PoliticalLeaning.PLEnum.Right;

/**
 * Created by Max on 09/01/2016.
 */
@Entity
public class IssueImportance extends GenericDomain<Long>
{

  public HashMap<PoliticalLeaning, Integer> mPoliticalLeaning = new HashMap<>();

  public IssueImportance()
  {
    mPoliticalLeaning.put(Left,0);
    mPoliticalLeaning.put(Right,0);
//    for (PLEnum plEnum : values())
//    {
//      mPoliticalLeaning.put(plEnum, 0);
//    }
  }

  @Range(min = -100, max = 100)
  @Column
  public Integer getLeft()
  {
    return mPoliticalLeaning.get(Left);
  }

  @Transient
  public Integer get(PoliticalLeaning aPoliticalLeaning)
  {
    return mPoliticalLeaning.getOrDefault(aPoliticalLeaning,0);
  }

//  /**
//   * i.e. middle-class women may have a very hight score here.
//   */
//  @Range(min = -100, max = 100)
//  @Column
//  public Integer getChildren()
//  {
//    return mPoliticalLeaning.get(PLEnum.Children);
//  }

  public void setLeft(Integer left)
  {
    mPoliticalLeaning.put(PLEnum.Left, left);
  }

  @Range(min = -100, max = 100)
  @Column
  public Integer getRight()
  {
    return mPoliticalLeaning.get(PLEnum.Right);
  }

  public void setRight(Integer right)
  {
    mPoliticalLeaning.put(PLEnum.Right, right);
    ;
  }

  @Range(min = -100, max = 100)
  @Column
  public Integer getNationalism()
  {
    return mPoliticalLeaning.get(PLEnum.Nationalism);
  }

  public void setNationalism(Integer nationalism)
  {
    mPoliticalLeaning.put(PLEnum.Nationalism, nationalism);
  }

  @Range(min = -100, max = 100)
  @Column
  public Integer getEconomy()
  {
    return mPoliticalLeaning.get(PLEnum.Economy);
  }

  public void setEconomy(Integer economy)
  {
    mPoliticalLeaning.put(PLEnum.Economy, economy);
  }

  @Range(min = -100, max = 100)
  @Column
  public Integer getLiberty()
  {
    return mPoliticalLeaning.get(PLEnum.Liberty);
  }

  public void setLiberty(Integer liberty)
  {
    mPoliticalLeaning.put(PLEnum.Liberty, liberty);
  }

//  @Range(min = -100, max = 100)
//  @Column
//  public Integer getFuture()
//  {
//    return mPoliticalLeaning.get(PLEnum.Future);
//  }
//
//  public void setFuture(Integer future)
//  {
//    mPoliticalLeaning.get(PLEnum.Future);
//  }


  public static IssueImportance mock()
  {
    IssueImportance importance = new IssueImportance();
    importance.getAll().keySet().forEach(k->
            importance.getAll().put(k, Generator.randomOpinion())
    );

    return importance;
  }

  @Transient
  public Map<PoliticalLeaning,Integer> getAll()
  {
    return mPoliticalLeaning;
  }

  public IssueImportance copy()
  {
    IssueImportance importance = new IssueImportance();
    importance.mPoliticalLeaning = (HashMap<PoliticalLeaning, Integer>) mPoliticalLeaning.clone();
    return importance;
  }
}
