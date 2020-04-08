package smartmon.smartstor.infra.remote.pbdata.types.nodecfg;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SmartScsi {
  @JsonProperty("last_lun")
  private int lastLun;

}
