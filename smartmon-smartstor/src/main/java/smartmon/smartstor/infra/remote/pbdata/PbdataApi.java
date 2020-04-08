package smartmon.smartstor.infra.remote.pbdata;

import com.alibaba.fastjson.JSONObject;
import feign.Feign;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import smartmon.smartstor.infra.remote.exception.ClientParseException;
import smartmon.smartstor.infra.remote.exception.ReturnCodeException;
import smartmon.smartstor.infra.remote.general.ClientApi;
import smartmon.smartstor.infra.remote.general.TargetHost;
import smartmon.smartstor.infra.remote.general.TargetResponse;
import smartmon.smartstor.infra.remote.pbdata.feign.PbdataSuperFeign;
import smartmon.smartstor.infra.remote.pbdata.feign.PbdataThreeFeign;
import smartmon.smartstor.infra.remote.pbdata.feign.PbdataThreePointTwoFeign;
import smartmon.smartstor.infra.remote.pbdata.types.PbdataVersion;
import smartmon.smartstor.infra.remote.pbdata.types.constant.PbdataStorageConstants;
import smartmon.smartstor.infra.remote.pbdata.types.nodecfg.PbdataNodeInfo;
import smartmon.smartstor.infra.remote.pbdata.types.nodecfg.PbdataNodeInfoItem;
import smartmon.smartstor.infra.remote.pbdata.types.nodecfg.PbdataNodeListItem;

@Slf4j
public class PbdataApi extends ClientApi {

  public PbdataApi(Feign.Builder feign, TargetHost targetHost) {
    super(feign, targetHost);
  }

  /**
   * judge version.
   */
  public static boolean judgeVersion(PbdataVersion apiVersion) {
    return PbdataStorageConstants.compareVersion(apiVersion, PbdataStorageConstants.V3_2);
  }

  /**
   * Get pbdata version.
   */
  public PbdataVersion getVersion() {
    return feign.target(PbdataSuperFeign.class, hostUrlPrefix).getVersion();
  }

  /**
   * Get Node list.
   */
  public PbdataNodeInfo[] getNodeList(PbdataVersion apiVersion) {
    final PbdataNodeListItem item = feign.target(PbdataSuperFeign.class, hostUrlPrefix)
      .getNodeList(apiVersion.getVersion())
      .makeResponse(PbdataNodeListItem.getKeyNodeList(apiVersion), PbdataNodeListItem.class);
    return item == null ? null : item.getNodeInfos(apiVersion);
  }

  /**
   * Get Node Info.
   */
  public PbdataNodeInfo getNodeInfo(PbdataVersion apiVersion) throws ClientParseException, ReturnCodeException {
    final PbdataNodeInfoItem item = feign.target(PbdataSuperFeign.class, hostUrlPrefix)
      .getNodeInfo(apiVersion.getVersion()).makeResponse(PbdataNodeInfoItem.KEY_NODE_INFO, PbdataNodeInfoItem.class);
    return item == null ? null : item.getNodeInfo();
  }

  /**
   * Node Add To Group.
   */
  public TargetResponse nodeAddToGroup(PbdataVersion apiVersion, String groupName, String nodeName) {
    JSONObject params = new JSONObject();
    if (judgeVersion(apiVersion)) {
      params.put("node_name", nodeName);
      return feign.target(PbdataThreePointTwoFeign.class, hostUrlPrefix)
        .initGroupAddNode(apiVersion.getVersion(), groupName, params);
    } else {
      params.put("node_name", nodeName);
      if (StringUtils.isNotBlank(groupName)) {
        params.put("group_name", groupName);
      }
      return feign.target(PbdataThreeFeign.class, hostUrlPrefix)
        .nodeAdd(apiVersion.getVersion(), params);
    }
  }

  /**
   * Node Del To Group.
   */
  public TargetResponse nodeDelToGroup(PbdataVersion apiVersion, String nodeIndex,
                                String groupName, String nodeName) {
    JSONObject params = new JSONObject();
    if (judgeVersion(apiVersion)) {
      return feign.target(PbdataThreePointTwoFeign.class, hostUrlPrefix)
        .initGroupDelNode(apiVersion.getVersion(), groupName, nodeName);
    } else {
      params.put("node_index", nodeIndex);
      params.put("group_name", groupName);
      params.put("del_group", true);
      return feign.target(PbdataThreeFeign.class, hostUrlPrefix)
        .nodeDelToGroup(apiVersion.getVersion(), params);
    }
  }

  /**
   *  Node Add For V3.0
   */
  public TargetResponse nodeAdd(PbdataVersion apiVersion, String nodeName, String groupName) {
    JSONObject params = new JSONObject();
    params.put("node_name", nodeName);
    if (StringUtils.isNotBlank(groupName)) {
      params.put("group_name", groupName);
    }
    return feign.target(PbdataThreeFeign.class, hostUrlPrefix)
      .nodeAdd(apiVersion.getVersion(), params);
  }

  /**
   *  Node Del For V3.0
   */
  public TargetResponse nodeDel(PbdataVersion apiVersion, String nodeIndex) {
    JSONObject params = new JSONObject();
    params.put("node_index", nodeIndex);
    return feign.target(PbdataThreeFeign.class, hostUrlPrefix)
      .nodeDel(apiVersion.getVersion(), params);
  }

  /**
   * Group Add
   */
  public TargetResponse groupAdd(PbdataVersion apiVersion, String groupName, String groupInfo) {
    JSONObject params = new JSONObject();
    if (judgeVersion(apiVersion)) {
      params.put("initgroup_name", groupName);
      if (StringUtils.isNotBlank(groupInfo)) {
        params.put("initgroup_info", groupInfo);
      }
      return feign.target(PbdataThreePointTwoFeign.class, hostUrlPrefix)
        .initGroupAdd(apiVersion.getVersion(), params);
    } else {
      params.put("group_name", groupName);
      return feign.target(PbdataThreeFeign.class, hostUrlPrefix)
        .groupAdd(apiVersion.getVersion(), params);
    }
  }

  /**
   * Group Del
   */
  public TargetResponse groupDel(PbdataVersion apiVersion, String groupName) {
    JSONObject params = new JSONObject();
    if (judgeVersion(apiVersion)) {
      return feign.target(PbdataThreePointTwoFeign.class, hostUrlPrefix)
        .initGroupDel(apiVersion.getVersion(), groupName);
    } else {
      params.put("group_name", groupName);
      return feign.target(PbdataThreeFeign.class, hostUrlPrefix)
        .groupAdd(apiVersion.getVersion(), params);
    }
  }

}
