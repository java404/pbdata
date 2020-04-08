package smartmon.smartstor.domain.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import smartmon.smartstor.domain.share.Entity;

@Data
@EqualsAndHashCode(callSuper = false)
public class StorageHost extends Entity {
  private String hostname;
  private String listenIp;
  private String sysMode;

  public boolean isIos() {
    return SysModeEnum.STORAGE.name().equalsIgnoreCase(this.getSysMode())
      || SysModeEnum.MERGE.name().equalsIgnoreCase(this.getSysMode());
  }

  public boolean isBac() {
    return SysModeEnum.DATABASE.name().equalsIgnoreCase(this.getSysMode())
      || SysModeEnum.MERGE.name().equalsIgnoreCase(this.getSysMode());
  }

  private static enum SysModeEnum {
    DATABASE, STORAGE, MERGE;
  }
}
