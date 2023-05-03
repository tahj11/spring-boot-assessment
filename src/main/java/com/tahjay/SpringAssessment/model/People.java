package com.tahjay.SpringAssessment.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@ToString
@Entity
public class People {
    @Id
    @GeneratedValue
    private int id;

    @Column(nullable = false)
    private String name;

    private int birth;

}
