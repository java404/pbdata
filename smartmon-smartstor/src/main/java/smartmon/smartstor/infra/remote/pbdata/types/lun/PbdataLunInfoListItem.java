package smartmon.smartstor.infra.remote.pbdata.types.lun;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PbdataLunInfoListItem {
  public static final String KEY_LUN_LIST_V3_2 = "ext:pds.ios.get_lun_list_response";

  @JsonProperty("lun_infos")
  private LunInfo[] lunInfos;

}
