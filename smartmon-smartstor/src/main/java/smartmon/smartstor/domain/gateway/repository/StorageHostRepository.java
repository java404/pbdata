package smartmon.smartstor.domain.gateway.repository;

import java.util.List;
import java.util.Optional;

import smartmon.smartstor.domain.model.StorageHost;

public interface StorageHostRepository {
  void save(StorageHost storageHost);

  List<StorageHost> getAll();

  List<String> getIosServiceIps();

  Optional<StorageHost> findByServiceIp(String serviceIp);
}
