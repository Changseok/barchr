package ka.gws.barchr.logic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ka.gws.barchr.common.to.ServiceResult;
import ka.gws.barchr.common.to.UserTO;
import ka.gws.barchr.persistence.api.dao.UserDAO;
import ka.gws.barchr.persistence.api.entity.EntityFactory;
import ka.gws.barchr.persistence.api.entity.user.User;

@Component
public class UserLogic {

  private static final Logger LOGGER = LoggerFactory.getLogger(UserLogic.class);

  @Autowired
  private EntityFactory entityFactory;

  @Autowired
  private UserDAO userDAO;

  public ServiceResult<UserTO> createUser(String userName) {
    
    User user = entityFactory.newEntity(User.class);
    user.setName(userName);
    User createdUser = userDAO.save(user);
    LOGGER.error("createUser > {}", createdUser);

    UserTO userTO = new UserTO();
    userTO.setKey(createdUser.getKey());
    userTO.setUserName(createdUser.getName());

    ServiceResult<UserTO> result = new ServiceResult<>();
    result.setTO(userTO);
    return result;
  }
}
