package com.joshua.config.autoconfig;

import com.joshua.config.MyAutoConfiguration;
import com.joshua.config.MyConfigurationProperties;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.boot.context.properties.bind.Binder;
import org.springframework.context.annotation.Bean;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.core.env.Environment;

import java.util.Map;

@MyAutoConfiguration
public class PropertyPostProcessorConfig {

    @Bean
    BeanPostProcessor propertyPostProcessor(Environment env){
        return new BeanPostProcessor() {
            @Override
            public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {

                MyConfigurationProperties annotation = AnnotationUtils.findAnnotation(bean.getClass(), MyConfigurationProperties.class); // bean 에 찾고싶은 annotation 이 붙어있는지 확인하여 해당 annotation 을 가지고 온다.

                if (annotation == null) return bean;

                Map<String, Object> annotationAttributes = AnnotationUtils.getAnnotationAttributes(annotation);
                String prefix = String.valueOf(annotationAttributes.get("prefix")); // annotation 의 필드인 prefix 라는 값을 가지고 온다.

                return Binder.get(env).bindOrCreate(prefix, bean.getClass()); // property 정보 binding
            }
        };
    }
}
