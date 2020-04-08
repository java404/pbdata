package smartmon.smartstor.infra.remote.pbdata.types.nodecfg;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import smartmon.smartstor.infra.remote.pbdata.types.constant.PbdataStorageConstants;

public class PbdataNodeInfoItem {
  public static final String KEY_NODE_INFO = "get_node_info_response";
  @Setter
  @JsonProperty("node_info")
  private PbdataNodeInfo nodeInfo;
  @Getter
  @Setter
  @JsonProperty("ios_service_stat")
  private PbdataNodeStat iosServiceStat;
  @Getter
  @Setter
  @JsonProperty("bac_service_stat")
  private PbdataNodeStat bacServiceStat;

  /** Get node info. */
  public PbdataNodeInfo getNodeInfo() {
    if (nodeInfo == null) {
      nodeInfo = new PbdataNodeInfo();
      if (iosServiceStat != null && bacServiceStat != null) {
        nodeInfo.setNodeName(iosServiceStat.getIosNodeCfg().getNodeName());
        nodeInfo.setHostId(iosServiceStat.getHostId());
        nodeInfo.setSysMode(PbdataStorageConstants.HOST_TYPE_MERGE);
      } else if (iosServiceStat != null) {
        nodeInfo.setNodeName(iosServiceStat.getIosNodeCfg().getNodeName());
        nodeInfo.setHostId(iosServiceStat.getHostId());
        nodeInfo.setSysMode(PbdataStorageConstants.HOST_TYPE_STORAGE);
      } else if (bacServiceStat != null) {
        nodeInfo.setNodeName(bacServiceStat.getBacNodeCfg().getNodeName());
        nodeInfo.setHostId(bacServiceStat.getHostId());
        nodeInfo.setSysMode(PbdataStorageConstants.HOST_TYPE_DATABASE);
      }
    }
    return nodeInfo;
  }

}
