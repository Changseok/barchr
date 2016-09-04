package kr.gws.barchr.rest.api.service;

import ka.gws.barchr.common.to.ServiceResult;
import ka.gws.barchr.common.to.user.UserTO;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("users") public interface UserService extends BaseService {

    @POST @Produces({MediaType.APPLICATION_JSON}) @Consumes({MediaType.APPLICATION_JSON})
    ServiceResult<UserTO> create(UserTO userTO);
}
