package smartmon.smartstor.domain.service;

import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import smartmon.smartstor.domain.gateway.SmartstorApiService;
import smartmon.smartstor.domain.gateway.repository.StorageHostRepository;
import smartmon.smartstor.domain.model.ApiVersion;
import smartmon.smartstor.domain.model.StorageHost;
import smartmon.smartstor.domain.model.StorageNode;

@Service
public class HostInitService {
  @Autowired
  private SmartstorApiService smartstorApiService;
  @Autowired
  private StorageHostRepository storageHostRepository;

  public void initHosts(String serviceIp) {
    ApiVersion apiVersion = smartstorApiService.getApiVersion(serviceIp);
    apiVersion.checkVersion();
    List<StorageNode> storageNodes = smartstorApiService.getNodes(serviceIp);
    if (CollectionUtils.isNotEmpty(storageNodes)) {
      saveAsStorageHosts(storageNodes);
    }
  }

  private void saveAsStorageHosts(List<StorageNode> storageNodes) {
    for (StorageNode storageNode : storageNodes) {
      StorageHost storageHost = new StorageHost();
      storageHost.setHostname(storageNode.getHostname());
      storageHost.setListenIp(storageNode.getListenIp());
      storageHost.setSysMode(storageNode.getSysMode());
      storageHostRepository.save(storageHost);
    }
  }
}
