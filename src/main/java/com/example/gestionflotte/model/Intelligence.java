package com.example.gestionflotte.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "intelligence")
public class Intelligence {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idintel;

    @Column(name = "applications")
    private String applications;

    @Column(name = "titre")
    private String titre;

    @Column(name = "descriptions")
    private String descriptions;

    @Column(name="Creation")
    private String creation;
}
