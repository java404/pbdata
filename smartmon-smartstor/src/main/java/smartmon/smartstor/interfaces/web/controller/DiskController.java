package smartmon.smartstor.interfaces.web.controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import smartmon.smartstor.app.DiskAppService;
import smartmon.smartstor.app.command.DiskAddCommand;
import smartmon.smartstor.app.command.DiskDelCommand;
import smartmon.smartstor.interfaces.web.representation.DiskRepresentationService;
import smartmon.smartstor.interfaces.web.representation.dto.DiskDto;
import smartmon.smartstor.interfaces.web.representation.vo.DiskAddVo;
import smartmon.smartstor.interfaces.web.representation.vo.DiskDelVo;

@RestController
@RequestMapping("api/v1/disks")
public class DiskController {
  @Autowired
  private DiskAppService diskAppService;
  @Autowired
  private DiskRepresentationService diskRepresentationService;

  @GetMapping
  public List<DiskDto> getDisks() {
    return diskRepresentationService.getDisks();
  }

  @PostMapping
  public void addDisk(@RequestBody DiskAddVo vo) {
    DiskAddCommand command = new DiskAddCommand();
    BeanUtils.copyProperties(vo, command);
    diskAppService.addDisk(command);
  }

  @DeleteMapping
  public void delDisk(@RequestBody DiskDelVo vo) {
    DiskDelCommand command = new DiskDelCommand();
    BeanUtils.copyProperties(vo, command);
    diskAppService.delDisk(command);
  }
}
