package ka.gws.barchr.rest.cxf.service;

import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ka.gws.barchr.common.rest.api.service.UserService;
import ka.gws.barchr.common.to.ServiceResult;
import ka.gws.barchr.common.to.UserTO;
import ka.gws.barchr.logic.UserLogic;


@Service
public class UserServiceImpl extends AbstractServiceImpl implements UserService {

  @Autowired
  private UserLogic userLogic;

  @Override
  public Response create(UserTO userTO) {
    ServiceResult<UserTO> created = userLogic.createUser(userTO);
    return createResponse(created);
  }
}
