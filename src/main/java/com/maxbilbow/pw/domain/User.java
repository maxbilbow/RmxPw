package com.maxbilbow.pw.domain;

import com.maxbilbow.pwcommon.domain.AbstractDomain;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;

/**
 * Created by Max on 09/01/2016.
 */
//@Entity
public class User extends AbstractDomain<Long>
{

  @NotNull
  @NotEmpty
  @Column(unique = true, nullable = false, updatable = true)
  private String username;

  /**
   * Not so important right now.
   * TODO encrypt
   */
  @NotNull
  @NotEmpty
  private String password;

//    @OneToOne
//    private Game game;

  public String getUsername()
  {
    return username;
  }

  public String getPassword()
  {
    return password;
  }

  public void setUsername(String username)
  {
    this.username = username;
  }

  public void setPassword(String password)
  {
    this.password = password;
  }

  @Override
  public String toString()
  {
    return "User: " + username;
  }

}
