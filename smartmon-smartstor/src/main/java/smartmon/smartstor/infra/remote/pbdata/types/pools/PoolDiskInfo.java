package smartmon.smartstor.infra.remote.pbdata.types.pools;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PoolDiskInfo {
  @JsonProperty("disk_id")
  private String diskId;
  @JsonProperty("disk_part")
  private Integer diskPart;
  @JsonProperty("ext_dev_name")
  private String extDevName;
  @JsonProperty("ext_disk_name")
  private String extDiskName;
  @JsonProperty("ext_size")
  private Long extSize;

}
