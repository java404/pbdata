package smartmon.smartstor.infra.remote.pbdata.types.lun;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AsmDiskInfo {
  @JsonProperty("dsknum")
  private Integer dskNum;
  @JsonProperty("grpname")
  private String grpName;
  @JsonProperty("fgname")
  private String fgName;
  @JsonProperty("lun_id")
  private String lunId;
  @JsonProperty("ext_lht")
  private Long extLht;
  @JsonProperty("ext_dskname")
  private String extDskName;
  @JsonProperty("ext_path")
  private String extPath;
  @JsonProperty("ext_mode_status")
  private String extModeStatus; // ONLINE/OFFLINE/SYNCING
  @JsonProperty("ext_state")
  private String extState; // DROPPING/NORMAL

}
