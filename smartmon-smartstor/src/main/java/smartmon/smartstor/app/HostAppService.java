package smartmon.smartstor.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import smartmon.smartstor.app.command.HostInitCommand;
import smartmon.smartstor.domain.service.HostInitService;

@Service
public class HostAppService {
  @Autowired
  private HostInitService hostInitService;

  public void initHosts(HostInitCommand hostInitCommand) {
    hostInitService.initHosts(hostInitCommand.getServiceIp());
  }
}
