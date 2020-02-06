package com.trilogy.peoplegraph.config;

import org.apache.tinkerpop.gremlin.driver.Cluster;
import org.apache.tinkerpop.gremlin.driver.remote.DriverRemoteConnection;
import org.apache.tinkerpop.gremlin.process.traversal.dsl.graph.GraphTraversalSource;
import org.apache.tinkerpop.gremlin.structure.util.empty.EmptyGraph;
import org.apache.tinkerpop.gremlin.tinkergraph.structure.TinkerGraph;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class NeptuneConfig implements INeptuneConfig {

    private static final int MAX_CONTENT_LENGTH = 67208864;

    private final NeptuneProperties neptuneProperties;

    @Autowired
    public NeptuneConfig(final NeptuneProperties neptuneProperties) {
        this.neptuneProperties = neptuneProperties;
    }

    @Override
    @Bean
    public GraphTraversalSource graphTraversalSource() {
        if (neptuneProperties.isUseEmbed()) {
            return TinkerGraph.open().traversal();
        } else {
            final Cluster cluster = Cluster.build()
                .addContactPoint(neptuneProperties.getHost())
                .port(neptuneProperties.getPort())
                .maxContentLength(MAX_CONTENT_LENGTH)
                .enableSsl(neptuneProperties.isEnableSsl())
                .create();
            return EmptyGraph.instance().traversal().withRemote(DriverRemoteConnection.using(cluster));
        }
    }
}
