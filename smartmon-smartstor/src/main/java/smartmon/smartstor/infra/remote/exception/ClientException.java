package smartmon.smartstor.infra.remote.exception;

public class ClientException extends RuntimeException {
  private static final long serialVersionUID = -5206280029571452292L;

  public ClientException(String message) {
    super(message);
  }
}
