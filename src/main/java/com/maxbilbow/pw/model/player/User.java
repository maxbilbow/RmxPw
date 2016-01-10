package com.maxbilbow.pw.model.player;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

/**
 * Created by Max on 09/01/2016.
 */
@Entity
public class User {

//
//    @Id
//    @GeneratedValue
//    private Long id;


    /**
     * Could be an email address
     */
    @Id
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


    public String getUsername()
    {
        return username;
    }

    public String getPassword()
    {
        return password;
    }
}
