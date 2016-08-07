package ka.gws.barchr.persistence.api.data;

import ka.gws.barchr.common.to.UserTO;
import ka.gws.barchr.persistence.api.entity.user.User;

public interface UserDataBinder {

  public UserTO getUserTO(User user);
}
