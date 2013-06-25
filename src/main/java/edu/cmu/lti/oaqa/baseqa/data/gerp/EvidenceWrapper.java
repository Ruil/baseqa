package edu.cmu.lti.oaqa.baseqa.data.gerp;

import java.util.ArrayList;
import java.util.List;

import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.cas.FSList;
import org.oaqa.model.core.OAQATop;
import org.oaqa.model.gerp.Evidence;

import com.google.common.base.Objects;
import com.google.common.collect.ComparisonChain;

import edu.cmu.lti.oaqa.baseqa.data.core.OAQATopWrapper;
import edu.cmu.lti.oaqa.baseqa.data.core.WrapperHelper;

public class EvidenceWrapper<T extends OAQATop, W extends OAQATopWrapper<T>> extends
        GerpBaseWrapper<Evidence> implements Comparable<EvidenceWrapper<T, W>> {

  private static final long serialVersionUID = 1L;

  protected float confidence;

  protected List<W> additionalEvidences;

  protected Class<W> additionalEvidenceWrapperClass;

  protected EvidenceWrapper() {
    super();
  }

  public EvidenceWrapper(float confidence, Class<W> additionalEvidenceWrapperClass) {
    super();
    this.confidence = confidence;
    this.additionalEvidenceWrapperClass = additionalEvidenceWrapperClass;
    this.additionalEvidences = new ArrayList<W>();
  }

  public EvidenceWrapper(float confidence, W additionalEvidence,
          Class<W> additionalEvidenceWrapperClass) {
    this(confidence, additionalEvidenceWrapperClass);
    this.addAdditionalEvidence(additionalEvidence);
  }

  public void addAdditionalEvidence(W additionalEvidence) {
    this.additionalEvidences.add(additionalEvidence);
  }

  @Override
  public Class<? extends Evidence> getTypeClass() {
    return Evidence.class;
  }

  @Override
  public void wrap(Evidence top) throws AnalysisEngineProcessException {
    super.wrap(top);
    confidence = top.getConfidence();
    additionalEvidences = WrapperHelper.wrapTopList(top.getAdditionalEvidences(),
            additionalEvidenceWrapperClass);
  }

  @Override
  public Evidence unwrap(JCas jcas) throws AnalysisEngineProcessException {
    Evidence top = super.unwrap(jcas);
    top.setConfidence(confidence);
    top.setAdditionalEvidences(WrapperHelper.unwrapTopList(additionalEvidences, jcas));
    return top;
  }

  @Override
  protected void wrapComments(Evidence top) {
    // TODO Auto-generated method stub

  }

  @Override
  protected FSList unwrapComments(JCas jcas) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public int compareTo(EvidenceWrapper<T, W> o) {
    return ComparisonChain.start().compare(confidence, o.confidence).result();
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(confidence, additionalEvidences);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    @SuppressWarnings("rawtypes")
    EvidenceWrapper other = (EvidenceWrapper) obj;
    return Objects.equal(confidence, other.confidence)
            && Objects.equal(additionalEvidences, other.additionalEvidences);
  }

  public float getConfidence() {
    return confidence;
  }

  public void setConfidence(float confidence) {
    this.confidence = confidence;
  }

  public List<W> getAdditionalEvidences() {
    return additionalEvidences;
  }

  public void setAdditionalEvidences(List<W> additionalEvidences) {
    this.additionalEvidences = additionalEvidences;
  }

}
