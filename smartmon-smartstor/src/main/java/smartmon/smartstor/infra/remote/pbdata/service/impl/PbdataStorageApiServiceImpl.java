package smartmon.smartstor.infra.remote.pbdata.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import smartmon.smartstor.infra.remote.clients.PbdataClient;
import smartmon.smartstor.infra.remote.config.FeignOkHttpConfig;
import smartmon.smartstor.infra.remote.pbdata.service.PbdataStorageApiService;
import smartmon.smartstor.infra.remote.pbdata.service.SmartManagerService;
import smartmon.smartstor.infra.remote.pbdata.storage.entity.NsNodeInfo;
import smartmon.smartstor.infra.remote.pbdata.types.PbdataVersion;
import smartmon.smartstor.infra.remote.pbdata.types.constant.PbdataStorageConstants;
import smartmon.smartstor.infra.remote.pbdata.types.nodecfg.PbdataNodeInfo;
import smartmon.smartstor.infra.remote.utils.BusinessUtil;
import smartmon.utilities.misc.StringUtil;


@Service
@Slf4j
public class PbdataStorageApiServiceImpl implements PbdataStorageApiService {

  @Autowired
  private SmartManagerService smartManagerService;

  @Override
  public PbdataVersion getApiVersion(String serviceIp) {
    if (PbdataStorageApiServiceImpl.serviceIpIsIllegal(serviceIp)) {
      final PbdataClient pbdataClient = smartManagerService.getPbdataClient(serviceIp, FeignOkHttpConfig.port);
      return pbdataClient.getApiVersion();
    } else {
      return null;
    }
  }

  @Override
  public List<NsNodeInfo> getNodeList(String serviceIp) {
    if (PbdataStorageApiServiceImpl.serviceIpIsIllegal(serviceIp)) {
      final PbdataClient pbdataClient = smartManagerService.getPbdataClient(serviceIp, FeignOkHttpConfig.port);
      final PbdataNodeInfo nodeInfo = pbdataClient.getNodeInfo();
      final PbdataNodeInfo[] nodeList = pbdataClient.getNodeList();

      Map<String, PbdataNodeInfo> nodeCache = new HashMap<>();
      Map<String, Map<String, String>> nameCache = new HashMap<>();

      final String bacNameKey = "bacName";
      final String iosNameKey = "iosName";

      for (PbdataNodeInfo pbdataNodeInfo : nodeList) {
        //根据nodeStatus进行判断并且设置节点的状态 v3.2没有nodeStatus需手动设置
        if (pbdataNodeInfo.getNodeStatus() == null) {
          if (pbdataNodeInfo.getBac() == null && pbdataNodeInfo.getIos() == null) {
            pbdataNodeInfo.setNodeStatus(BusinessUtil.STORAGE_HOST_NODE_STATUS_UNCONFIGURED);
          } else {
            if (pbdataNodeInfo.getActualState()) {
              pbdataNodeInfo.setNodeStatus(BusinessUtil.STORAGE_HOST_NODE_STATUS_CONFIGURED);
            } else {
              pbdataNodeInfo.setNodeStatus(BusinessUtil.STORAGE_HOST_NODE_STATUS_MISSING);
            }
          }
        }
        //v3.2没有sysMode需手动设置
        if (StringUtils.isBlank(pbdataNodeInfo.getSysMode())) {
          pbdataNodeInfo.setSysMode(BusinessUtil.NODE_TYPE_IOS.equals(pbdataNodeInfo.getNodeType())
            ? BusinessUtil.HOST_TYPE_STORAGE : BusinessUtil.HOST_TYPE_DATABASE);
        }
        //v3.2没有sysMode需要自行通过hostId判断节点类型
        if (nodeCache.containsKey(pbdataNodeInfo.getHostId())) {
          final PbdataNodeInfo tempNodeInfo = nodeCache.get(pbdataNodeInfo.getHostId());
          if (!pbdataNodeInfo.getNodeType().equals(tempNodeInfo.getNodeType())) {
            //merge 对应 bac的信息
            if (BusinessUtil.NODE_TYPE_BAC.equals(tempNodeInfo.getNodeType())) {
              tempNodeInfo.setSysMode(BusinessUtil.HOST_TYPE_MERGE);
            } else {
              pbdataNodeInfo.setSysMode(BusinessUtil.HOST_TYPE_MERGE);
              nodeCache.put(pbdataNodeInfo.getHostId(), pbdataNodeInfo);
            }
          }
        } else {
          if (StringUtils.isNotBlank(pbdataNodeInfo.getHostId())) {
            nodeCache.put(pbdataNodeInfo.getHostId(), pbdataNodeInfo);
          } else {
            nodeCache.put(pbdataNodeInfo.getListenIp(), pbdataNodeInfo);
          }
        }
        //v3.0只有一种类型 smartscsi , v3.2还有另外一种类型 smartnvme
        if (StringUtils.isBlank(pbdataNodeInfo.getTransMode())) {
          if (!PbdataStorageConstants.compareVersion(pbdataClient.getApiVersion(), PbdataStorageConstants.V3_0)) {
            pbdataNodeInfo.setTransMode(BusinessUtil.TRANS_MODE_SMARTSCSI_DESC);
          } else if (BusinessUtil.TRANS_MODE_SMARTNVME.equals(pbdataNodeInfo.getTrsType())) {
            pbdataNodeInfo.setTransMode(BusinessUtil.TRANS_MODE_SMARTNVME_DESC);
          }
        }
        //v3.2没有nodeUuid需手动设置
        if (StringUtils.isBlank(pbdataNodeInfo.getNodeUuid())) {
          pbdataNodeInfo.setNodeUuid(pbdataNodeInfo.getNodeUuid());
        }
        //v3.2没有listenIp需手动设置
        if (StringUtils.isBlank(pbdataNodeInfo.getListenIp())) {
          if (StringUtils.isNotBlank(nodeInfo.getHostId()) && nodeInfo.getHostId().equals(pbdataNodeInfo.getHostId())) {
            pbdataNodeInfo.setListenIp(serviceIp);
          } else {
            pbdataNodeInfo.setListenIp(pbdataNodeInfo.getHostId());
          }
        }

        if (pbdataNodeInfo.getHostId() != null) {
          Map<String, String> nameCacheItem;
          if (nameCache.containsKey(pbdataNodeInfo.getHostId())) {
            nameCacheItem = nameCache.get(pbdataNodeInfo.getHostId());
          } else {
            nameCacheItem = new HashMap<>();
          }
          if (pbdataNodeInfo.getNodeType().equals(BusinessUtil.NODE_TYPE_BAC)) {
            nameCacheItem.put(bacNameKey, pbdataNodeInfo.getNodeName());
          } else {
            nameCacheItem.put(iosNameKey, pbdataNodeInfo.getNodeName());
          }
          nameCache.put(pbdataNodeInfo.getHostId(), nameCacheItem);
        }

      }
    } else {
      return null;
    }


    return null;
  }

  @Override
  public PbdataNodeInfo getNodeInfo(String serviceIp) {
    if (PbdataStorageApiServiceImpl.serviceIpIsIllegal(serviceIp)) {
      final PbdataClient pbdataClient = smartManagerService.getPbdataClient(serviceIp, FeignOkHttpConfig.port);
      return pbdataClient.getNodeInfo();
    } else {
      return null;
    }
  }

  private static boolean serviceIpIsIllegal(String serviceIp) {
    if (!StringUtil.isIP(serviceIp)) {
      log.warn("=====>PbdataStorageApiServiceImpl.getApiVersion: The storage service IP is invalid...");
      return false;
    } else {
      return true;
    }
  }

}
