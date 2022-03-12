package org.drools.internal;

import static org.mule.runtime.extension.api.annotation.param.MediaType.ANY;

import org.mule.runtime.extension.api.annotation.param.MediaType;
import org.mule.runtime.extension.api.annotation.param.Config;
import org.mule.runtime.extension.api.annotation.param.Connection;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

import java.io.File;


/**
 * This class is a container for operations, every public method in this class will be taken as an extension operation.
 */
public class DroolsOperations {


  @MediaType(value = ANY, strict = false)
  public <T> void executeRules(Object[] objects, String ksessionName) {
    //return "Using Configuration [" + configuration.getConfigId() + "] with Connection id [" + connection.getId() + "]";

    try {
// load up the knowledge base

      KieServices ks = KieServices.Factory.get();
      KieContainer kContainer = ks.getKieClasspathContainer();
      KieSession kSession = kContainer.newKieSession(ksessionName);
      
      for(Object o : objects)
      {
        ksession.insert(o);
      }
 
      kSession.fireAllRules();
      kSession.dispose();

    } catch (Throwable t) {
      t.printStackTrace();
    }

  }

  /**
   * Private Methods are not exposed as operations
   */

}
