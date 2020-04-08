package smartmon.smartstor.interfaces.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import smartmon.smartstor.app.HostAppService;
import smartmon.smartstor.app.command.HostInitCommand;
import smartmon.smartstor.interfaces.web.representation.HostRepresentationService;
import smartmon.smartstor.interfaces.web.representation.dto.StorageHostDto;
import smartmon.smartstor.interfaces.web.representation.vo.HostInitVo;

@RestController
@RequestMapping("api/v1/hosts")
public class HostController {
  @Autowired
  private HostAppService hostAppService;
  @Autowired
  private HostRepresentationService hostRepresentationService;

  @GetMapping
  public List<StorageHostDto> getHosts() {
    return hostRepresentationService.getStorageHosts();
  }

  @PostMapping("init")
  public void initHosts(@RequestBody HostInitVo vo) {
    hostAppService.initHosts(new HostInitCommand(vo.getServiceIp()));
  }
}
