package com.trilogy.peoplegraph.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Person {

    public static final String LABEL = "person";

    private String id;
    private String firstName;
    private String lastName;
    private String position;
    private String extId;

}
