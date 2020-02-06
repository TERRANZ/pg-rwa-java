package com.trilogy.peoplegraph.service;

import com.trilogy.peoplegraph.entity.Person;
import java.util.List;
import org.apache.tinkerpop.gremlin.process.traversal.dsl.graph.GraphTraversalSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    private final GraphTraversalSource graphTraversalSource;

    @Autowired
    PersonService(GraphTraversalSource graphTraversalSource) {
        this.graphTraversalSource = graphTraversalSource;
    }

    public List<Person> findAll() {
        return null;
    }
}
