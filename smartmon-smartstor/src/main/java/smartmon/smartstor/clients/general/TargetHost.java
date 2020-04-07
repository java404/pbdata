package smartmon.smartstor.clients.general;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;

@AllArgsConstructor
@Data
public class TargetHost {
  @NonNull
  private final String address;
  @NonNull
  private final int port;
  private final String username;
  private final String password;

  /** Target Host (Hippo host don't support account info). */
  public TargetHost(String address, int port) {
    this(address, port, "", "");
  }

  /** Make server url. */
  String makeServerUrl(boolean isHttps) {
    return String.format("%s://%s:%d", isHttps ? "https" : "http", this.address, this.port);
  }
}
