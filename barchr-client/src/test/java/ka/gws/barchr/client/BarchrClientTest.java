package ka.gws.barchr.client;

import org.junit.Test;

import ka.gws.barchr.common.service.UserService;

public class BarchrClientTest {

	@Test
	public void test() {
		BarchrClientFactoryBean clientFactoryBean = new BarchrClientFactoryBean();
		clientFactoryBean.setAddress("http://localhost:8080/barchr-rest");
		BarchrClient create = clientFactoryBean.create();
		UserService service = create.getService(UserService.class);
		service.create("name", true);
	}
}
