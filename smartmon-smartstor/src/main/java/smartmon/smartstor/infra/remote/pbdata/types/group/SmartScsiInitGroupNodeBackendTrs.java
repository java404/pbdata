package smartmon.smartstor.infra.remote.pbdata.types.group;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SmartScsiInitGroupNodeBackendTrs {
  @JsonProperty("ibguids")
  private String[] ibGuids;

}
