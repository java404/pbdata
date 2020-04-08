package smartmon.smartstor.interfaces.web.representation.dto;

import lombok.Data;

@Data
public class StorageHostDto {
  private String hostname;
  private String listenIp;
  private String sysMode;
}
