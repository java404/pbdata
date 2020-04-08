package smartmon.smartstor.infra.remote.pbdata.types.nodecfg;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BacNodeInfo {
  @JsonProperty("initgroup_id")
  private String initGroupId;
  @JsonProperty("initgroup_name")
  private String initGroupName;

}
