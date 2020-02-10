package com.trilogy.peoplegraph.service;

import static com.trilogy.peoplegraph.util.PersonTransformer.transformPerson;

import com.trilogy.peoplegraph.entity.Person;
import com.trilogy.peoplegraph.util.PersonTransformer;
import com.trilogy.peoplegraph.util.TestDataGenerator;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.apache.tinkerpop.gremlin.process.traversal.dsl.graph.GraphTraversalSource;
import org.apache.tinkerpop.gremlin.structure.T;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    private final GraphTraversalSource traversal;

    @Autowired
    public PersonService(GraphTraversalSource traversal) {
        this.traversal = traversal;
        new TestDataGenerator(traversal).genTestData();
    }

    public List<Person> findAll() {
        final List<Map<Object, Object>> values = traversal.V().hasLabel(Person.LABEL).valueMap(true).toList();
        final List<Person> persons = new ArrayList<>();
        for (final Map<Object, Object> val : values) {
            final Long userId = Long.valueOf(PersonTransformer.getProperty(val, T.id).toString());
            final List<Map<Object, Object>> personData = traversal.V(userId).valueMap(true).toList();
            personData.forEach(pd -> persons.add(transformPerson(pd)));
        }
        return persons;
    }
}
