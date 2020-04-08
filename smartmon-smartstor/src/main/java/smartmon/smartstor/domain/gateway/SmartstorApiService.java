package smartmon.smartstor.domain.gateway;

import java.util.List;

import smartmon.smartstor.domain.model.ApiVersion;
import smartmon.smartstor.domain.model.Disk;
import smartmon.smartstor.domain.model.StorageNode;

public interface SmartstorApiService {
  ApiVersion getApiVersion(String serviceIp);

  List<StorageNode> getNodes(String serviceIp);

  List<Disk> getDisks(List<String> serviceIps);

  void addDisk(String serviceIp, String devName, Integer partitionCount, String diskType);

  void delDisk(String serviceIp, String diskName);
}
