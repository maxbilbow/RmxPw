package com.maxbilbow.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by Max on 08/01/2016.
 *
 * This will be the basic login info
 */
@Entity
public class User {


    @Id
    @GeneratedValue
    private Long id;
    /**
     * Could be an email address
     */
    @NotNull
    @Column(unique = true, nullable = false, updatable = true)
    private String username;

    /**
     * Not so important right now.
     * TODO encrypt
     */
    @NotNull
    private String password;

    /**
     * Whatever for now. This may link the user to their gameplay?
     */
    @Transient
    private Object profile;


    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }
}
