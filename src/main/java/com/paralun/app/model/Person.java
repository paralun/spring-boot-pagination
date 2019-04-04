package com.paralun.app.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "t_person")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "seqTable")
    @TableGenerator(name = "seqTable", table = "seq_table", pkColumnName = "seq_name",
            pkColumnValue = "person_seq", valueColumnName = "seq_value")
    @Column(name = "person_id")
    private Long personId;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "age")
    private int age;
}
