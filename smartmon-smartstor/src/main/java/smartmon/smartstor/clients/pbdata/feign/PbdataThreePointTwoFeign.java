package smartmon.smartstor.clients.pbdata.feign;

import com.alibaba.fastjson.JSONObject;
import feign.Headers;
import feign.Param;
import feign.RequestLine;
import org.springframework.web.bind.annotation.RequestBody;
import smartmon.smartstor.clients.general.TargetResponse;

public interface PbdataThreePointTwoFeign extends PbdataSuperFeign {

  /**
   * 配置节点信息
   * PATCH : http://ip:port/api/v3/instances/node.
   */
  @RequestLine("PATCH /api/{version}/instances/node")
  @Headers({"Content-Type: application/json", "Accept: application/json"})
  TargetResponse nodeConfig(@Param("version") String version,
                            @RequestBody JSONObject params);

  /**
   * 添加Initgroup
   * POST : http://ip:port/api/v3/instances/initgroups.
   */
  @RequestLine("POST /api/{version}/instances/initgroups")
  @Headers({"Content-Type: application/json", "Accept: application/json"})
  TargetResponse initGroupAdd(@Param("version") String version,
                              @RequestBody JSONObject params);

  /**
   * 删除Initgroup
   * DELETE : http://ip:port/api/v3/instances/initgroups/string:initgroup_name.
   */
  @RequestLine("DELETE /api/{version}/instances/initgroups/{initgroup_name}")
  @Headers({"Content-Type: application/json", "Accept: application/json"})
  TargetResponse initGroupDel(@Param("version") String version,
                              @Param("initgroup_name") String initGroupName);

  /**
   * Initgroup添加节点
   * POST : http://ip:port/api/v3/instances/initgroups/string:initgroup_name/nodes.
   */
  @RequestLine("POST /api/{version}/instances/initgroups/{initgroup_name}/nodes")
  @Headers({"Content-Type: application/json", "Accept: application/json"})
  TargetResponse initGroupAddNode(@Param("version") String version,
                                  @Param("initgroup_name") String initGroupName,
                                  @RequestBody JSONObject params);

  /**
   * Initgroup删除节点
   * DELETE : http://ip:port/api/v3/instances/initgroups/string:initgroup_name/nodes/string:node_name.
   */
  @RequestLine("DELETE /api/{version}/instances/initgroups/{initgroup_name}/nodes/{node_name}")
  @Headers({"Content-Type: application/json", "Accept: application/json"})
  TargetResponse initGroupDelNode(@Param("version") String version,
                                  @Param("initgroup_name") String initGroupName,
                                  @Param("node_name") String nodeName);

  /**
   * 获取Initgroup组列表
   * GET : http://ip:port/api/v3/instances/initgroups.
   */
  @RequestLine("GET /api/{version}/instances/initgroups")
  @Headers({"Content-Type: application/json", "Accept: application/json"})
  TargetResponse getInitGroupList(@Param("version") String version);

  /**
   * 通过组名称获取Initgroup信息
   * GET : http://ip:port/api/v3/instances/initgroups/string:initgroup_name.
   */
  @RequestLine("GET /api/{version}/instances/initgroups/{initgroup_name}")
  @Headers({"Content-Type: application/json", "Accept: application/json"})
  TargetResponse getInitGroupInfoByName(@Param("version") String version,
                                        @Param("initgroup_name") String initGroupName);

  /**
   * 通过组id获取Initgroup组列表
   * GET : http://ip:port/api/v3/instances/initgroups/id/string:initgroup_id.
   */
  @RequestLine("GET /api/{version}/instances/initgroups/id/{initgroup_id}")
  @Headers({"Content-Type: application/json", "Accept: application/json"})
  TargetResponse getInitGroupListById(@Param("version") String version,
                                      @Param("initgroup_id") String initGroupId);

  /**
   * Initgroup配置
   * PATCH : http://ip:port/api/v3/instances/initgroups/string:initgroup_name.
   */
  @RequestLine("PATCH /api/{version}/instances/initgroups/{initgroup_name}")
  @Headers({"Content-Type: application/json", "Accept: application/json"})
  TargetResponse initGroupConfig(@Param("version") String version,
                                 @Param("initgroup_name") String initGroupName);

  /**
   * Initgroup配置node信息
   * PATCH : http://ip:port/api/v3/instances/initgroups/string:initgroup_name/nodes/string:node_name.
   */
  @RequestLine("PATCH /api/{version}/instances/initgroups/{initgroup_name}/nodes/{node_name}")
  @Headers({"Content-Type: application/json", "Accept: application/json"})
  TargetResponse initGroupConfigNodeInfo(@Param("version") String version,
                                         @Param("initgroup_name") String initGroupName,
                                         @Param("node_name") String nodeName);


}
