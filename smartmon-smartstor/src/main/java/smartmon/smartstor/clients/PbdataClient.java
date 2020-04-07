package smartmon.smartstor.clients;

import feign.Feign;
import lombok.extern.slf4j.Slf4j;
import smartmon.smartstor.clients.general.TargetHost;
import smartmon.smartstor.clients.pbdata.PbdataApi;
import smartmon.smartstor.clients.pbdata.types.PbdataVersion;
import smartmon.smartstor.clients.pbdata.types.nodecfg.PbdataNodeInfo;

@Slf4j
public class PbdataClient {
  private static final String DEFAULT_API_VER = "v3.0";
  private final PbdataApi pbdataApi;
  private static PbdataVersion apiVersion;

  public PbdataClient(String address, int port) {
    this(new TargetHost(address, port));
  }

  public PbdataClient(TargetHost targetHost) {
    this(Feign.builder(), targetHost);
  }

  /** pbdataclient construct .*/
  public PbdataClient(Feign.Builder feign, TargetHost targetHost) {
    this.pbdataApi = new PbdataApi(feign, targetHost);
    apiVersion = new PbdataVersion();
    apiVersion.setVersion(DEFAULT_API_VER);
  }

  /** Init client. */
  public void initClient() {
    apiVersion = pbdataApi.getVersion();
    log.info("init pbdata client with version {}", apiVersion);
  }

  /** get api version. */
  public PbdataVersion getApiVersion() {
    if (apiVersion.isEmpty()) {
      initClient();
    }
    return apiVersion;
  }

  public PbdataNodeInfo[] getNodeList() {
    return pbdataApi.getNodeList(apiVersion);
  }

  public PbdataNodeInfo getNodeInfo() {
    return pbdataApi.getNodeInfo(apiVersion);
  }


}
