package slancer.mindfly.core.dto;

import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * @author Amos Xia
 * @date 2018/4/24
 */
@ControllerAdvice
public class ResponseAdvice implements ResponseBodyAdvice<Object> {

    @Override
    public boolean supports(MethodParameter methodParameter,
                            Class<? extends HttpMessageConverter<?>> convertClass) {
        if (String.class.isAssignableFrom(methodParameter.getMethod().getReturnType())) {
            return false;
        }

        return methodParameter.getMethod().isAnnotationPresent(S2u2mResponseBody.class);
    }

    @Override
    public Object beforeBodyWrite(Object o, MethodParameter methodParameter,
                                  MediaType mediaType,
                                  Class<? extends HttpMessageConverter<?>> convertClass,
                                  ServerHttpRequest serverHttpRequest,
                                  ServerHttpResponse serverHttpResponse) {
        Class<?> retClass = methodParameter.getMethod().getReturnType();
        return retClass.equals(Void.TYPE) ? ResponseBuilder.nothing()
                : ResponseBuilder.build(o, retClass);
    }
}
