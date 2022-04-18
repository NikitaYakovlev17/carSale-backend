package com.yakovlev.car.sale.config.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

@Data
@Validated
@ConfigurationProperties("application")
public class ApplicationProperties {
    private String version;
    private String title;
    private String description;
    private String basePackage;
}
