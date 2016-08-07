package ka.gws.barchr.common.to;

import com.fasterxml.jackson.annotation.JsonTypeInfo;

import ka.gws.barchr.common.AbstractBaseBean;

@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, include = JsonTypeInfo.As.PROPERTY)
public abstract class AbstractTO extends AbstractBaseBean {

  private static final long serialVersionUID = -754311920679872084L;

  private long key;

  public long getKey() {
    return key;
  }

  public void setKey(final long key) {
    this.key = key;
  }
}
