package smartmon.smartstor.clients.pbdata.types.nodecfg;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class IosNodeCfgBackendTransport {
  @JsonProperty("backend.trs.smartnvme.ign_bt")
  private SmartNvme backendTrsSmartNvmeIgnBt;
  @JsonProperty("backend.trs.smartscsi.ign_bt")
  private SmartScsi backendTrsSmartScsiIgnBt;

}
