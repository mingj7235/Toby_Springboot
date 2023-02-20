package com.joshua.config;

import org.springframework.context.annotation.DeferredImportSelector;
import org.springframework.core.type.AnnotationMetadata;

public class MyAutoConfigurationImportSelector implements DeferredImportSelector {

    @Override
    public String[] selectImports(final AnnotationMetadata importingClassMetadata) {
        return new String[] {
                "com.joshua.config.autoconfig.DispatcherServletConfig",
                "com.joshua.config.autoconfig.TomcatWebServerConfiguration"
        };
    }
}
