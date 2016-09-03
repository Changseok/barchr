package ka.gws.barchr.persistence.jpa.data;

import ka.gws.barchr.common.to.user.UserTO;
import ka.gws.barchr.persistence.api.data.UserDataBinder;
import ka.gws.barchr.persistence.api.entity.user.User;
import org.springframework.stereotype.Component;

@Component public class UserDataBinderImpl implements UserDataBinder {

    @Override public UserTO getUserTO(User user) {
        UserTO userTO = new UserTO();
        userTO.setKey(user.getId());
        userTO.setUserName(user.getName());
        return userTO;
    }
}
