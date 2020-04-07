package smartmon.utilities.misc;

import org.apache.commons.lang3.StringUtils;

import java.util.regex.Pattern;

public class StringUtil {

  /** 判断ip是否合法. */
  public static boolean isIP(String ip){
    if (StringUtils.isBlank(ip)){
      return false;
    }
    String reg = "^$|^((25[0-5]|2[0-4]\\d|[01]?\\d\\d?)($|(?!\\.$)\\.)){4}$";
    return Pattern.matches(reg, ip);
  }
}
