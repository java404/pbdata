package smartmon.smartstor.client;

import org.junit.Test;
import smartmon.smartstor.clients.PbdataClient;
import smartmon.smartstor.clients.pbdata.types.PbdataVersion;
import smartmon.smartstor.clients.pbdata.types.nodecfg.PbdataNodeInfo;
import smartmon.smartstor.service.SmartManagerService;

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
    final PbdataClient pbDataClient = smartManagerService.getPbDataClient("172.24.12.107", 9000);
    final PbdataNodeInfo[] nodeList = pbDataClient.getNodeList();
    System.out.println(nodeList);
  }

  @Test
  public void getNodeInfoTest() {
    SmartManagerService smartManagerService = new SmartManagerService();
    final PbdataClient pbDataClient = smartManagerService.getPbDataClient("172.24.12.218", 9000);
    final PbdataNodeInfo nodeInfo = pbDataClient.getNodeInfo();
    System.out.println(nodeInfo);
  }

}
