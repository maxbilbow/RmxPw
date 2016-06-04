package com.maxbilbow.pw.domain;

import com.maxbilbow.pwcommon.domain.AbstractPlayer;

import javax.persistence.Entity;

/**
 * Created by Max on 08/01/2016.
 * <p>
 * This will be the basic login info
 * <p>
 * AKA Campaign Manager
 */
@Entity
public class Player extends AbstractPlayer
{
//  private User           mUser;
//  private PlayerReputation mReputation;

  public Player()
  {
    this.mName = "Bob Mills";
  }
  public Player(User user)
  {
    this.mName = user.getUsername();
  }


  /**
   * This links the campaign manager to the player logged in.
   * A player could possibly create many campaign manager profiles... but probably best not at first.
   * <p>
   * This is essentially for login information.
   */
////  @OneToOne
//  public User getUser()
//  {
//    return mUser;
//  }
//
//
//
////  @OneToOne
//  @Transient
//  public PlayerReputation getReputation()
//  {
//    return mReputation;
//  }
//
//  public void setUser(User aUser)
//  {
//    mUser = aUser;
//  }
}
