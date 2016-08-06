package ka.gws.barchr.common.rest.api.service;

import javax.ws.rs.core.MediaType;

/**
 * Referenced Apache Syncope Project
 * 
 * @author Changseok Keum
 */
public interface BaseService {

  String APPLICATION_XML = MediaType.APPLICATION_XML + ";qs=0.9";

  String PARAM_FIQL = "fiql";

  String PARAM_PAGE = "page";

  String PARAM_SIZE = "size";

  String PARAM_ORDERBY = "orderby";

  String PARAM_DETAILS = "details";
}
