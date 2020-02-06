package com.trilogy.peoplegraph.config;

import org.apache.tinkerpop.gremlin.process.traversal.dsl.graph.GraphTraversalSource;
import org.springframework.context.annotation.Bean;

public interface INeptuneConfig {

    @Bean
    GraphTraversalSource graphTraversalSource();
}
