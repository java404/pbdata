package smartmon.smartstor.infra.remote.pbdata.service;

import org.springframework.stereotype.Service;
import smartmon.smartstor.infra.remote.clients.PbdataClient;
import smartmon.smartstor.infra.remote.general.TargetHost;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class SmartManagerService {
  private Map<TargetHost, PbdataClient> clients = new ConcurrentHashMap<>();

  /** Get Client. */
  public PbdataClient getPbdataClient(String address, int port) {
    final TargetHost targetHost = new TargetHost(address, port);
    PbdataClient pbdataClient = clients.get(targetHost);
    if (pbdataClient != null) {
      return pbdataClient;
    }
    synchronized(this) {
      final PbdataClient client = new PbdataClient(targetHost);
      client.initClient();
      clients.put(targetHost, client);
      return client;
    }
  }
}
