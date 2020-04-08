package smartmon.smartstor.infra.remote.pbdata.types.pools;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
public class PbdataPoolInfoListItem {
  public static final String KEY_POOL_LIST_V3_2 = "ext:pds.ios.get_pool_list_response";

  @JsonProperty("pool_infos")
  public PoolInfo[] poolInfos;

}
