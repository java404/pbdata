package smartmon.smartstor.clients.pbdata.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.math.BigInteger;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;



@Data
public class PbdataVersion {
  private String version;
  @JsonProperty("sub-version")
  private BigInteger subVersion;

  public boolean isEmpty() {
    return StringUtils.isEmpty(version);
  }
}
