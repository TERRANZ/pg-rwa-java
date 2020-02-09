package com.trilogy.peoplegraph.controller;

import static org.assertj.core.api.Assertions.assertThat;

import com.trilogy.peoplegraph.entity.Person;
import com.trilogy.peoplegraph.service.PersonService;
import java.util.List;
import org.apache.tinkerpop.gremlin.process.traversal.dsl.graph.GraphTraversalSource;
import org.apache.tinkerpop.gremlin.tinkergraph.structure.TinkerGraph;
import org.junit.Before;
import org.junit.Test;

public class PersonControllerTest {

    private GraphTraversalSource traversalSource;
    private PersonService personService;
    private PersonController personController;

    @Before
    public void before() {
        traversalSource = TinkerGraph.open().traversal();
        personService = new PersonService(traversalSource);
        personController = new PersonController(personService);
    }

    @Test
    public void getAllPersonsShouldReturnNoError() {
        final List<Person> result = personController.getAllPersons();

        assertThat(result).isNotNull();
    }
}
