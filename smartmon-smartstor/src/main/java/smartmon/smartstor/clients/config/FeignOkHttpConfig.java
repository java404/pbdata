package smartmon.smartstor.clients.config;

import java.util.concurrent.TimeUnit;

import lombok.Getter;
import lombok.Setter;
import okhttp3.ConnectionPool;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "serviceApi.pbdataStorage")
@Getter
@Setter
public class FeignOkHttpConfig {
  private Integer port;
  private Integer connectTimeout;
  private Integer readTimeout;
  private Integer writeTimeout;
  private Integer maxldleConnections;
  private Integer keepAliveDuration;

  /** config okhttp client. */
  public static okhttp3.OkHttpClient okHttpClient() {
    return new okhttp3.OkHttpClient.Builder()
      .connectTimeout(60, TimeUnit.SECONDS)   //设置连接超时
      .readTimeout(60, TimeUnit.SECONDS)      //设置读超时
      .writeTimeout(60, TimeUnit.SECONDS)     //设置写超时
      .retryOnConnectionFailure(true)                 //是否自动重连
      .connectionPool(new ConnectionPool(500, 5L, TimeUnit.MINUTES))  //构建OkHttpClient对象 可配置连接池.最大闲置数和保持存活时间
      .build();
  }
}
