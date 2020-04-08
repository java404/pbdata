package smartmon.smartstor.infra.remote.pbdata.types.lun;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
public class SmartNvmeLunInfoBackendTrs {
  @JsonProperty("fixed_port")
  private Integer fixedPort;
  @JsonProperty("ext_trans_addrs")
  public IpAddr[] extTransAddrs;
  @JsonProperty("ext_hostnqn")
  private String extHostNqn;
  @JsonProperty("ext_subnqn")
  private String extSubNqn;

}
