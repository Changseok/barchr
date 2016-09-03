package ka.gws.barchr.rest.cxf;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.joda.JodaModule;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Writer;
import java.util.Map;

/**
 * Referenced Apache Syncope Project
 * 
 * Jackson ObjectMapper that unwraps singleton map values and enable default typing for handling
 * abstract types serialization.
 */
public class UnwrappedObjectMapper extends ObjectMapper {

  private static final long serialVersionUID = -317191546835195103L;

  public UnwrappedObjectMapper() {
    super();

    registerModule(new JodaModule());
    configure(com.fasterxml.jackson.databind.SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
  }

  /**
   * Unwraps the given value if it implements the Map interface and contains only a single entry,
   * otherwise the value is returned unmodified.
   *
   * @param value the potential Map to unwrap
   * @return the unwrapped map or the original value
   */
  private Object unwrapMap(final Object value) {
    if (value instanceof Map) {
      Map<?, ?> map = (Map<?, ?>) value;
      if (map.size() == 1) {
        return map.values().iterator().next();
      }
    }

    return value;
  }

  @Override
  public void writeValue(final JsonGenerator jgen, final Object value) throws IOException {
    super.writeValue(jgen, unwrapMap(value));
  }

  @Override
  public void writeValue(final File resultFile, final Object value) throws IOException {
    super.writeValue(resultFile, unwrapMap(value));
  }

  @Override
  public void writeValue(final OutputStream out, final Object value) throws IOException {
    super.writeValue(out, unwrapMap(value));
  }

  @Override
  public void writeValue(final Writer writer, final Object value) throws IOException {
    super.writeValue(writer, unwrapMap(value));
  }

  @Override
  public byte[] writeValueAsBytes(final Object value) throws JsonProcessingException {
    return super.writeValueAsBytes(unwrapMap(value));
  }

  @Override
  public String writeValueAsString(final Object value) throws JsonProcessingException {
    return super.writeValueAsString(unwrapMap(value));
  }
}
