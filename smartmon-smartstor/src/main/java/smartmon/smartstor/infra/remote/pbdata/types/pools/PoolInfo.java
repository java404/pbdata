package smartmon.smartstor.infra.remote.pbdata.types.pools;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PoolInfo {
  @JsonProperty("pool_id")
  private String poolId;
  @JsonProperty("pool_name")
  private String poolName;
  @JsonProperty("disk")
  private PoolDiskInfo disk;
  @JsonProperty("extent")
  private Long extent;
  @JsonProperty("bucket")
  private Long bucket;
  @JsonProperty("sippet")
  private Long sippet;
  @JsonProperty("dirty_thresh")
  private PoolDirtyThresh dirtyThresh;
  @JsonProperty("sync_level")
  private Integer syncLevel;
  @JsonProperty("skip_thresh")
  private Integer skipThresh;
  @JsonProperty("is_variable")
  private Boolean isVariable;
  @JsonProperty("ext_actual_state")
  private Boolean extActualState;
  @JsonProperty("ext_lht")
  private Long extLht;
  @JsonProperty("ext_pool_export_info")
  private PoolExportInfo extPoolExportInfo;
  @JsonProperty("ext_cache_model")
  private Integer extCacheModel;
  @JsonProperty("ext_pmt_size")
  private Long extPmtSize;
  @JsonProperty("ext_total_cachehit_rate")
  private Double extTotalCachehitRate;
  @JsonProperty("ext_read_cachehit_rate")
  private Double extReadCachehitRate;
  @JsonProperty("ext_write_cachehit_rate")
  private Double extWriteCachehitRate;

}
