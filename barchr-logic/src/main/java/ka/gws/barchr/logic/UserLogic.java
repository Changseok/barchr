package ka.gws.barchr.logic;

import ka.gws.barchr.common.to.ServiceResult;
import ka.gws.barchr.common.to.user.UserTO;
import ka.gws.barchr.persistence.api.dao.UserDAO;
import ka.gws.barchr.persistence.api.data.UserDataBinder;
import ka.gws.barchr.persistence.api.entity.user.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserLogic extends AbstractLogic<UserTO> {

  private static final Logger LOG = LoggerFactory.getLogger(UserLogic.class);

  @Autowired
  private UserDAO userDAO;

  @Autowired
  private UserDataBinder userDataBinder;

  public ServiceResult<UserTO> createUser(UserTO userTO) {
    LOG.info("createUser > {}", userTO);

    User user = entityFactory.newEntity(User.class);
    user.setName(userTO.getUserName());
    User createdUser = userDAO.save(user);

    return result(userDataBinder.getUserTO(createdUser));
  }
}
