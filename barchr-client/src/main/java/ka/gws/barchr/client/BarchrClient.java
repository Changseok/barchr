package ka.gws.barchr.client;

import javax.ws.rs.core.EntityTag;
import javax.ws.rs.core.MediaType;

import org.apache.cxf.jaxrs.client.WebClient;

/**
 * Referenced Apache Syncope Project
 * 
 * @author Changseok Keum
 */
public class BarchrClient {

  private final MediaType mediaType;

  private final RestClientFactoryBean restClientFactory;

  private final boolean useCompression;

  public BarchrClient(final MediaType mediaType, final RestClientFactoryBean restClientFactory,
      final boolean useCompression) {

    this.mediaType = mediaType;
    this.restClientFactory = restClientFactory;
    this.useCompression = useCompression;
  }

  /**
   * Creates an instance of the given service class, with configured content type.
   *
   * @param <T> any service class
   * @param serviceClass service class reference
   * @return service instance of the given reference class
   */
  public <T> T getService(final Class<T> serviceClass) {
    synchronized (restClientFactory) {
      return restClientFactory.createServiceInstance(serviceClass, mediaType, useCompression);
    }
  }

  /**
   * Sets the given header on the give service instance.
   *
   * @param <T> any service class
   * @param service service class instance
   * @param key HTTP header key
   * @param values HTTP header values
   * @return given service instance, with given header set
   */
  public <T> T header(final T service, final String key, final Object... values) {
    WebClient.client(service).header(key, values);
    return service;
  }

  /**
   * Creates an instance of the given service class and sets the given header.
   *
   * @param <T> any service class
   * @param serviceClass service class reference
   * @param key HTTP header key
   * @param values HTTP header values
   * @return service instance of the given reference class, with given header set
   */
  public <T> T header(final Class<T> serviceClass, final String key, final Object... values) {
    return header(getService(serviceClass), key, values);
  }

  /**
   * Sets the {@code If-Match} or {@code If-None-Match} header on the given service instance.
   *
   * @param <T> any service class
   * @param service service class instance
   * @param etag ETag value
   * @param ifNot if true then {@code If-None-Match} is set, {@code If-Match} otherwise
   * @return given service instance, with {@code If-Match} or {@code If-None-Match} set
   */
  private <T> T match(final T service, final EntityTag etag, final boolean ifNot) {
    WebClient.client(service).match(etag, ifNot);
    return service;
  }

  /**
   * Sets the {@code If-Match} header on the given service instance.
   *
   * @param <T> any service class
   * @param service service class instance
   * @param etag ETag value
   * @return given service instance, with {@code If-Match} set
   */
  public <T> T ifMatch(final T service, final EntityTag etag) {
    return match(service, etag, false);
  }

  /**
   * Creates an instance of the given service class, with {@code If-Match} header set.
   *
   * @param <T> any service class
   * @param serviceClass service class reference
   * @param etag ETag value
   * @return given service instance, with {@code If-Match} set
   */
  public <T> T ifMatch(final Class<T> serviceClass, final EntityTag etag) {
    return match(getService(serviceClass), etag, false);
  }

  /**
   * Sets the {@code If-None-Match} header on the given service instance.
   *
   * @param <T> any service class
   * @param service service class instance
   * @param etag ETag value
   * @return given service instance, with {@code If-None-Match} set
   */
  public <T> T ifNoneMatch(final T service, final EntityTag etag) {
    return match(service, etag, true);
  }

  /**
   * Creates an instance of the given service class, with {@code If-None-Match} header set.
   *
   * @param <T> any service class
   * @param serviceClass service class reference
   * @param etag ETag value
   * @return given service instance, with {@code If-None-Match} set
   */
  public <T> T ifNoneMatch(final Class<T> serviceClass, final EntityTag etag) {
    return match(getService(serviceClass), etag, true);
  }

  /**
   * Fetches {@code ETag} header value from latest service run (if available).
   *
   * @param <T> any service class
   * @param service service class instance
   * @return {@code ETag} header value from latest service run (if available)
   */
  public <T> EntityTag getLatestEntityTag(final T service) {
    return WebClient.client(service).getResponse().getEntityTag();
  }
}
