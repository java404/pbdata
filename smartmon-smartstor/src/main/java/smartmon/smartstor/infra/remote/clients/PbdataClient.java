package smartmon.smartstor.infra.remote.clients;

import feign.Feign;
import lombok.extern.slf4j.Slf4j;
import smartmon.smartstor.infra.remote.general.TargetHost;
import smartmon.smartstor.infra.remote.pbdata.PbdataApi;
import smartmon.smartstor.infra.remote.pbdata.types.PbdataVersion;
import smartmon.smartstor.infra.remote.pbdata.types.nodecfg.PbdataNodeInfo;

@Slf4j
public class PbdataClient {
  private static final String DEFAULT_API_VER = "v3.0";
  private final PbdataApi pbdataApi;
  private PbdataVersion apiVersion;

  public PbdataClient(String address, int port) {
    this(new TargetHost(address, port));
  }

  public PbdataClient(TargetHost targetHost) {
    this(Feign.builder(), targetHost);
  }

  /** pbdataclient construct .*/
  public PbdataClient(Feign.Builder feign, TargetHost targetHost) {
    this.pbdataApi = new PbdataApi(feign, targetHost);
    this.apiVersion = new PbdataVersion();
    this.apiVersion.setVersion(DEFAULT_API_VER);
  }

  /** Init client. */
  public void initClient() {
    this.apiVersion = pbdataApi.getVersion();
    log.info("init pbdata client with version {}", this.apiVersion);
  }

  /** get api version. */
  public PbdataVersion getApiVersion() {
    if (apiVersion.isEmpty()) {
      initClient();
    }
    return apiVersion;
  }

  /** get node list. */
  public PbdataNodeInfo[] getNodeList() {
    return pbdataApi.getNodeList(apiVersion);
  }

  /** get node info. */
  public PbdataNodeInfo getNodeInfo() {
    return pbdataApi.getNodeInfo(apiVersion);
  }


}
