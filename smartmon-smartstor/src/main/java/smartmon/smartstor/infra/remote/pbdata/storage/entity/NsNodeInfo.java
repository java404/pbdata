package smartmon.smartstor.infra.remote.pbdata.storage.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class NsNodeInfo {
  private String nodeName; // 节点名称
  private String listenIp; // 节点IP地址
  private Integer listenPort; // 节点端口
  private String hostName; // 节点HostName
  private String sysMode; // 节点类型
  private String platform; // 节点平台
  private String broadcastIp; // 广播地址
  private Long lastBroadcastTime; // 最后广播存活时间

  // 3.0
  private String transMode; // 传输协议
  private String nodeUuid; // 节点UUID
  private Integer nodeStatus; // 节点状态 1：未配置 2：已配置
  private String ibguids; // "ibguids": ["f452:1403:0031:fe91","f452:1403:0031:fe92"]
  private String nodeIndex; // 节点序号也是节点ID

  //3.2
  private String hostId;
  private String bacName;// 计算节点名称
  private String iosName;// 存储节点名称
}
