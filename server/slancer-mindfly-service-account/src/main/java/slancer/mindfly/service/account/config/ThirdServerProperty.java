package slancer.mindfly.service.account.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;

@Component
@PropertySource("classpath:third-server.properties")
@Getter
@Setter
public class ThirdServerProperty {
	@Value("${weChatUrl}")
	private String weChatUrl;
	@Value("${appId}")
	private String appId;
	@Value("${secret}")
	private String secret;
	@Value("${grantType}")
	private String grantType;
}
