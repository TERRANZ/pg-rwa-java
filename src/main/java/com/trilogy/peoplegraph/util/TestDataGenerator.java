package com.trilogy.peoplegraph.util;

import com.trilogy.peoplegraph.Constants.Properties;
import com.trilogy.peoplegraph.entity.Person;
import java.util.UUID;
import org.apache.tinkerpop.gremlin.process.traversal.dsl.graph.GraphTraversalSource;
import org.apache.tinkerpop.gremlin.structure.VertexProperty.Cardinality;
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
        graphTraversalSource.V().drop();

        graphTraversalSource.V().addV(Person.LABEL)
                .property(Cardinality.single, Properties.FIRST_NAME, "John")
                .property(Cardinality.single, Properties.LAST_NAME, "Smith")
                .property(Cardinality.single, Properties.POSITION, "Contractor")
                .property(Cardinality.single, Properties.EXT_ID, UUID.randomUUID().toString())
                .next();

    }
}
