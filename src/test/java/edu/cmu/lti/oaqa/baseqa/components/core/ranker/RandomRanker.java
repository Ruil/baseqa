package edu.cmu.lti.oaqa.baseqa.components.core.ranker;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.apache.uima.analysis_engine.AnalysisEngineProcessException;

import com.google.common.collect.Lists;

import edu.cmu.lti.oaqa.baseqa.data.gerp.EvidenceWrapper;
import edu.cmu.lti.oaqa.baseqa.data.gerp.RankWrapper;
import edu.cmu.lti.oaqa.baseqa.gerpphase.core.ranker.AbstractRanker;

public class RandomRanker extends AbstractRanker {

  @Override
  public List<RankWrapper> rank(List<? extends Collection<EvidenceWrapper<?, ?>>> evidences)
          throws AnalysisEngineProcessException {
    List<RankWrapper> ranks = Lists.newArrayList();
    for (int i = 0; i < evidences.size(); i++) {
      ranks.add(new RankWrapper(i, (float) Math.exp(-i)));
    }
    Collections.shuffle(ranks);
    return ranks;
  }

}
