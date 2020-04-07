package smartmon.smartstor.clients.general;

import feign.Feign;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import feign.okhttp.OkHttpClient;
import smartmon.smartstor.clients.config.FeignOkHttpConfig;


public class ClientApi {
  protected final Feign.Builder feign;
  protected final TargetHost targetHost;
  protected final String hostUrlPrefix;

  /** Client API. */
  public ClientApi(Feign.Builder feign, TargetHost targetHost) {
    this(feign, targetHost, false);
  }

  /** Client API (http/https). */
  public ClientApi(Feign.Builder feign, TargetHost targetHost, boolean isHttps) {
    this.hostUrlPrefix = targetHost.makeServerUrl(isHttps);
    this.feign = feign.encoder(new JacksonEncoder())
                      .decoder(new JacksonDecoder())
                      .client(new OkHttpClient(FeignOkHttpConfig.okHttpClient()));
    this.targetHost = targetHost;
  }
}
