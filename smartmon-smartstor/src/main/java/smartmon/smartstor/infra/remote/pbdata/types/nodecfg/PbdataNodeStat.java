package smartmon.smartstor.infra.remote.pbdata.types.nodecfg;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PbdataNodeStat {
  @JsonProperty("node_id")
  private String nodeId;
  @JsonProperty("host_id")
  private String hostId;
  @JsonProperty("is_ready")
  private boolean isReady;
  @JsonProperty("node_type")
  private int nodeType;
  @JsonProperty("ios_nodecfg")
  private NodeCfg iosNodeCfg;
  @JsonProperty("bac_nodecfg")
  private NodeCfg bacNodeCfg;

}
