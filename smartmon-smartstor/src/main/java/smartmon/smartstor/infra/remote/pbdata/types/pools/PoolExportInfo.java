package smartmon.smartstor.infra.remote.pbdata.types.pools;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
public class PoolExportInfo {
  @JsonProperty("pool_name")
  private String poolName;
  @JsonProperty("state_str")
  private String stateStr;
  @JsonProperty("valid")
  private Long valid;
  @JsonProperty("p_valid")
  private Double poolValid;
  @JsonProperty("dirty")
  private Long dirty;
  @JsonProperty("p_dirty")
  private Double poolDirty;
  @JsonProperty("error")
  private Long error;
  @JsonProperty("lower_thresh")
  private Long lowerThresh;
  @JsonProperty("p_lower_thresh")
  private Integer poolLowerThresh;
  @JsonProperty("upper_thresh")
  private Long upperThresh;
  @JsonProperty("p_upper_thresh")
  private Integer poolUpperThresh;
  @JsonProperty("size")
  private Long size;
  @JsonProperty("max_size")
  private Long maxSize;
  @JsonProperty("dev_name")
  public String[] devName;
  @JsonProperty("extent")
  private Long extent;
  @JsonProperty("bucket")
  private Long bucket;
  @JsonProperty("sippet")
  private Long sippet;
  @JsonProperty("state")
  private Integer state;
  @JsonProperty("state_exp")
  private String stateExp;
  @JsonProperty("is_variable")
  private Boolean isVariable;

}
