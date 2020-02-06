package com.trilogy.peoplegraph.config;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "neptune", ignoreUnknownFields = false)
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class NeptuneProperties {

    private String host;

    private int port;

    private boolean enableSsl;

    private boolean useEmbed;
}
