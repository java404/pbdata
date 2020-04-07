package smartmon.smartstor.clients.pbdata.types.lun;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LunInfoBackendTrs {
  @JsonProperty("ext:pds.backend.trs.smartnvme.li_bt")
  private SmartNvmeLunInfoBackendTrs backendTrsSmartNvmeLiBt;
  @JsonProperty("ext:pds.backend.trs.smartscsi.li_bt")
  private SmartScsiLunInfoBackendTrs backendTrsSmartscsiLiBt;

}
