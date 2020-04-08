package smartmon.smartstor.infra.remote.pbdata.types.group;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Data
@EqualsAndHashCode(callSuper = false)
public class InitGroupNode {
  @JsonProperty("node_id")
  private String nodeId;
  @JsonProperty("host_id")
  private String hostId;
  @JsonProperty("node_info")
  private String nodeInfo;
  @JsonProperty("node_name")
  private String nodeName;
  @JsonProperty("ib_ips")
  private String[] ibIps;
  @JsonProperty("listen_port")
  private Integer listenPort;
  @JsonProperty("host_name")
  private String hostName;
  @JsonProperty("trs_type")
  private Integer trsType;
  @JsonProperty("backend_trs")
  private InitGroupNodeBackendTrs backendTrs;
}
