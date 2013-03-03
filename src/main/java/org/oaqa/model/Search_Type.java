
/* First created by JCasGen Sat Mar 02 19:54:39 EST 2013 */
package org.oaqa.model;

import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.cas.impl.CASImpl;
import org.apache.uima.cas.impl.FSGenerator;
import org.apache.uima.cas.FeatureStructure;
import org.apache.uima.cas.impl.TypeImpl;
import org.apache.uima.cas.Type;
import org.apache.uima.cas.impl.FeatureImpl;
import org.apache.uima.cas.Feature;

/** An object that holds a query and results for a search (text search, fact search, KB search, etc.)
 * Updated by JCasGen Sat Mar 02 19:54:39 EST 2013
 * @generated */
public class Search_Type extends OAQATop_Type {
  /** @generated */
  @Override
  protected FSGenerator getFSGenerator() {return fsGenerator;}
  /** @generated */
  private final FSGenerator fsGenerator = 
    new FSGenerator() {
      public FeatureStructure createFS(int addr, CASImpl cas) {
  			 if (Search_Type.this.useExistingInstance) {
  			   // Return eq fs instance if already created
  		     FeatureStructure fs = Search_Type.this.jcas.getJfsFromCaddr(addr);
  		     if (null == fs) {
  		       fs = new Search(addr, Search_Type.this);
  			   Search_Type.this.jcas.putJfsFromCaddr(addr, fs);
  			   return fs;
  		     }
  		     return fs;
        } else return new Search(addr, Search_Type.this);
  	  }
    };
  /** @generated */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = Search.typeIndexID;
  /** @generated 
     @modifiable */
  @SuppressWarnings ("hiding")
  public final static boolean featOkTst = JCasRegistry.getFeatOkTst("org.oaqa.model.Search");
 
  /** @generated */
  final Feature casFeat_query;
  /** @generated */
  final int     casFeatCode_query;
  /** @generated */ 
  public String getQuery(int addr) {
        if (featOkTst && casFeat_query == null)
      jcas.throwFeatMissing("query", "org.oaqa.model.Search");
    return ll_cas.ll_getStringValue(addr, casFeatCode_query);
  }
  /** @generated */    
  public void setQuery(int addr, String v) {
        if (featOkTst && casFeat_query == null)
      jcas.throwFeatMissing("query", "org.oaqa.model.Search");
    ll_cas.ll_setStringValue(addr, casFeatCode_query, v);}
    
  
 
  /** @generated */
  final Feature casFeat_hitList;
  /** @generated */
  final int     casFeatCode_hitList;
  /** @generated */ 
  public int getHitList(int addr) {
        if (featOkTst && casFeat_hitList == null)
      jcas.throwFeatMissing("hitList", "org.oaqa.model.Search");
    return ll_cas.ll_getRefValue(addr, casFeatCode_hitList);
  }
  /** @generated */    
  public void setHitList(int addr, int v) {
        if (featOkTst && casFeat_hitList == null)
      jcas.throwFeatMissing("hitList", "org.oaqa.model.Search");
    ll_cas.ll_setRefValue(addr, casFeatCode_hitList, v);}
    
   /** @generated */
  public int getHitList(int addr, int i) {
        if (featOkTst && casFeat_hitList == null)
      jcas.throwFeatMissing("hitList", "org.oaqa.model.Search");
    if (lowLevelTypeChecks)
      return ll_cas.ll_getRefArrayValue(ll_cas.ll_getRefValue(addr, casFeatCode_hitList), i, true);
    jcas.checkArrayBounds(ll_cas.ll_getRefValue(addr, casFeatCode_hitList), i);
	return ll_cas.ll_getRefArrayValue(ll_cas.ll_getRefValue(addr, casFeatCode_hitList), i);
  }
   
  /** @generated */ 
  public void setHitList(int addr, int i, int v) {
        if (featOkTst && casFeat_hitList == null)
      jcas.throwFeatMissing("hitList", "org.oaqa.model.Search");
    if (lowLevelTypeChecks)
      ll_cas.ll_setRefArrayValue(ll_cas.ll_getRefValue(addr, casFeatCode_hitList), i, v, true);
    jcas.checkArrayBounds(ll_cas.ll_getRefValue(addr, casFeatCode_hitList), i);
    ll_cas.ll_setRefArrayValue(ll_cas.ll_getRefValue(addr, casFeatCode_hitList), i, v);
  }
 
 
  /** @generated */
  final Feature casFeat_abstractQuery;
  /** @generated */
  final int     casFeatCode_abstractQuery;
  /** @generated */ 
  public int getAbstractQuery(int addr) {
        if (featOkTst && casFeat_abstractQuery == null)
      jcas.throwFeatMissing("abstractQuery", "org.oaqa.model.Search");
    return ll_cas.ll_getRefValue(addr, casFeatCode_abstractQuery);
  }
  /** @generated */    
  public void setAbstractQuery(int addr, int v) {
        if (featOkTst && casFeat_abstractQuery == null)
      jcas.throwFeatMissing("abstractQuery", "org.oaqa.model.Search");
    ll_cas.ll_setRefValue(addr, casFeatCode_abstractQuery, v);}
    
  
 
  /** @generated */
  final Feature casFeat_sourceId;
  /** @generated */
  final int     casFeatCode_sourceId;
  /** @generated */ 
  public String getSourceId(int addr) {
        if (featOkTst && casFeat_sourceId == null)
      jcas.throwFeatMissing("sourceId", "org.oaqa.model.Search");
    return ll_cas.ll_getStringValue(addr, casFeatCode_sourceId);
  }
  /** @generated */    
  public void setSourceId(int addr, String v) {
        if (featOkTst && casFeat_sourceId == null)
      jcas.throwFeatMissing("sourceId", "org.oaqa.model.Search");
    ll_cas.ll_setStringValue(addr, casFeatCode_sourceId, v);}
    
  



  /** initialize variables to correspond with Cas Type and Features
	* @generated */
  public Search_Type(JCas jcas, Type casType) {
    super(jcas, casType);
    casImpl.getFSClassRegistry().addGeneratorForType((TypeImpl)this.casType, getFSGenerator());

 
    casFeat_query = jcas.getRequiredFeatureDE(casType, "query", "uima.cas.String", featOkTst);
    casFeatCode_query  = (null == casFeat_query) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_query).getCode();

 
    casFeat_hitList = jcas.getRequiredFeatureDE(casType, "hitList", "uima.cas.FSArray", featOkTst);
    casFeatCode_hitList  = (null == casFeat_hitList) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_hitList).getCode();

 
    casFeat_abstractQuery = jcas.getRequiredFeatureDE(casType, "abstractQuery", "org.oaqa.model.AbstractQuery", featOkTst);
    casFeatCode_abstractQuery  = (null == casFeat_abstractQuery) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_abstractQuery).getCode();

 
    casFeat_sourceId = jcas.getRequiredFeatureDE(casType, "sourceId", "uima.cas.String", featOkTst);
    casFeatCode_sourceId  = (null == casFeat_sourceId) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_sourceId).getCode();

  }
}



    