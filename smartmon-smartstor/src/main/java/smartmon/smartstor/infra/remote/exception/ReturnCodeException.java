package smartmon.smartstor.infra.remote.exception;

import com.google.common.base.Strings;
import smartmon.smartstor.infra.remote.general.ReturnCode;

public class ReturnCodeException extends ClientException {
  private static final long serialVersionUID = 7454306738603751578L;
  private final ReturnCode returnCode;

  /** Return code exception. */
  public ReturnCodeException(ReturnCode returnCode) {
    super(Strings.isNullOrEmpty(returnCode.getMessage())
        ? String.format("Hippo APIs' error return code (%d).", returnCode.getReturnCode())
        : returnCode.getMessage());
    this.returnCode = returnCode;
  }

  public ReturnCode getReturnCode() {
    return returnCode;
  }
}
