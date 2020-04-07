package smartmon.smartstor.clients.pbdata.types.group;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PbdataInitGroupInfo {

  @JsonProperty("initgroup_id")
  private String initGroupId;
  @JsonProperty("initgroup_name")
  private String initGroupName;
  @JsonProperty("initgroup_info")
  private String initGroupInfo;
  @JsonProperty("initgroup_nodes")
  private InitGroupNode[] initGroupNodes;
  @JsonProperty("ext_asm_node_id")
  private String extAsmNodeId;
  @JsonProperty("ext_asm_node_name")
  private String extAsmNodeName;

}
