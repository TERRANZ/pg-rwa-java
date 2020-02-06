package com.trilogy.peoplegraph;

import com.trilogy.peoplegraph.config.NeptuneProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication(scanBasePackages = "com.trilogy.peoplegraph")
@EnableWebMvc
@EnableConfigurationProperties(NeptuneProperties.class)
public class Main {

    public static void main(String... args) {
        SpringApplication.run(Main.class, args);
    }
}
