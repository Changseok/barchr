package ka.gws.barchr.rest.cxf.service;

import ka.gws.barchr.common.to.ServiceResult;
import kr.gws.barchr.rest.api.service.BaseService;
import org.apache.cxf.jaxrs.ext.MessageContext;
import org.apache.cxf.jaxrs.ext.search.SearchContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

abstract class AbstractServiceImpl implements BaseService {

    protected static final Logger LOG = LoggerFactory.getLogger(AbstractServiceImpl.class);

    protected static final String OPTIONS_ALLOW = "GET,POST,OPTIONS,HEAD";

    @Context protected UriInfo uriInfo;

    @Context protected MessageContext messageContext;

    @Context protected SearchContext searchContext;

    /**
     * Create Response
     *
     * @param result
     * @return
     */
    protected Response createResponse(final ServiceResult<?> result) {
        String entityId = String.valueOf(result.getTO().getKey());
        Response.ResponseBuilder builder =
            Response.created(uriInfo.getAbsolutePathBuilder().path(entityId).build());

        builder = builder.entity(result);
        return builder.build();
    }
}
