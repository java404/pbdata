package smartmon.smartstor.interfaces.web.representation.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "disk delete model")
public class DiskDelVo {
  @ApiModelProperty(value = "service ip", position = 1)
  private String serviceIp;
  @ApiModelProperty(value = "disk name", position = 2)
  private String diskName;
}
