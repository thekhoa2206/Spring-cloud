package com.sapo.coffeeshop.models.entity;


import javax.persistence.*;
import java.util.Date;

@MappedSuperclass
//@Getter
//@Setter
public class BaseEntity {
    @Id // xác định đây là khoá chính.
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto-increment.
    @Column(name = "id")
    private Integer id;

}
