package smartmon.smartstor.infra.remote.exception;

import com.fasterxml.jackson.core.JsonProcessingException;

import java.io.IOException;

public class ClientParseException extends ClientException {
  private static final long serialVersionUID = -3514186910690884023L;

  public ClientParseException(JsonProcessingException error) {
    super(error.getMessage());
  }

  public ClientParseException(IOException err) {
    super(err.getMessage());
  }
}
