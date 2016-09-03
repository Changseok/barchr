package ka.gws.barchr.persistence.api.data;

import ka.gws.barchr.common.to.user.UserTO;
import ka.gws.barchr.persistence.api.entity.user.User;

public interface UserDataBinder {

    UserTO getUserTO(User user);
}
