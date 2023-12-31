package com.dev.lib.services;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Import(MapperConfiguration.class)
public @interface EnableMapperConfiguration {
}
