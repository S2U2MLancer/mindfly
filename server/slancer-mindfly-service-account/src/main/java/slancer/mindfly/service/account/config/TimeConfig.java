package slancer.mindfly.service.account.config;

import org.springframework.context.annotation.Configuration;

import java.util.TimeZone;

/**
 * class TimeConfig
 *
 * @author xiayy860612
 * @date 2018/5/19
 */
@Configuration
public class TimeConfig {
    public static final String DefaultZone = "GMT+8";
    public static final String DateFormat = "yyyy-MM-dd HH:mm:ss";

    static {
        TimeZone.setDefault(TimeZone.getTimeZone(DefaultZone));
    }


}
