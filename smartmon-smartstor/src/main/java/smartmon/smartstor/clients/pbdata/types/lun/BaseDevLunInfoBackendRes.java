package smartmon.smartstor.clients.pbdata.types.lun;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BaseDevLunInfoBackendRes {
  @JsonProperty("dev_name")
  private String devName;

}
