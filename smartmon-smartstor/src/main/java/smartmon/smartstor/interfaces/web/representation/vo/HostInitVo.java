package smartmon.smartstor.interfaces.web.representation.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "host init model")
public class HostInitVo {
  @ApiModelProperty(value = "service ip", position = 1)
  private String serviceIp;
}
