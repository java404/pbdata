package smartmon.smartstor.infra.remote.pbdata.types.group;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InitGroupNodeBackendTrs {
  @JsonProperty("ext:pds.backend.trs.smartnvme.ign_bt")
  private SmartNvmeInitGroupNodeBackendTrs backendTrsSmartnvmeIgnBt;
  @JsonProperty("ext:pds.backend.trs.smartscsi.ign_bt")
  private SmartScsiInitGroupNodeBackendTrs backendTrsSmartscsiIgnBt;

}
