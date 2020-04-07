package smartmon.smartstor.clients.pbdata.types.lun;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SmartNvmeLunInfoBackendTrs {
  @JsonProperty("fixed_port")
  private Integer fixedPort;
  @JsonProperty("ext_trans_addrs")
  private IpAddr[] extTransAddrs;
  @JsonProperty("ext_hostnqn")
  private String extHostNqn;
  @JsonProperty("ext_subnqn")
  private String extSubNqn;

}
