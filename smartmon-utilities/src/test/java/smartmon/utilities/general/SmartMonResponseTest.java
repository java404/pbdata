package smartmon.utilities.general;

import org.junit.Test;

public class SmartMonResponseTest {
  @Test
  public void testBuilder() {
    final SmartMonResponse<String> response = new SmartMonResponse<>(0, "test");
    System.out.println(response.toString());

    final SmartMonResponse<String> response2 = new SmartMonResponse<>("test2");
    System.out.println(response2.toString());
  }
}
