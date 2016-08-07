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
    Response create2 = service.create("name", true);
    ServiceResult<UserTO> readEntity = create2.readEntity(ServiceResult.class);
    System.out.println(readEntity);
  }
}
