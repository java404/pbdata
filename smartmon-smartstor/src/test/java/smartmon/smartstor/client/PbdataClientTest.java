package smartmon.smartstor.client;

import org.junit.Test;
import smartmon.smartstor.infra.remote.clients.PbdataClient;
import smartmon.smartstor.infra.remote.pbdata.service.SmartManagerService;
import smartmon.smartstor.infra.remote.pbdata.types.PbdataVersion;
import smartmon.smartstor.infra.remote.pbdata.types.nodecfg.PbdataNodeInfo;

public class PbdataClientTest {

  @Test
  public void pbdataVersionTest() {
    PbdataClient pbdataClient = new PbdataClient("172.24.12.218", 9000);
    final PbdataVersion apiVersion = pbdataClient.getApiVersion();
    System.out.println(apiVersion);
  }

  @Test
  public void getNodeListTest() {
    SmartManagerService smartManagerService = new SmartManagerService();
    final PbdataClient pbDataClient = smartManagerService.getPbdataClient("172.24.12.218", 9000);
    final PbdataNodeInfo[] nodeList = pbDataClient.getNodeList();
    for (PbdataNodeInfo pbdataNodeInfo : nodeList) {
      System.out.println(pbdataNodeInfo);
    }
  }

  @Test
  public void getNodeInfoTest() {
    SmartManagerService smartManagerService = new SmartManagerService();
    final PbdataClient pbDataClient = smartManagerService.getPbdataClient("172.24.12.218", 9000);
    final PbdataNodeInfo nodeInfo = pbDataClient.getNodeInfo();
    System.out.println(nodeInfo);
  }

}
