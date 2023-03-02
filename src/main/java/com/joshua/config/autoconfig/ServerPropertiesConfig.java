package com.joshua.config.autoconfig;

import com.joshua.config.MyAutoConfiguration;
import org.springframework.boot.context.properties.bind.Binder;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;

import java.util.Objects;

@MyAutoConfiguration
public class ServerPropertiesConfig {

    @Bean
    public ServerProperties serverProperties(Environment env) {
        ServerProperties serverProperties = new ServerProperties();
        serverProperties.setContextPath(env.getProperty("contextPath"));
        serverProperties.setPort(Integer.parseInt(Objects.requireNonNull(env.getProperty("port"))));

        return Binder.get(env).bind("", ServerProperties.class).get();
    }

}
