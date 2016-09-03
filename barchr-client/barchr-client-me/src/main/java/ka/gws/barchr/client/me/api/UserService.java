package ka.gws.barchr.client.me.api;

import ka.gws.barchr.common.to.user.UserTO;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by kally on 2016-09-03.
 */
public interface UserService {

    @POST("users") Call<UserTO> create(@Body UserTO userTO);
}
