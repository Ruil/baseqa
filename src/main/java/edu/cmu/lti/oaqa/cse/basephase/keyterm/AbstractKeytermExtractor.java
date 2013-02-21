/*
 *  Copyright 2012 Carnegie Mellon University
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package edu.cmu.lti.oaqa.cse.basephase.keyterm;

import java.util.List;

import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.jcas.JCas;

import edu.cmu.lti.oaqa.ecd.log.AbstractLoggedComponent;
import edu.cmu.lti.oaqa.framework.BaseJCasHelper;
import edu.cmu.lti.oaqa.framework.QALogEntry;
import edu.cmu.lti.oaqa.framework.data.BaseQAJCasHelper;
import edu.cmu.lti.oaqa.framework.types.InputElement;

/**
 * 
 * @author Zi Yang <ziy@cs.cmu.edu>
 * 
 */
public abstract class AbstractKeytermExtractor extends AbstractLoggedComponent {

  protected abstract List<String> getKeyterms(String question);
  protected abstract List<String> getKeyphrases(String question);

  @Override
  public final void process(JCas jcas) throws AnalysisEngineProcessException {
    super.process(jcas);
    try {
      // prepare input
      InputElement input = (InputElement) BaseJCasHelper.getAnnotation(jcas, InputElement.type);
      String question = input.getQuestion(); 
      // do task
      List<String> keyTerms   = getKeyterms(question);
      List<String> keyPhrases = getKeyphrases(question);
      log("Extracted KeyTerms:   " + keyTerms.toString());
      log("Extracted KeyPhrases: " + keyTerms.toString());
      // save output
      BaseQAJCasHelper.storeKeyTermsAndPhrases(jcas, keyTerms, keyPhrases);
    } catch (Exception e) {
      throw new AnalysisEngineProcessException(e);
    }
  }

  protected final void log(String message) {
    super.log(QALogEntry.KEYTERM, message);
  }

}
