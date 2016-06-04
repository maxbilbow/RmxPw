package com.maxbilbow.pw.framework.ballot;

import com.maxbilbow.pw.domain.ElectionOpinionPoll;
import com.maxbilbow.pw.domain.Candidate;
import com.maxbilbow.pw.domain.VoterGroup;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Max on 20/02/2016.
 */
public class VoterTest
{
  
  @Test
  public void compareTo() throws Exception
  {
    VoterGroup voterGroup = VoterGroup.mock(1);
    List<Candidate> candidates = Candidate.mockList(4);
    List<Voter> voters = new ArrayList<>();
    candidates.forEach(c->voters.add(new Voter(c, voterGroup)));

    int[] i = {0};
    voters.forEach(v->v.setOpinionPoll(pollWithScores(i[0]++)));
    voters.forEach(v->System.out.println(v.getScore()));
    voters.sort(Voter::compareTo);
    voters.forEach(v->System.out.println(v.getScore()));

    System.out.print("The highest Number is " + voters.get(0).getScore());
  }

  private ElectionOpinionPoll pollWithScores(int i)
  {
    ElectionOpinionPoll poll = new ElectionOpinionPoll();
    poll.setMeanAverage((float) i);
    poll.setMeanAverage((float) i);
    poll.setStandardDeviation((float) i);
    return poll;
  }
}