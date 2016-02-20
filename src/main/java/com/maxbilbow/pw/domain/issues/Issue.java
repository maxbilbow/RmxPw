package com.maxbilbow.pw.domain.issues;

import com.maxbilbow.pw.domain.GenericDomain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

/**
 * Created by Max on 08/01/2016.
 */
@Entity
public class Issue extends GenericDomain<Long>
{


    private String mName;

    private IssueImportance mIssueImportance;
    private String mDescription;


    @NotNull
    @Column
    public String getName()
    {
        return mName;
    }

    public void setName(String aName)
    {
        this.mName = aName;
    }

    @Column(columnDefinition = "varchar(max)")
    public String getDescription()
    {
        return mDescription;
    }

    public void setDescription(String aDescription)
    {
        mDescription = aDescription;
    }

    /**
     * A list of general political emotians and how relevant this issue is to those
     * Issues will have % of relevance to certain emotions. This is how electorates decide how they feel about those issues.
     */
    @OneToOne
    @Column
    public IssueImportance getIssueImportance()
    {
        return mIssueImportance;
    }

    public void setIssueImportance(IssueImportance aIssueImportance)
    {
        mIssueImportance = aIssueImportance;
    }

    public static List<Issue> mockList()
    {
        return Arrays.asList(mock());
    }

    private static Issue mock()
    {
        Issue issue = new Issue();
        issue.mName = UUID.randomUUID().toString().substring(1,5);
        issue.mDescription = "Randomly Generated issue";
        issue.setIssueImportance(IssueImportance.mock());
        return issue;
    }
}
