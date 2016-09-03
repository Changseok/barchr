package ka.gws.barchr.client.me;

import ka.gws.barchr.client.me.api.UserService;
import ka.gws.barchr.common.to.user.UserTO;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

import java.io.IOException;

/**
 * Created by kally on 2016-09-03.
 */
public class Client {

    public void execute() {
        Retrofit retrofit = new Retrofit.Builder().baseUrl("http://192.168.0.11:8080/barchr/")
            .addConverterFactory(JacksonConverterFactory.create()).build();

        UserService userService = retrofit.create(UserService.class);
        UserTO userTO = new UserTO();
        userTO.setUserName("sdfsdfsddddf");
        Call<UserTO> userTOCall = userService.create(userTO);
        try {
            Response<UserTO> execute = userTOCall.execute();
            UserTO body = execute.body();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
