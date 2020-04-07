package smartmon.smartstor.clients.pbdata.types.lun;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LunInfoBackendRes {
  @JsonProperty("ext:pds.backend.lun.basedev.li_br")
  private BaseDevLunInfoBackendRes baseDevLiBr;
  @JsonProperty("ext:pds.backend.lun.basedisk.li_br")
  private BaseDiskLunInfoBackendRes baseDiskLiBr;
  @JsonProperty("ext:pds.backend.lun.palcache.li_br")
  private PalCacheLunInfoBackendRes palcacheLiBr;
  @JsonProperty("ext:pds.backend.lun.palpmt.li_br")
  private PalPmtLunInfoBackendRes palpmtLiBr;
  @JsonProperty("ext:pds.backend.lun.palraw.li_br")
  private PalRawLunInfoBackendRes palRawLiBr;

  /** Get data disk name. */
  public String getDataDiskName() {
    if (baseDevLiBr != null) {
      return null;
    } else if (baseDiskLiBr != null) {
      return baseDiskLiBr.getDataDiskName();
    } else if (palcacheLiBr != null) {
      return palcacheLiBr.getDataDiskName();
    } else if (palpmtLiBr != null) {
      return palpmtLiBr.getDataDiskName();
    } else if (palRawLiBr != null) {
      return palRawLiBr.getDataDiskName();
    }
    return null;
  }

  /** Get data dev name. */
  public String getDataDevName() {
    if (baseDevLiBr != null) {
      return baseDevLiBr.getDevName();
    } else if (baseDiskLiBr != null) {
      return baseDiskLiBr.getDataDevName();
    } else if (palcacheLiBr != null) {
      return palcacheLiBr.getDataDevName();
    } else if (palpmtLiBr != null) {
      return palpmtLiBr.getDataDevName();
    } else if (palRawLiBr != null) {
      return palRawLiBr.getDataDevName();
    }
    return null;
  }
}
