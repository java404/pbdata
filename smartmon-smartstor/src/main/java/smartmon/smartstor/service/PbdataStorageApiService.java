package smartmon.smartstor.service;

import smartmon.smartstor.clients.pbdata.types.PbdataVersion;

public interface PbdataStorageApiService {

  /**
   * 获取Pbdata API版本
   */
  public PbdataVersion getApiVersion(String service_ip);


}
