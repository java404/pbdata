package smartmon.smartstor.clients.pbdata.types.nodecfg;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NodeCfg {
  @JsonProperty("node_name")
  private String nodeName;
  @JsonProperty("cluster_name")
  private String clusterName;
  @JsonProperty("trs_type")
  private int trsType;
  @JsonProperty("last_target")
  private int lastTarget;
  @JsonProperty("ext_ib_ips")
  private String[] extIbIps;
  @JsonProperty("backend_trs")
  private IosNodeCfgBackendTransport backendTrs;

}
