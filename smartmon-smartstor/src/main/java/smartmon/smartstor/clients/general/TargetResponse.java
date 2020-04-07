package smartmon.smartstor.clients.general;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Strings;
import lombok.Data;
import smartmon.smartstor.clients.exception.ClientParseException;
import smartmon.smartstor.clients.exception.ReturnCodeException;
import smartmon.utilities.misc.JsonConverter;

@Data
public class TargetResponse {
  private JsonNode body;
  @JsonProperty("rc")
  private ReturnCode returnCode;

  /** Make response. */
  public <T> T makeResponse(String name, Class<T>  valueType)
          throws ReturnCodeException, ClientParseException {
    if (returnCode.getReturnCode() != 0) {
      throw new ReturnCodeException(returnCode);
    }
    if (body == null) {
      return null;
    }
    final ObjectMapper mapper = JsonConverter.getMapper();
    try {
      final JsonNode value = body.get(Strings.nullToEmpty(name));
      if (value == null) {
        return null;
      } else {
        return mapper.treeToValue(value, valueType);
      }
    } catch (JsonProcessingException err) {
      throw new ClientParseException(err);
    }
  }
}
