package smartmon.smartstor.clients.pbdata.types.pools;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PoolDirtyThresh {
  @JsonProperty("lower")
  private Integer lower;
  @JsonProperty("upper")
  private Integer upper;

}
