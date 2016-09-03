package ka.gws.barchr.rest.cxf.service;

import ka.gws.barchr.common.to.ServiceResult;
import ka.gws.barchr.common.to.user.UserTO;
import ka.gws.barchr.logic.UserLogic;
import kr.gws.barchr.rest.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.ws.rs.core.Response;


@Service public class UserServiceImpl extends AbstractServiceImpl implements UserService {

    @Autowired private UserLogic userLogic;

    @Override public Response create(UserTO userTO) {
        ServiceResult<UserTO> created = userLogic.createUser(userTO);
        return createResponse(created);
    }
}
