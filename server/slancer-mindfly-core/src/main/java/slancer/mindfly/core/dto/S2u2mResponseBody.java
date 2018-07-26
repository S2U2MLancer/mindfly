package slancer.mindfly.core.dto;

import org.springframework.web.bind.annotation.ControllerAdvice;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@ControllerAdvice
public @interface S2u2mResponseBody {
}
