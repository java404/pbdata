package smartmon.smartstor.infra.remote.pbdata.feign;

import com.alibaba.fastjson.JSONObject;
import feign.Headers;
import feign.Param;
import feign.RequestLine;
import org.springframework.web.bind.annotation.RequestBody;
import smartmon.smartstor.infra.remote.general.TargetResponse;

public interface PbdataThreeFeign {

  /**
   * 添加节点
   * POST: http://ip:port/api/version/instances/node.
   */
  @RequestLine("POST /api/{version}/instances/node")
  @Headers({"Content-Type: application/json", "Accept: application/json"})
  TargetResponse nodeAdd(@Param("version") String version,
                         @RequestBody JSONObject params);

  /**
   * 删除节点
   * DELETE: http://ip:port/api/version/instances/node.
   */
  @RequestLine("DELETE /api/{version}/instances/node")
  @Headers({"Content-Type: application/json", "Accept: application/json"})
  TargetResponse nodeDel(@Param("version") String version,
                         @RequestBody JSONObject params);

  /**
   * 节点配置
   * PATCH : http://ip:port/api/version/instances/node.
   */
  @RequestLine("PATCH /api/{version}/instances/node")
  @Headers({"Content-Type: application/json","Accept: application/json"})
  TargetResponse nodeConfig(@Param("version") String version,
                            @RequestBody JSONObject params);

  /**
   * 添加节点到节点组
   * PATCH : http://ip:port/api/version/instances/node..
   */
  @RequestLine("PATCH /api/{version}/instances/node")
  @Headers({"Content-Type: application/json","Accept: application/json"})
  TargetResponse nodeAddToGroup(@Param("version") String version,
                                @RequestBody JSONObject params);

  /**
   * 从节点组中移除节点
   * PATCH : http://ip:port/api/version/instances/node..
   */
  @RequestLine("PATCH /api/{version}/instances/node")
  @Headers({"Content-Type: application/json","Accept: application/json"})
  TargetResponse nodeDelToGroup(@Param("version") String version,
                                @RequestBody JSONObject params);

  /**
   * 添加组
   * POST: http://ip:port/api/version/instances/group.
   */
  @RequestLine("POST /api/{version}/instances/group/add")
  @Headers({"Content-Type: application/json","Accept: application/json"})
  TargetResponse groupAdd(@Param("version") String version,
                          @RequestBody JSONObject params);

  /**
   * 删除组
   * DELETE: http://ip:port/api/version/instances/group.
   */
  @RequestLine("DELETE /api/{version}/instances/group")
  @Headers({"Content-Type: application/json","Accept: application/json"})
  TargetResponse groupDel(@Param("version") String version,
                          @RequestBody JSONObject params);

  /**
   * 获取节点组列表
   * GET : http://ip:port/api/version/instances/group.
   */
  @RequestLine("GET api/{version}/instances/group")
  @Headers({"Content-Type: application/json","Accept: application/json"})
  TargetResponse groupList(@Param("version") String version);


}
