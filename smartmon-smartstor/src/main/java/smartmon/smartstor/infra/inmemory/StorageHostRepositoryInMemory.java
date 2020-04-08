package smartmon.smartstor.infra.inmemory;

import com.google.common.collect.Lists;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;
import smartmon.smartstor.domain.exception.StorageHostNotFoundException;
import smartmon.smartstor.domain.gateway.repository.StorageHostRepository;
import smartmon.smartstor.domain.model.StorageHost;

@Component
public class StorageHostRepositoryInMemory implements StorageHostRepository {
  private static List<StorageHost> storageHosts = Lists.newArrayList();

  @Override
  public void save(StorageHost storageHost) {
    storageHosts.add(storageHost);
  }

  @Override
  public List<StorageHost> getAll() {
    return storageHosts;
  }

  @Override
  public List<String> getIosServiceIps() {
    return getAll().stream()
      .filter(StorageHost::isIos)
      .map(StorageHost::getListenIp)
      .collect(Collectors.toList());
  }

  @Override
  public Optional<StorageHost> findByServiceIp(String serviceIp) {
    return getAll().stream()
      .filter(storageHost ->  serviceIp.equals(storageHost.getListenIp()))
      .findFirst();
  }
}
