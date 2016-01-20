package com.maxbilbow.pw.model.issues;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by Max on 08/01/2016.
 */
@Entity
public class Issue  {

    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    private String name;

//    @Column(columnDefinition = "varchar(1000)")
    private String description;

    /**
     * A list of general political emotians and how relevant this issue is to those
     * Issues will have % of relevance to certain emotions. This is how electorates decide how they feel about those issues.
     */
    @OneToOne
    private IssueImportance issueImportance;

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

    public IssueImportance getIssueImportance()
    {
        return issueImportance;
    }

    public void setIssueImportance(IssueImportance issueImportance)
    {
        this.issueImportance = issueImportance;
    }
}
