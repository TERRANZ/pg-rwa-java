package com.trilogy.peoplegraph.service;

import static com.trilogy.peoplegraph.util.PersonTransformer.transformPerson;

import com.trilogy.peoplegraph.Constants.Properties;
import com.trilogy.peoplegraph.entity.Person;
import com.trilogy.peoplegraph.util.PersonTransformer;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.apache.tinkerpop.gremlin.process.traversal.dsl.graph.GraphTraversalSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    private final GraphTraversalSource traversal;

    @Autowired
    PersonService(GraphTraversalSource traversal) {
        this.traversal = traversal;
    }

    public List<Person> findAll() {
        final List<Map<String, Object>> values = traversal.V().hasLabel(Person.LABEL)
            .valueMap(Properties.ID).toList();
        final List<Person> persons = new ArrayList<>();
        for (final Map<String, Object> val : values) {
            final String userId = PersonTransformer.getProperty(val, Properties.ID).toString();
            final List<Map<Object, Object>> personData = traversal.V(userId).valueMap(true).toList();
            personData.forEach(pd -> persons.add(transformPerson(pd)));
        }
        return persons;
    }
}
