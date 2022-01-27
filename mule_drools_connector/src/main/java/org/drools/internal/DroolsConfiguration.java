package org.drools.internal;

import org.mule.runtime.extension.api.annotation.Operations;
import org.mule.runtime.extension.api.annotation.connectivity.ConnectionProviders;
import org.mule.runtime.extension.api.annotation.param.Parameter;
import org.mule.runtime.extension.api.annotation.param.display.DisplayName;

import java.io.InputStream;

/**
 * This class represents an extension configuration, values set in this class are commonly used across multiple
 * operations since they represent something core from the extension.
 */
@Operations(DroolsOperations.class)
@ConnectionProviders(DroolsConnectionProvider.class)
public class DroolsConfiguration {

  @Parameter
  private String configId;

  @Parameter
  @DisplayName("DroolsFile")
  private InputStream droolsFile;

  @Parameter
  @DisplayName("KieName")
  private String kieName;


  public InputStream getDroolsFile(){
    return droolsFile;
  }
  public String getKieName() {return kieName;}
  public String getConfigId(){
    return configId;
  }
}
