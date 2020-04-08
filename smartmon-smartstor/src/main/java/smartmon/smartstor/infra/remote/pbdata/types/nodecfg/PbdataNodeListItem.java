package smartmon.smartstor.infra.remote.pbdata.types.nodecfg;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import smartmon.smartstor.infra.remote.pbdata.types.PbdataVersion;
import smartmon.smartstor.infra.remote.pbdata.types.constant.PbdataStorageConstants;

@Getter
public class PbdataNodeListItem {
  public static final String KEY_NODE_LIST_V3_0 = "get_node_list_response";
  public static final String KEY_NODE_LIST_V3_2 = "ext:pds.ios.get_node_list_response";
  @JsonProperty("nsnode_infos")
  public PbdataNodeInfo[] nsNodeInfos;
  @JsonProperty("node_infos")
  public PbdataNodeInfo[] nodeInfos;
  @JsonProperty("local_host_id")
  public String localHostId;

  /** Get node infos. */
  public PbdataNodeInfo[] getNodeInfos(PbdataVersion version) {
    if (PbdataStorageConstants.compareVersion(version, PbdataStorageConstants.V3_2)) {
      return nodeInfos;
    } else {
      return nsNodeInfos;
    }
  }

  /** Get node list. */
  public static String getKeyNodeList(PbdataVersion version) {
    if (PbdataStorageConstants.compareVersion(version, PbdataStorageConstants.V3_2)) {
      return KEY_NODE_LIST_V3_2;
    } else {
      return KEY_NODE_LIST_V3_0;
    }
  }
}
