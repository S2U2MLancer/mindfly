package slancer.mindfly.service.account.config;

import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Component
@PropertySource("classpath:third-server.properties")
@Getter
@Setter
public class ThirdServerProperty {
	private String wechatUrl;
}
