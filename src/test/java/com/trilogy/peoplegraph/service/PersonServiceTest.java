package com.trilogy.peoplegraph.service;

import static org.assertj.core.api.Assertions.assertThat;

import com.trilogy.peoplegraph.entity.Person;
import java.util.List;
import org.apache.tinkerpop.gremlin.process.traversal.dsl.graph.GraphTraversalSource;
import org.apache.tinkerpop.gremlin.tinkergraph.structure.TinkerGraph;
import org.junit.Before;
import org.junit.Test;

public class PersonServiceTest {

    private GraphTraversalSource traversalSource;
    private PersonService personService;

    @Before
    public void before() {
        traversalSource = TinkerGraph.open().traversal();
        personService = new PersonService(traversalSource);
    }

    @Test
    public void findAllShouldReturnNoError() {
        final List<Person> result = personService.findAll();

        assertThat(result).isNotNull();
    }
}
