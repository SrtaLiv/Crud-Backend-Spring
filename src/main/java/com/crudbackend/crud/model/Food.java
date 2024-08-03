package com.crudbackend.crud.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.awt.*;

@Data
@NoArgsConstructor
@Entity
public class Food {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int amount;

    private String unit; //gr, kg..

    //@OneToOne(cascade = CascadeType.ALL)
    //@JoinColumn(name = "image_id", referencedColumnName = "id")
   // private Image image;


}
