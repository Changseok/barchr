package ka.gws.barchr.rest.cxf.service;

import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ka.gws.barchr.common.rest.api.service.UserService;
import ka.gws.barchr.common.to.ServiceResult;
import ka.gws.barchr.common.to.UserTO;
import ka.gws.barchr.logic.UserLogic;


@Service
public class UserServiceImpl extends AbstractServiceImpl implements UserService {

  private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

  @Autowired
  private UserLogic userLogic;

  @Override
  public Response create(String name, boolean storePassword) {
    LOGGER.error("create > name : {}, storePassword : {}", name, storePassword);
    ServiceResult<UserTO> created = userLogic.createUser(name);
    return createResponse(created);
  }
}
