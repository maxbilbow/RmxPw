package com.maxbilbow.model.campaign;

import org.hibernate.validator.constraints.Range;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

/**
 * Created by Max on 08/01/2016.
 */
@Entity
public class Issue {

    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    private String name;

    @Column(columnDefinition = "text")
    private String description;

    @Range(min = 0,max = 1)
    private Float left;

    @Range(min = 0,max = 1)
    private Float right;

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public Float getLeft()
    {
        return left;
    }

    public void setLeft(Float left)
    {
        this.left = left;
    }

    public Float getRight()
    {
        return right;
    }

    public void setRight(Float right)
    {
        this.right = right;
    }
}
