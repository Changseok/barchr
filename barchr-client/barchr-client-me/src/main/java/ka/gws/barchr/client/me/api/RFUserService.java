package ka.gws.barchr.client.me.api;

import ka.gws.barchr.common.to.ServiceResult;
import ka.gws.barchr.common.to.user.UserTO;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by kally on 2016-09-03.
 */
public interface RFUserService {

    @POST("users") Call<ServiceResult<UserTO>> create(@Body UserTO userTO);
}
