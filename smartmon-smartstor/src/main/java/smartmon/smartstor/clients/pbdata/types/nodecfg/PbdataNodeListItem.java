package smartmon.smartstor.clients.pbdata.types.nodecfg;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import smartmon.smartstor.clients.pbdata.types.PbdataVersion;
import smartmon.smartstor.clients.pbdata.types.constant.PbdataStorageConstants;

@Getter
@Setter
public class PbdataNodeListItem {
  public static final String KEY_NODE_LIST_V3_0 = "get_node_list_response";
  public static final String KEY_NODE_LIST_V3_2 = "ext:pds.ios.get_node_list_response";
  @JsonProperty("nsnode_infos")
  private PbdataNodeInfo[] nsNodeInfos;
  @JsonProperty("node_infos")
  private PbdataNodeInfo[] nodeInfos;
  @JsonProperty("local_host_id")
  private String localHostId;

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
