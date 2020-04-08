package smartmon.smartstor.infra.remote.pbdata.types.nodecfg;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Data

public class PbdataNodeInfo {
  @JsonProperty("node_id")
  private String nodeId;
  @JsonProperty("host_id")
  private String hostId;
  @JsonProperty("ib_ips")
  private String[] ibIps;
  @JsonProperty("err_ib_ips")
  private String[] errIbIps;
  @JsonProperty("listen_port")
  private Integer listenPort;
  @JsonProperty("node_name")
  private String nodeName;
  @JsonProperty("cluster_name")
  private String clusterName;
  @JsonProperty("node_type")
  private Integer nodeType;
  @JsonProperty("trs_type")
  private Integer trsType;
  @JsonProperty("host_name")
  private String hostName;
  @JsonProperty("bac")
  private BacNodeInfo bac;
  @JsonProperty("ios")
  private IosNodeInfo ios;
  @JsonProperty("actual_state")
  private Boolean actualState;

  //v3.0
  @JsonProperty("broadcast_ip")
  private String broadcastIp;
  @JsonProperty("listen_ip")
  private String listenIp;
  @JsonProperty("ibguids")
  private String[] ibGuids;
  @JsonProperty("trans_mode")
  private String transMode;
  @JsonProperty("platform")
  private String platform;
  @JsonProperty("node_status")
  private Integer nodeStatus;
  @JsonProperty("last_broadcast_time")
  private Long lastBroadcastTime;
  @JsonProperty("sys_mode")
  private String sysMode;
  @JsonProperty("node_uuid")
  private String nodeUuid;
  @JsonProperty("node_index")
  private String nodeIndex;

}
