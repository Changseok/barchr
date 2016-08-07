package ka.gws.barchr.common.to;

import ka.gws.barchr.common.AbstractBaseBean;

public class ServiceResult<A extends AbstractTO> extends AbstractBaseBean {

  private static final long serialVersionUID = 2626825062604846635L;

  private A result;

  public A getResult() {
    return result;
  }

  public ServiceResult<A> setResult(final A result) {
    this.result = result;
    return this;
  }
}
