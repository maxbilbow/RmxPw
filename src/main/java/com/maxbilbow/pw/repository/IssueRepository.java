package com.maxbilbow.pw.repository;

import com.maxbilbow.pw.model.issues.Issue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Max on 08/01/2016.
 */
@Repository
public interface IssueRepository extends JpaRepository<Issue,Long>{
}
