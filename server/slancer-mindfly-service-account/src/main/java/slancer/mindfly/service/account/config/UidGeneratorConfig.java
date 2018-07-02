package slancer.mindfly.service.account.config;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import slancer.mindfly.core.uid.SnowFlakeUidGenerator;

/**
 * class UidGeneratorConfig
 *
 * @author xiayy860612
 * @date 2018/5/19
 */
@Configuration
public class UidGeneratorConfig {

	@Bean
	SnowFlakeUidGenerator generator() throws Exception {
		Instant start = ZonedDateTime.of(
			2018, 5, 1,
			0, 0, 0, 0,
			ZoneId.of(TimeConfig.DefaultZone)).toInstant();
		return new SnowFlakeUidGenerator(start, 1);
	}
}
