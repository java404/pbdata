package smartmon.smartstor.clients.pbdata.types.lun;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BaseDiskLunInfoBackendRes {
  @JsonProperty("data_dev_name")
  private String dataDevName;
  @JsonProperty("data_disk_name")
  private String dataDiskName;

}
