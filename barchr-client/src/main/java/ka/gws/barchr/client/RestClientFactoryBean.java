package ka.gws.barchr.client;

import javax.ws.rs.core.MediaType;

import org.apache.cxf.jaxrs.client.Client;
import org.apache.cxf.jaxrs.client.ClientConfiguration;
import org.apache.cxf.jaxrs.client.JAXRSClientFactoryBean;
import org.apache.cxf.jaxrs.client.WebClient;
import org.apache.cxf.transport.common.gzip.GZIPInInterceptor;
import org.apache.cxf.transport.common.gzip.GZIPOutInterceptor;
import org.apache.cxf.transport.http.URLConnectionHTTPConduit;

public class RestClientFactoryBean extends JAXRSClientFactoryBean {

    public static final String HEADER_SPLIT_PROPERTY = "org.apache.cxf.http.header.split";

    /**
     * Creates an anonymous instance of the given service class, for the given content type.
     *
     * @param <T> any service class
     * @param serviceClass service class reference
     * @param mediaType XML or JSON are supported
     * @return anonymous service instance of the given reference class
     */
    public <T> T createServiceInstance(final Class<T> serviceClass, final MediaType mediaType) {
        return createServiceInstance(serviceClass, mediaType, false);
    }

    /**
     * Creates an authenticated instance of the given service class, for the given content type.
     *
     * @param <T> any service class
     * @param serviceClass service class reference
     * @param mediaType XML or JSON are supported
     * @param username username for REST authentication
     * @param password password for REST authentication
     * @param useCompression whether transparent gzip <tt>Content-Encoding</tt> handling is to be enabled
     * @return anonymous service instance of the given reference class
     */
    public <T> T createServiceInstance(
            final Class<T> serviceClass,
            final MediaType mediaType,
            final boolean useCompression) {

        setServiceClass(serviceClass);
        T serviceInstance = create(serviceClass);

        Client client = WebClient.client(serviceInstance);
        client.type(mediaType).accept(mediaType);

        ClientConfiguration config = WebClient.getConfig(client);
        config.getRequestContext().put(HEADER_SPLIT_PROPERTY, true);
        config.getRequestContext().put(URLConnectionHTTPConduit.HTTPURL_CONNECTION_METHOD_REFLECTION, true);
        if (useCompression) {
            config.getInInterceptors().add(new GZIPInInterceptor());
            config.getOutInterceptors().add(new GZIPOutInterceptor());
        }

        return serviceInstance;
    }
}
