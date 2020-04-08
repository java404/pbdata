package smartmon.smartstor.interfaces.web.representation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import smartmon.smartstor.domain.gateway.repository.StorageHostRepository;
import smartmon.smartstor.domain.model.StorageHost;
import smartmon.smartstor.interfaces.web.representation.assembler.StorageHostDtoAssembler;
import smartmon.smartstor.interfaces.web.representation.dto.StorageHostDto;

@Service
public class HostRepresentationService {
  @Autowired
  private StorageHostRepository storageHostRepository;

  public List<StorageHostDto> getStorageHosts() {
    List<StorageHost> storageHosts = storageHostRepository.getAll();
    return StorageHostDtoAssembler.toDtoList(storageHosts);
  }
}
