package org.springframework.remoting;

import org.springframework.stereotype.Component;

import java.lang.annotation.*;
import java.rmi.registry.Registry;

/**
 * Created by Administrator on 2014/12/8.
 */
@Target({ ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Component
public @interface RmiServiceProperty {
    int registryPort() default Registry.REGISTRY_PORT;
}
