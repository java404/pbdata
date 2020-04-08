package smartmon.smartstor.infra.remote.utils;

public class BusinessUtil {

  // 3.0 判断节点状态
  public static Integer STORAGE_HOST_NODE_STATUS_UNCONFIGURED = 1;
  public static Integer STORAGE_HOST_NODE_STATUS_CONFIGURED = 2;
  public static Integer STORAGE_HOST_NODE_STATUS_MISSING = 3;

  // 主机类型，从存储接口过来的
  public static String HOST_TYPE_STORAGE = "storage"; // 存储节点
  public static String HOST_TYPE_DATABASE = "database"; // 计算节点
  public static String HOST_TYPE_MERGE = "merge"; // 混合节点
  public static String HOST_TYPE_SWITCH = "switch"; // 交换机，附加
  public static Integer NODE_TYPE_IOS = 20;// 存储节点
  public static Integer NODE_TYPE_BAC = 30;// 计算节点

  public static Integer TRANS_MODE_SMARTSCSI = 10;// smartscsi
  public static String TRANS_MODE_SMARTSCSI_DESC = "smartscsi";// smartscsi
  public static Integer TRANS_MODE_SMARTNVME = 20;// smartnvme
  public static String TRANS_MODE_SMARTNVME_DESC = "smartnvme";// smartnvme
}
