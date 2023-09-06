package com.ltech.ltech.Entity;

import javax.persistence.*;

import lombok.*;

@Entity
@Table(name = "Formulario")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FormsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String lastname;
    private String email;
    private String telephone;
    private String message;
    private Boolean attended;
}
