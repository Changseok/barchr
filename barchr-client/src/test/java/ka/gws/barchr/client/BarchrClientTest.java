package ka.gws.barchr.client;

import ka.gws.barchr.common.rest.api.service.UserService;

public class BarchrClientTest {

  public static void main(String[] args) {
    new BarchrClientTest().test();
  }
  
  public void test() {
    BarchrClientFactoryBean clientFactoryBean = new BarchrClientFactoryBean();
    clientFactoryBean.setAddress("http://localhost:8080/barchr-rest");
    BarchrClient create = clientFactoryBean.create();
    UserService service = create.getService(UserService.class);
    service.create("name", true);
  }
}
