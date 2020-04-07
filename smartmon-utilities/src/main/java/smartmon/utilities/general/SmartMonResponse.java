package smartmon.utilities.general;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class SmartMonResponse<T> {
  private final int errno;
  private final T content;

  public SmartMonResponse(int errno, T content) {
    this.errno = errno;
    this.content = content;
  }

  public SmartMonResponse(T content) {
    this(0, content);
  }
}
