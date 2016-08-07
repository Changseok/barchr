package ka.gws.barchr.logic;

import ka.gws.barchr.common.to.AbstractTO;
import ka.gws.barchr.common.to.ServiceResult;

public class AbstractLogic<TO extends AbstractTO> {

  protected ServiceResult<TO> after(TO input) {
    TO any = input;

    // Do something...

    ServiceResult<TO> result = new ServiceResult<>();
    result.setResult(any);
    return result;
  }
}
