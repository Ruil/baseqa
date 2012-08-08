package edu.cmu.lti.oaqa.framework.eval.passage;

import java.util.Collections;
import java.util.List;

import org.apache.uima.UimaContext;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.cas.CAS;
import org.apache.uima.cas.text.AnnotationIndex;
import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.tcas.Annotation;
import org.apache.uima.resource.ResourceInitializationException;
import org.oaqa.model.Passage;
import org.uimafit.component.CasConsumer_ImplBase;

import com.google.common.base.Function;
import com.google.common.collect.Ordering;

import edu.cmu.lti.oaqa.ecd.BaseExperimentBuilder;
import edu.cmu.lti.oaqa.ecd.eval.Key;
import edu.cmu.lti.oaqa.ecd.eval.retrieval.EvaluationAggregator;
import edu.cmu.lti.oaqa.ecd.phase.ProcessingStepUtils;
import edu.cmu.lti.oaqa.ecd.phase.Trace;
import edu.cmu.lti.oaqa.framework.ViewManager;
import edu.cmu.lti.oaqa.framework.ViewManager.ViewType;
import edu.cmu.lti.oaqa.framework.eval.retrieval.PassageHelper;
import edu.cmu.lti.oaqa.framework.eval.retrieval.PassageToIdString;
import edu.cmu.lti.oaqa.framework.eval.retrieval.TRECPassageOrdering;
import edu.cmu.lti.oaqa.framework.types.ExperimentUUID;
import edu.cmu.lti.oaqa.framework.types.ProcessingStep;

public class PassageEvalConsumer extends CasConsumer_ImplBase {

  private final Ordering<Passage> ordering = new TRECPassageOrdering();
  
  private final Function<Passage, String> toIdString = new PassageToIdString();

  @SuppressWarnings("rawtypes")
  private List<EvaluationAggregator> aggregators;

  @Override
  public void initialize(UimaContext context) throws ResourceInitializationException {
    Object aggregatorNames = (Object) context.getConfigParameterValue("aggregators");
    if (aggregatorNames != null) {
      this.aggregators = BaseExperimentBuilder.createResourceList(aggregatorNames,
              EvaluationAggregator.class);
    }
  }

  /**
   * Reads the results from the retrieval phase from the DOCUMENT and the DOCUEMNT_GS views of the
   * JCAs, and generates and evaluates them using the evaluate method from the FMeasureConsumer
   * class.
   */
  @Override
  public void process(CAS aCAS) throws AnalysisEngineProcessException {
    try {
      JCas jcas = aCAS.getJCas();
      ExperimentUUID experiment = ProcessingStepUtils.getCurrentExperiment(jcas);
      AnnotationIndex<Annotation> steps = jcas.getAnnotationIndex(ProcessingStep.type);
      Trace trace = ProcessingStepUtils.getTrace(steps);
      JCas view = ViewManager.getView(jcas, ViewType.CANDIDATE);
      JCas gsView = ViewManager.getView(jcas, ViewType.DOCUMENT_GS);
      if (gsView != null) {
        List<Passage> gs = PassageHelper.loadDocumentSet(gsView);
        List<Passage> docs = (view != null) ? PassageHelper.loadDocumentSet(view) : Collections
                .<Passage> emptyList();
        int sequenceId = ProcessingStepUtils.getSequenceId(jcas);
        for (EvaluationAggregator<Passage> aggregator : aggregators) {
          Key key = new Key(experiment.getUuid(), trace, experiment.getStageId());
          aggregator.update(key, sequenceId, docs, gs, ordering, toIdString);
        }
      }
    } catch (Exception e) {
      throw new AnalysisEngineProcessException(e);
    }
  }
}