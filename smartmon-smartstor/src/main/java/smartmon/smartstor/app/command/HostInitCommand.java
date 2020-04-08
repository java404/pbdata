package smartmon.smartstor.app.command;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import smartmon.smartstor.app.Command;

@Data
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class HostInitCommand extends Command {
  private String serviceIp;
}
