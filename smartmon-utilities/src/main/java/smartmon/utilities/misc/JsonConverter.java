package smartmon.utilities.misc;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class JsonConverter {
  private static final ObjectMapper mapper;

  static {
    mapper = new ObjectMapper();
    mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
  }

  public static ObjectMapper getMapper() {
    return mapper;
  }

  public static String writeValueAsString(Object value) throws JsonProcessingException {
    return getMapper().writeValueAsString(value);
  }

  public static String writeValueAsStringQuietly(Object value) {
    try {
      return writeValueAsString(value);
    } catch (JsonProcessingException error) {
      log.warn("Json process exception:", error);
      return "";
    }
  }
}
