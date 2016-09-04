package ka.gws.barchr.client.ee;

import ka.gws.barchr.common.to.ServiceResult;
import ka.gws.barchr.common.to.user.UserTO;
import kr.gws.barchr.rest.api.service.UserService;

/**
 * Created by kally on 2016-09-03.
 */
public class BarchrClientTest {

    public static void main(String[] args) {
        new BarchrClientTest().test();
    }

    private void test() {
        BarchrClientFactoryBean clientFactoryBean = new BarchrClientFactoryBean();
        clientFactoryBean.setAddress("http://192.168.0.11:8080/barchr");
        BarchrClient create = clientFactoryBean.create();
        UserService service = create.getService(UserService.class);

        UserTO userTO = new UserTO();
        userTO.setUserName("sdfdssd123");
        ServiceResult<UserTO> response = service.create(userTO);

        //    UserTO created = response.readEntity(new GenericType<ServiceResult<UserTO>>() {}).getTO();
        UserTO created = response.getTO();
        System.out.println(created);
    }

}
