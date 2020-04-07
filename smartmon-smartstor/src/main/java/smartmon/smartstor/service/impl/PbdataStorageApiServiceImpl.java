package smartmon.smartstor.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import smartmon.smartstor.clients.pbdata.types.PbdataVersion;
import smartmon.smartstor.service.PbdataStorageApiService;
import smartmon.smartstor.service.SmartManagerService;
import smartmon.utilities.misc.StringUtil;

@Slf4j
@Service
public class PbdataStorageApiServiceImpl implements PbdataStorageApiService {

  @Autowired
  private SmartManagerService smartManagerService;

  @Override
  public PbdataVersion getApiVersion(String serviceIp) {
    if (StringUtil.isIP(serviceIp)) {
      log.warn("=====>PbdataStorageApiServiceImpl.getApiVersion: The storage service IP is invalid...");
      return null;
    } else {
      //smartManagerService.getPbDataClient(serviceIp, )
    }
    return null;
  }
}
