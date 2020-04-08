package smartmon.smartstor.domain.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import smartmon.smartstor.domain.share.Entity;

@Data
@EqualsAndHashCode(callSuper = false)
public class StorageNode extends Entity {
  private String hostId;
  private String hostname;
  private String listenIp;
  private Integer listenPort;
  private String sysMode;
  private String transMode;
  private String platform;
  private String broadcastIp;
  private Long lastBroadcastTime;
  private String nodeUuid;
  private String nodeIndex;
  private String nodeName;
  private Integer nodeStatus;
}
