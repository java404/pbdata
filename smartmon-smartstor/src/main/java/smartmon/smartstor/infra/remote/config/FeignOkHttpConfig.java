package smartmon.smartstor.infra.remote.config;

import java.util.concurrent.TimeUnit;

import lombok.Getter;
import okhttp3.ConnectionPool;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
@Getter
public class FeignOkHttpConfig {
  public static Integer port; // 访问端口
  private static Integer connectTimeout; // 连接超时时间
  private static Integer readTimeout; // 读超时时间
  private static Integer writeTimeout; // 写超时时间
  private static Integer maxldleConnections; // 最大闲置数
  private static Long keepAliveDuration; // 保持存活时间

  @Value("${service-api.pbdata-storage.port}")
  public void setPort(Integer port) {
    FeignOkHttpConfig.port = port;
  }

  @Value("${service-api.pbdata-storage.readTimeout}")
  public void setReadTimeout(Integer readTimeout) {
    FeignOkHttpConfig.readTimeout = readTimeout;
  }

  @Value("${service-api.pbdata-storage.writeTimeout}")
  public void setWriteTimeout(Integer writeTimeout) {
    FeignOkHttpConfig.writeTimeout = writeTimeout;
  }

  @Value("${service-api.pbdata-storage.maxldleConnections}")
  public void setMaxldleConnections(Integer maxldleConnections) {
    FeignOkHttpConfig.maxldleConnections = maxldleConnections;
  }

  @Value("${service-api.pbdata-storage.keepAliveDuration}")
  public void setKeepAliveDuration(Long keepAliveDuration) {
    FeignOkHttpConfig.keepAliveDuration = keepAliveDuration;
  }

  @Value("${service-api.pbdata-storage.connectTimeout}")
  public void setConnectTimeout(Integer connectTimeout) {
    FeignOkHttpConfig.connectTimeout = connectTimeout;
  }

  /** config okhttp client. */
  public static okhttp3.OkHttpClient okHttpClient() {
    return new okhttp3.OkHttpClient.Builder()
      .connectTimeout(60, TimeUnit.SECONDS)   //设置连接超时
      .readTimeout(60, TimeUnit.SECONDS)      //设置读超时
      .writeTimeout(60, TimeUnit.SECONDS)     //设置写超时
      .retryOnConnectionFailure(true)                 //是否自动重连
      .connectionPool(new ConnectionPool(500, 5L, TimeUnit.MINUTES))  //构建OkHttpClient对象 可配置连接池
      .build();
  }

}
