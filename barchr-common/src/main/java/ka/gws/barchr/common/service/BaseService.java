package ka.gws.barchr.common.service;

import javax.ws.rs.core.MediaType;

public interface BaseService {

	String APPLICATION_XML = MediaType.APPLICATION_XML + ";qs=0.9";

	String PARAM_FIQL = "fiql";

	String PARAM_PAGE = "page";

	String PARAM_SIZE = "size";

	String PARAM_ORDERBY = "orderby";

	String PARAM_RESOURCE = "resource";

	String PARAM_ANYTYPE_KIND = "anyTypeKind";

	String PARAM_ANYTYPE_KEY = "anyTypeKey";

	String PARAM_DETAILS = "details";
}
