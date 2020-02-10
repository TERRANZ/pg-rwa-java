package com.trilogy.peoplegraph.util;

import static com.trilogy.peoplegraph.Constants.Properties.ADDRESS;
import static com.trilogy.peoplegraph.Constants.Properties.EXT_ID;
import static com.trilogy.peoplegraph.Constants.Properties.FIRST_NAME;
import static com.trilogy.peoplegraph.Constants.Properties.LAST_NAME;
import static com.trilogy.peoplegraph.Constants.Properties.POSITION;

import com.trilogy.peoplegraph.entity.Person;
import java.util.Collection;
import java.util.Map;
import lombok.experimental.UtilityClass;
import org.apache.tinkerpop.gremlin.structure.T;

@UtilityClass
public class PersonTransformer {

    public static Person transformPerson(final Map<Object, Object> values) {
        return Person.builder()
            .id(getProperty(values, T.id).toString())
            .firstName(getProperty(values, FIRST_NAME).toString())
            .lastName(getProperty(values, LAST_NAME).toString())
            .position(getProperty(values, POSITION).toString())
            .extId(getProperty(values, EXT_ID).toString())
            .address(getProperty(values, ADDRESS).toString())
            .build();
    }

    @SuppressWarnings("unchecked")
    public static Object getProperty(Map values, Object key) {
        final Object object = values.get(key);
        if (object instanceof Collection) {
            return ((Collection) object).stream().findFirst().orElse(null);
        }
        return object;
    }
}
