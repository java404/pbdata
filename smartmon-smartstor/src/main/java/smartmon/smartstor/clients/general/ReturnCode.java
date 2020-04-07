package smartmon.smartstor.clients.general;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class ReturnCode {

  @JsonProperty("retcode")
  private int returnCode;

  private String message;

  @JsonIgnore
  public boolean isOk() {
    return 0 == returnCode;
  }

  public static ReturnCode okStatus() {
    return new ReturnCode(0, null);
  }
}
