package smartmon.smartstor.infra.remote.pbdata.types.constant;

import org.apache.commons.lang3.StringUtils;
import smartmon.smartstor.infra.remote.pbdata.types.PbdataVersion;

public class PbdataStorageConstants {
  public static final Integer V3_0 = 300000;
  public static final Integer V3_2 = 302000;

  public static final String HOST_TYPE_STORAGE = "storage"; // 存储节点
  public static final String HOST_TYPE_DATABASE = "database"; // 计算节点
  public static final String HOST_TYPE_MERGE = "merge"; // 混合节点

  public static Boolean compareVersion(PbdataVersion pbdataVersoin, Integer version) {
    return getVersionValue(pbdataVersoin) - version >= 0;
  }

  /** Get version value. */
  public static Long getVersionValue(PbdataVersion pbdataVersoin) {
    String version = pbdataVersoin.getVersion();
    if (StringUtils.isBlank(version)) {
      return 0L;
    }
    String versionStr = version.toLowerCase().replaceAll("v", "");
    double subVersion = 0;
    if (pbdataVersoin.getSubVersion() != null) {
      subVersion = pbdataVersoin.getSubVersion().doubleValue();
    }
    return (long) (Math.pow(10, 5) * Double.parseDouble(versionStr) + subVersion);
  }

  /** Get string version. */
  public static String getStringVersion(Long versionNum) {
    String versionStr = String.valueOf(versionNum);
    String version = versionStr.substring(0, versionStr.length() - 5);
    String subVersion = versionStr.substring(version.length(), versionStr.length() - 1);
    return "v" + Integer.parseInt(version) + "." + Integer.parseInt(subVersion);
  }
}
