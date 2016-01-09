package com.maxbilbow.model.issues;

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


}
