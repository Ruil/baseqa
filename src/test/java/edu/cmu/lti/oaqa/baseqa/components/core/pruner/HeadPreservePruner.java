package edu.cmu.lti.oaqa.baseqa.components.core.pruner;

import java.util.Collection;
import java.util.List;

import org.apache.uima.analysis_engine.AnalysisEngineProcessException;

import com.google.common.collect.Lists;

import edu.cmu.lti.oaqa.baseqa.data.gerp.PruningDecisionWrapper;
import edu.cmu.lti.oaqa.baseqa.data.gerp.RankWrapper;
import edu.cmu.lti.oaqa.baseqa.gerpphase.core.pruner.AbstractPruner;

public class HeadPreservePruner extends AbstractPruner {

  @Override
  public List<PruningDecisionWrapper> prune(List<? extends Collection<? extends RankWrapper>> ranks)
          throws AnalysisEngineProcessException {
    List<PruningDecisionWrapper> pruningDecisions = Lists.newArrayList();
    for (int i = 0; i < ranks.size() / 2; i++) {
      pruningDecisions.add(new PruningDecisionWrapper(true));
    }
    for (int i = ranks.size() / 2; i < ranks.size(); i++) {
      pruningDecisions.add(new PruningDecisionWrapper(false));
    }
    return pruningDecisions;
  }

}
