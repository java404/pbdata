package smartmon.smartstor.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import smartmon.smartstor.app.command.DiskAddCommand;
import smartmon.smartstor.app.command.DiskDelCommand;
import smartmon.smartstor.domain.exception.StorageHostNotFoundException;
import smartmon.smartstor.domain.gateway.SmartstorApiService;
import smartmon.smartstor.domain.gateway.repository.StorageHostRepository;

@Service
public class DiskAppService {
  @Autowired
  private SmartstorApiService smartstorApiService;
  @Autowired
  private StorageHostRepository storageHostRepository;

  public void addDisk(DiskAddCommand diskAddCommand) {
    storageHostRepository.findByServiceIp(diskAddCommand.getServiceIp())
      .orElseThrow(StorageHostNotFoundException::new);
    smartstorApiService.addDisk(diskAddCommand.getServiceIp(), diskAddCommand.getDevName(),
      diskAddCommand.getPartitionCount(), diskAddCommand.getDiskType());
  }

  public void delDisk(DiskDelCommand diskDelCommand) {
    storageHostRepository.findByServiceIp(diskDelCommand.getServiceIp())
      .orElseThrow(StorageHostNotFoundException::new);
    smartstorApiService.delDisk(diskDelCommand.getServiceIp(), diskDelCommand.getDiskName());
  }
}
