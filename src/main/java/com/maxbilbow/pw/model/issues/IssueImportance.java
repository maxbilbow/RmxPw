package com.maxbilbow.pw.model.issues;

import org.hibernate.validator.constraints.Range;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by Max on 09/01/2016.
 */
@Entity
public class IssueImportance {

    @Id
    @GeneratedValue
    private Long id;

    @Range(min = -100,max = 100)
    private Integer left;

    @Range(min = -100,max = 100)
    private Integer right;

    @Range(min = -100,max = 100)
    private Integer nationalism;

    @Range(min = -100,max = 100)
    private Integer economy;

    @Range(min = -100,max = 100)
    private Integer liberty;

    @Range(min = -100,max = 100)
    private Integer future;

    /**
     * i.e. middle-class women may have a very hight score here.
     */
    @Range(min = -100,max = 100)
    private Integer children;


    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public Integer getLeft()
    {
        return left;
    }

    public void setLeft(Integer left)
    {
        this.left = left;
    }

    public Integer getRight()
    {
        return right;
    }

    public void setRight(Integer right)
    {
        this.right = right;
    }

    public Integer getNationalism()
    {
        return nationalism;
    }

    public void setNationalism(Integer nationalism)
    {
        this.nationalism = nationalism;
    }

    public Integer getEconomy()
    {
        return economy;
    }

    public void setEconomy(Integer economy)
    {
        this.economy = economy;
    }

    public Integer getLiberty()
    {
        return liberty;
    }

    public void setLiberty(Integer liberty)
    {
        this.liberty = liberty;
    }

    public Integer getFuture()
    {
        return future;
    }

    public void setFuture(Integer future)
    {
        this.future = future;
    }

    public Integer getChildren()
    {
        return children;
    }

    public void setChildren(Integer children)
    {
        this.children = children;
    }
}
