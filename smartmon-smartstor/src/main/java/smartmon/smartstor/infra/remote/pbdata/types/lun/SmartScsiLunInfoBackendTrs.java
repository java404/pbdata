package smartmon.smartstor.infra.remote.pbdata.types.lun;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SmartScsiLunInfoBackendTrs {
  @JsonProperty("fixed_lun")
  private Integer fixedLun;
  @JsonProperty("ext_io_error")
  private Long extIoError;
  @JsonProperty("ext_last_errno")
  private Integer extLastErrno;

}
