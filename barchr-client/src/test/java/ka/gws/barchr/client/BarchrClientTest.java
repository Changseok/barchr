package ka.gws.barchr.client;

import javax.ws.rs.core.Response;

import ka.gws.barchr.common.rest.api.service.UserService;
import ka.gws.barchr.common.to.ServiceResult;
import ka.gws.barchr.common.to.UserTO;

public class BarchrClientTest {

  public static void main(String[] args) {
    new BarchrClientTest().test();
  }

  @SuppressWarnings("unchecked")
  public void test() {
    BarchrClientFactoryBean clientFactoryBean = new BarchrClientFactoryBean();
    clientFactoryBean.setAddress("http://localhost:8080/barchr-rest");
    BarchrClient create = clientFactoryBean.create();
    UserService service = create.getService(UserService.class);

    UserTO userTO = new UserTO();
    userTO.setUserName("keum");
    Response response = service.create(userTO);
    
    ServiceResult<UserTO> readEntity = response.readEntity(ServiceResult.class);
    System.out.println(readEntity);
  }
}
