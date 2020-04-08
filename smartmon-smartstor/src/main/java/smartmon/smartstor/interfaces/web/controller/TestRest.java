package smartmon.smartstor.interfaces.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import smartmon.smartstor.infra.remote.pbdata.service.PbdataStorageApiService;
import smartmon.smartstor.infra.remote.pbdata.types.PbdataVersion;

@Controller
@RequestMapping("api/v1")
public class TestRest {

  @Autowired
  private PbdataStorageApiService pbdataStorageApiService;

  @GetMapping("version")
  @ResponseBody
  public PbdataVersion getVersion(@RequestParam String serviceIp) {
    return pbdataStorageApiService.getApiVersion(serviceIp);
  }
}
