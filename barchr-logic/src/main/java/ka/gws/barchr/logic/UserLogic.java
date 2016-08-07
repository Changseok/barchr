package ka.gws.barchr.logic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ka.gws.barchr.common.to.ServiceResult;
import ka.gws.barchr.common.to.UserTO;
import ka.gws.barchr.persistence.api.dao.UserDAO;
import ka.gws.barchr.persistence.api.data.UserDataBinder;
import ka.gws.barchr.persistence.api.entity.EntityFactory;
import ka.gws.barchr.persistence.api.entity.user.User;

@Component
public class UserLogic extends AbstractLogic<UserTO> {

  private static final Logger LOGGER = LoggerFactory.getLogger(UserLogic.class);

  @Autowired
  private EntityFactory entityFactory;

  @Autowired
  private UserDAO userDAO;

  @Autowired
  private UserDataBinder userDataBinder;

  public ServiceResult<UserTO> createUser(UserTO userTO) {

    User user = entityFactory.newEntity(User.class);
    user.setName(userTO.getUserName());
    User createdUser = userDAO.save(user);
    LOGGER.error("createUser > {}", createdUser);

    return after(userDataBinder.getUserTO(createdUser));
  }
}
