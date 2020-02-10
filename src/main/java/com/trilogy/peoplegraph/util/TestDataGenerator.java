package com.trilogy.peoplegraph.util;

import static com.trilogy.peoplegraph.Constants.Properties.ADDRESS;
import static com.trilogy.peoplegraph.Constants.Properties.EXT_ID;
import static com.trilogy.peoplegraph.Constants.Properties.FIRST_NAME;
import static com.trilogy.peoplegraph.Constants.Properties.LAST_NAME;
import static com.trilogy.peoplegraph.Constants.Properties.POSITION;
import static org.apache.tinkerpop.gremlin.structure.VertexProperty.Cardinality.single;

import com.trilogy.peoplegraph.entity.Person;
import java.util.UUID;
import org.apache.tinkerpop.gremlin.process.traversal.dsl.graph.GraphTraversalSource;
import org.apache.tinkerpop.gremlin.structure.T;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestDataGenerator {

    private final GraphTraversalSource graphTraversalSource;

    @Autowired
    public TestDataGenerator(GraphTraversalSource graphTraversalSource) {
        this.graphTraversalSource = graphTraversalSource;
    }

    public void genTestData() {
        for (int i = 0; i < 100; i++) {
            graphTraversalSource.addV(Person.LABEL)
                .property(single, FIRST_NAME, "Name " + i)
                .property(single, LAST_NAME, "Surname " + i)
                .property(single, POSITION, "Contractor")
                .property(single, ADDRESS, "Home " + i)
                .property(single, EXT_ID, UUID.randomUUID().toString())
                .next();
        }
        System.out.println("Count: " + graphTraversalSource.V().count().next());
    }
}
