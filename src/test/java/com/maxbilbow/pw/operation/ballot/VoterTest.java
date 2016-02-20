package com.maxbilbow.pw.operation.ballot;

import com.maxbilbow.pw.domain.campaign.Candidate;
import com.maxbilbow.pw.domain.voters.VoterGroup;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Created by Max on 20/02/2016.
 */
public class VoterTest
{
  
  @Test
  public void compareTo() throws Exception
  {
    VoterGroup voterGroup = VoterGroup.mock();
    Set<Candidate> candidates = Candidate.mockList(4);
    List<Voter> voters = new ArrayList<>();
    candidates.forEach(c->voters.add(new Voter(c, voterGroup)));

    int[] i = {0};
    voters.forEach(v->v.setScore(i[0]++));
    voters.forEach(v->System.out.println(v.getScore()));
    voters.sort(Voter::compareTo);
    voters.forEach(v->System.out.println(v.getScore()));

    System.out.print("The highest Number is " + voters.get(0).getScore());
  }
}