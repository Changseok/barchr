package ka.gws.barchr.client;

import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;

import ka.gws.barchr.common.rest.api.service.UserService;
import ka.gws.barchr.common.to.ServiceResult;
import ka.gws.barchr.common.to.UserTO;

public class BarchrClientTest {

  public static void main(String[] args) {
    new BarchrClientTest().test();
  }

  public void test() {
    BarchrClientFactoryBean clientFactoryBean = new BarchrClientFactoryBean();
    clientFactoryBean.setAddress("http://localhost:8080/barchr-core");
    BarchrClient create = clientFactoryBean.create();
    UserService service = create.getService(UserService.class);

    UserTO userTO = new UserTO();
    userTO.setUserName("keum");
    Response response = service.create(userTO);

    UserTO created = response.readEntity(new GenericType<ServiceResult<UserTO>>() {}).getTO();
    System.out.println(created);
  }
}
