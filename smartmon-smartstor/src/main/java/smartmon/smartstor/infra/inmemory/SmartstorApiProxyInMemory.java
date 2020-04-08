package smartmon.smartstor.infra.inmemory;

import com.google.common.collect.Lists;

import java.math.BigInteger;
import java.util.List;

import org.springframework.stereotype.Component;
import smartmon.smartstor.domain.gateway.SmartstorApiService;
import smartmon.smartstor.domain.model.ApiVersion;
import smartmon.smartstor.domain.model.Disk;
import smartmon.smartstor.domain.model.StorageNode;

@Component
public class SmartstorApiProxyInMemory implements SmartstorApiService {

  @Override
  public ApiVersion getApiVersion(String serviceIp) {
    return new ApiVersion("v3.0", BigInteger.valueOf(300000));
  }

  @Override
  public List<StorageNode> getNodes(String serviceIp) {
    final List<StorageNode> storageNodes = Lists.newArrayList();
    StorageNode storageNode = new StorageNode();
    storageNode.setHostname("dntohu001");
    storageNode.setListenIp("172.24.12.218");
    storageNode.setSysMode("merge");
    storageNodes.add(storageNode);
    storageNode = new StorageNode();
    storageNode.setHostname("dntohu219");
    storageNode.setListenIp("172.24.12.219");
    storageNode.setSysMode("merge");
    storageNodes.add(storageNode);
    return storageNodes;
  }

  @Override
  public List<Disk> getDisks(List<String> serviceIps) {
    return null;
  }

  @Override
  public void addDisk(String serviceIp, String devName, Integer partitionCount, String diskType) {
  }

  @Override
  public void delDisk(String serviceIp, String diskName) {

  }
}
