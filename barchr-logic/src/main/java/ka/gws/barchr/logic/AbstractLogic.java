package ka.gws.barchr.logic;

import org.springframework.beans.factory.annotation.Autowired;

import ka.gws.barchr.common.to.AbstractTO;
import ka.gws.barchr.common.to.ServiceResult;
import ka.gws.barchr.persistence.api.entity.EntityFactory;

public class AbstractLogic<TO extends AbstractTO> {

  @Autowired
  protected EntityFactory entityFactory;

  protected ServiceResult<TO> result(TO input) {
    TO object = input;
    // Do something...

    ServiceResult<TO> serviceResult = new ServiceResult<>();
    serviceResult.setTO(object);
    return serviceResult;
  }
}
