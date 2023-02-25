package com.joshua.config.autoconfig;

import com.joshua.config.ConditionalMyOnClass;
import com.joshua.config.MyAutoConfiguration;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;

@MyAutoConfiguration
@ConditionalMyOnClass("org.apache.catalina.startup.Tomcat")
public class TomcatWebServerConfiguration {
    @Bean("tomcatWebServerFactory")
    public ServletWebServerFactory servletWebServerFactory () {
        return new TomcatServletWebServerFactory();
    }
}
