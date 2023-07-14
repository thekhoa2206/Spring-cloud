package com.sapo.coffeeshop.models.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Table(name = "roles")
@Entity
@Getter
@Setter
public class Role extends BaseEntity {
    @Column(name = "code")
    private String code;

    @Column(name = "name")
    private String name;

}
