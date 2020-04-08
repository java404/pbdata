package smartmon.smartstor.infra.remote.pbdata.service;

import smartmon.smartstor.infra.remote.pbdata.storage.entity.NsNodeInfo;
import smartmon.smartstor.infra.remote.pbdata.types.PbdataVersion;
import smartmon.smartstor.infra.remote.pbdata.types.nodecfg.PbdataNodeInfo;

import java.util.List;

public interface PbdataStorageApiService {

  /**
   * 获取Pbdata API版本
   */
  public PbdataVersion getApiVersion(String serviceIp);

  /**
   * 获取节点列表
   */
  public List<NsNodeInfo> getNodeList(String serviceIp);

  /**
   * 获取节点详细信息
   */
  public PbdataNodeInfo getNodeInfo(String serviceIp);


}
