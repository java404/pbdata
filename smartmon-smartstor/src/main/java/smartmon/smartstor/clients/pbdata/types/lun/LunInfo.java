package smartmon.smartstor.clients.pbdata.types.lun;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LunInfo {
  @JsonProperty("lun_name")
  private String lunName;
  @JsonProperty("lun_id")
  private String lunId;
  @JsonProperty("lun_type")
  private Integer lunType;
  @JsonProperty("lun_res_id")
  private String lunResId;
  @JsonProperty("state_cfg")
  private Long stateCfg;
  @JsonProperty("initgroup_id")
  private String initGroupId;
  @JsonProperty("lun_size")
  private Long lunSize;
  @JsonProperty("asmdisk_info")
  private AsmDiskInfo asmdiskInfo;
  @JsonProperty("backend_trs")
  private LunInfoBackendTrs backendTrs;
  @JsonProperty("ext_state_onl")
  private Long extStateOnl;
  @JsonProperty("ext_device_path")
  private String extDevicePath;
  @JsonProperty("ext_node_name")
  private String extNodeName;
  @JsonProperty("ext_initgroup_name")
  private String extInitGroupName;
  @JsonProperty("ext_backend_res")
  private LunInfoBackendRes extBackendRes;
  @JsonProperty("ext_state")
  private Integer extState;
  @JsonProperty("ext_state_level")
  private Integer extStateLevel;

}
