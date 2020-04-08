package smartmon.smartstor.infra.remote.pbdata.types.group;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PbdataInitGroupListItem {
  public static final String KEY_GROUP_LIST_V3_2 = "ext:pds.ios.get_initgroup_list_response";

  @JsonProperty("initgroup_infos")
  private PbdataInitGroupInfo[] pbdataInitGroupInfos;

}
