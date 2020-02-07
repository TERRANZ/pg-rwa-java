package com.trilogy.peoplegraph.util;

import org.apache.tinkerpop.gremlin.process.traversal.dsl.graph.GraphTraversalSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestDataGenerator {

    private final GraphTraversalSource graphTraversalSource;

    @Autowired
    TestDataGenerator(GraphTraversalSource graphTraversalSource) {
        this.graphTraversalSource = graphTraversalSource;
    }

    public void genTestData() {

    }
}
