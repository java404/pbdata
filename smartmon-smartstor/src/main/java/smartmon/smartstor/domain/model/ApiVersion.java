package smartmon.smartstor.domain.model;

import java.math.BigInteger;

import lombok.AllArgsConstructor;
import lombok.Getter;
import smartmon.smartstor.domain.exception.ApiVersionUnsupportedException;
import smartmon.smartstor.domain.share.ValueObject;

@Getter
@AllArgsConstructor
public class ApiVersion extends ValueObject {
  public static final String LOWEST_API_VERSION = "v1.5";

  private String version;
  private BigInteger subVersion;

  public void checkVersion() {
    if (getVersion().compareTo(LOWEST_API_VERSION) < 0) {
      throw new ApiVersionUnsupportedException();
    }
  }
}
