package ka.gws.barchr.client.me;

import ka.gws.barchr.client.me.api.RFUserService;
import ka.gws.barchr.common.to.user.UserTO;

public class RetrofitClientTest {

    public static void main(String[] args) {

        RetrofitClient.Builder builder = new RetrofitClient.Builder();
        builder.baseUrl("http://192.168.0.11:8080/barchr/");

        RetrofitClient client = builder.build();
        RFUserService service = client.getService(RFUserService.class);

        UserTO userTO = new UserTO();
        userTO.setUserName("cskeum3");

        UserTO response = client.execute(service.create(userTO));
        System.out.println(response);
    }
}
