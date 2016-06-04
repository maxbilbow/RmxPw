package com.maxbilbow.pw.framework.ballot;

import com.maxbilbow.pw.domain.ElectionOpinionPoll;
import com.maxbilbow.pw.domain.Campaign;
import com.maxbilbow.pw.domain.Candidate;
import com.maxbilbow.pw.domain.IssueImportance;
import com.maxbilbow.pw.domain.VoterGroup;
import com.maxbilbow.pw.domain.VoterGroupStats;
import com.maxbilbow.pw.framework.Generator;
import com.maxbilbow.pw.framework.OpinionPoller;
import com.maxbilbow.pw.framework.math.StatsService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Max on 20/02/2016.
 */
public class OpinionPollerImpl implements OpinionPoller
{

  protected Generator mGenerator = Generator.INSTANCE;

  protected StatsService mStatsService = new StatsService();

  @Override
  public ElectionOpinionPoll pollVoters(VoterGroup aVoterGroup, Candidate aCandidate)
  {

    IssueImportance candidateIssues =
            aCandidate.getCampaign() == null ? aCandidate.getIssueImportance() : aCandidate.getCampaign().getIssueImportance();
    IssueImportance voterIssues = aVoterGroup.getIssueImportance();
    Map<String,Integer> issueScore = new HashMap<>();


      voterIssues.getAll().forEach((issue,importance) -> {
        int score = scoreIssue(aVoterGroup.getVoterGroupStats(),
                               importance,
                               aCandidate.getCampaign(),
                               candidateIssues.get(issue));

        issueScore.put(issue.getName(),score);
      });

    normalise(issueScore);
    ElectionOpinionPoll poll = new ElectionOpinionPoll();
    poll.setIssueScores(issueScore);
    calculateStats(poll);
    return poll;
  }

  public void calculateStats(ElectionOpinionPoll aPoll)
  {
    List<Integer> values = new ArrayList<>(aPoll.getIssueScores().values());
    float mean, median, max, min;
    aPoll.setMeanAverage(mean = mStatsService.calculateMeanAverage(values));
    aPoll.setMedianAverage(median = mStatsService.calculateMedianAverage(values));
    min = values.get(0);
    max = values.get(values.size()-1);

    double sd = mStatsService.calculateStandardDeviation(mean,values);
//    System.out.println("MIN: " +min + ",  MAX: "+max + ", SD: " + sd);
    aPoll.setStandardDeviation(new Float(sd));
//    );
  }


  public void normalise(Map<String, Integer> aIssueScores)
  {
    final int[] max = {0};
    aIssueScores.values()
            .forEach(val ->
                     {
                       val = Math.abs(val);
                       if (val > max[0])
                       {
                         max[0] = val;
                       }
                     });
    final double scalar = 100 / (double) max[0];
    aIssueScores.forEach((issue, score) -> {
      double normalized = score * scalar;
//      System.out.println(score+" x " +scalar +" = "+normalized);
      aIssueScores.put(issue, (int) normalized);
    });
  }


  protected int scoreIssue(VoterGroupStats stats,
                         Integer aVoterImportance,
                         Campaign aCampaign,
                         Integer aCandidateImportance)
  {
    int score = 0;
    score += compare(aVoterImportance,aCandidateImportance);
    return score;
  }

  protected int compare(Integer aVoterImportance, Integer aCommunication)
  {
    if (aVoterImportance == 0)
      return 0;

    if (aVoterImportance * aCommunication <= 0)
      return disagreeByDiff(aVoterImportance + aCommunication);

    return agreeByMargin(aVoterImportance, aCommunication);
  }

  public int agreeByMargin(int aVoterScore, int aCommsScore)
  {
    if (aVoterScore < 0 )
      aVoterScore *= -1;
    if(aCommsScore < 0)
      aCommsScore *=-1;

    if (aCommsScore > aVoterScore)
      return aVoterScore;

    return aVoterScore - aCommsScore;
  }

  protected int disagreeByDiff(int difference)
  {
    return -difference;
  }


}
