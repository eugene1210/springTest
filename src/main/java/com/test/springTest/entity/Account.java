package com.test.springTest.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Account {

    @Id
    private Long id;
    private String nameRu;
    private String nameKz;
    private Long stateId;

}
