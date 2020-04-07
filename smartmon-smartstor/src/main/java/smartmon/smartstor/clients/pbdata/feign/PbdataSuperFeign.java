package smartmon.smartstor.clients.pbdata.feign;

import feign.Headers;
import feign.Param;
import feign.RequestLine;
import smartmon.smartstor.clients.general.TargetResponse;
import smartmon.smartstor.clients.pbdata.types.PbdataVersion;

public interface PbdataSuperFeign {

  /**
   * 获取API版本
   * GET : http://ip:port/api/version.
   */
  @RequestLine("GET /api/version")
  @Headers({"Content-Type: application/json","Accept: application/json"})
  PbdataVersion getVersion();

  /**
   * 获取节点列表
   * GET : http://ip:port/api/version/instances/node/list.
   */
  @RequestLine("GET /api/{version}/instance/node/list")
  @Headers({"Content-Type: application/json", "Accept: application/json"})
  TargetResponse getNodeList(@Param("version") String version);

  /**
   *  获取节点信息
   *  GET : http://ip:port/api/version/instances/node.
   **/
  @RequestLine("GET /api/{version}/instances/node")
  @Headers({"Content-Type: application/json","Accept: application/json"})
  TargetResponse getNodeInfo(@Param("version") String version);

}
